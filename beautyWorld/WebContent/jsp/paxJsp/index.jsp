<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<script type="text/javascript">
$(document).ready(function () {
    $('#no_data').hide();
});
</script>
<script type="text/javascript">
    var count = 3;
    var pgNumber = 1;
    var alignment = 'left';
	function ajaxRequest() {
		var mygetrequest;
		pgNumber = pgNumber + 1;
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
			mygetrequest=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
			mygetrequest=new ActiveXObject("Microsoft.XMLHTTP");
		  }

		mygetrequest.onreadystatechange = function() {
			if (mygetrequest.readyState == 4) {
				if (mygetrequest.status == 200
						|| window.location.href.indexOf("http") == -1) {
					var jsondata = eval("(" + mygetrequest.responseText + ")");//retrieve result as an JavaScript object
					var rssentries = jsondata;
					if( rssentries.toString().length > 0 )
					{
					var output = '<table><tr><td><div id="home_cont"> <div id="stalac_cont" class="gridalicious">';
					var host = "<%=RequestUtils.getBaseURI(request)%>";
					count = count + 1;
					for (var i = 0; i < rssentries.length; i++) {
						if( i % 4 == 0)
						{
						output += '<div class="galcolumn" id="item'+(count)+'hmd4K" style="width: 32.5865073437889%; padding-left: 30px; padding-bottom: 30px; float:'+alignment+'; box-sizing: border-box;">';
						}
						output += '<div class="item stalac_box" style="margin-bottom: 30px; opacity: 1;">';
						if( rssentries[i].postPictureUrl != null )
                               {
							output += '<span class="stalac_box_img"> <a href="'+host+'/viewPaxDetailPost.do?method=displayPost&postId='+rssentries[i].postId+'"><img width="'+rssentries[i].imageWidth+'" height="'+rssentries[i].imageHeight+'" alt="img2" class="attachment-large wp-post-image" src="'+rssentries[i].postPictureUrl+'" style="width: 100%; height: auto; display: block; margin-left: auto; margin-right: auto;"></a> </span> <h3> <a href="'+host+'/viewPaxDetailPost.do?method=displayPost&postId='+rssentries[i].postId+'">'+rssentries[i].postTitle+'</a></h3>';
								if( rssentries[i].postDescription != null )
								{
									output += '<p class="item stalac_box">'+rssentries[i].postDescription.substring(0, 150)+'....</p>';
								}
                               }
						else
							{
							output += '<span class="stalac_box_img"> <iframe frameborder="0" width="340" height="200" allowfullscreen="" mozallowfullscreen="" webkitallowfullscreen="" src="//'+rssentries[i].postVidUrl+'"></iframe></span>';
							output += '<h3> <a href="'+host+'/viewPaxDetailPost.do?method=displayPost&postId='+rssentries[i].postId+'">'+rssentries[i].postTitle+'</a></h3>';
							if( rssentries[i].postVideoDesc != null )
							{
								output += '<p class="item stalac_box">'+rssentries[i].postVideoDesc.substring(0, 150)+'....</p>';
							}
							}
					output += '</div>';
					if( (i != 0 && ( (i+1) % 4 == 0 ) ) ||  (i+1) == rssentries.length )
					{
						output += '</div>';
						count=count+1;
					}
					}
					output += '</div></div></td></tr></table>';
					
					$( output ).insertBefore( $( ".homecont" ) );
					}
					else
					{
						document.getElementById('button').style.display = 'none';
						document.getElementById('no_data').style.display = 'block';
					}
					/* var para = document.createElement('div');
					para.innerHTML = output;
					var element = document.getElementById("home_cont");
					element.prepend(para); */
				} else {
					alert("An error has occured making the request");
				}
			}
		};
	    mygetrequest.open("GET", "<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&callType='ajax'&pageNumber="+pgNumber+"",true);
		mygetrequest.send();
	}
</script>
<c:set var="count" scope="application" value="1"/>
<table>
<tr>
<td>
<div id="home_cont">
	<div id="stalac_cont" class="gridalicious">
			<!-- //stalac_box -->
			<c:forEach var="post" items="${posts}" varStatus="loop">
				<c:if test="${loop.index % 4 eq 0}">
					<div class="galcolumn" id="item${count}hmd4K" style="width: 32.5865073437889%; padding-left: 30px; padding-bottom: 30px; float: left; box-sizing: border-box;">
				</c:if>
				<div class="item stalac_box" style="margin-bottom: 30px; opacity: 1;">
					<c:choose>
						<c:when test="${post.postPictureUrl ne null}">
							<span class="stalac_box_img"> <a href="<%=RequestUtils.getBaseURI(request)%>/viewPaxDetailPost.do?method=displayPost&postId=${post.postId}"><img width="${post.imageWidth}"
									height="${post.imageHeight}" alt="img2" class="attachment-large wp-post-image" src="/beautyWorld/${post.postPictureUrl}" data-original="/beautyWorld/${post.postPictureUrl}"
									style="width: 100%; height: auto; display: block; margin-left: auto; margin-right: auto;"></a>
							</span>
							<!-- //stalac_box_img -->
							<h3>
								<a href="<%=RequestUtils.getBaseURI(request)%>/viewPaxDetailPost.do?method=displayPost&postId=${post.postId}">${post.postTitle}</a>
							</h3>
							<c:if test="${post.postDescription ne null}">
								<p class="item stalac_box">
									<c:out value="${fn:substring(post.postDescription, 0, 150)}" />
									....
								</p>
							</c:if>
						</c:when>
						<c:otherwise>
							<span class="stalac_box_img"><iframe frameborder="0" width="340" height="200" allowfullscreen="" mozallowfullscreen="" webkitallowfullscreen="" src="//${post.postVidUrl}"></iframe> </span>
							<!-- //stalac_box_img -->
							<h3>
								<a href="<%=RequestUtils.getBaseURI(request)%>/viewPaxDetailPost.do?method=displayPost&postId=${post.postId}">${post.postTitle}</a>
							</h3>
							<c:if test="${post.postVideoDesc ne null}">
								<p class="item stalac_box">
									<c:out value="${fn:substring(post.postVideoDesc, 0, 150)}" />
									....
								</p>
							</c:if>
						</c:otherwise>
					</c:choose>
				</div>
				<c:if test="${(loop.index ne 0 && (loop.index+1) % 4 eq 0 ) || (loop.index+1) eq fn:length(posts) }">
		</div>
		<c:set var="count" scope="application" value="${count+1}" />
		</c:if>
		</c:forEach>

	</div>
<!--//stalac_cont-->
</div>
</td>
</tr>
</table>
<div id="home_cont" class="homecont" align="center"> 
<div style="clear: both; height: 0px; width: 0px; display: block;" id="clearhmd4K"></div>
<div id="no_data">No more world to view</div>
<c:choose>
<c:when test="${fn:length(posts) gt 0}">
<button id="button" style="width: 150px; height: 30px" type="button" onclick="ajaxRequest()">View More</button>
</c:when>
<c:otherwise>
<div id="first_no_data">No more world to view</div>
</c:otherwise>
</c:choose>
<br>
<br>
<br>
<br>
<br>
</div>
<!-- //home_cont -->