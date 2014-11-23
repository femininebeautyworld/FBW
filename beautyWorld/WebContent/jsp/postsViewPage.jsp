<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<html>
<head>
<jsp:include page="linkCss.jsp" />
<script type="text/javascript">

function hideDiv() {
	   document.getElementById('confirmOverlay').style.display = 'none';
	}

function deleteUrl(postId) {
	var host = "<%=RequestUtils.getBaseURI(request)%>";
	var output = '<div id="confirmOverlay"><div id="confirmBox"><h3>Are you sure. Do you want to cancel the changes ?</h3><div id="confirmButtons" align="center"><a id="yesButton" class="buttonBlue" href="'+host+'/editPostActivity.do?method=deletePost&postId='+postId+'">Yes<span></span></a> <a id="noButton" class="buttonRed" href="#" onclick="hideDiv()">No<span></span></a></div></div></div>';
	var para = document.createElement('div');
	para.innerHTML = output;
	var element = document.getElementById("confirmOverlayout");
	while(para.firstChild)
		{
		element.appendChild(para.firstChild);
		}
	}
</script>
</head>
<body>
<br>
<br>
<font face="Courier New" color="black" size="4"><b>Feminine Posts :</b></font>
<br>
<br>
<div align="center">
<c:choose>
<c:when test="${fn:length(viewPostsList) gt 0}">
		<display:table class="CSSTableGenerator" name="viewPostsList" pagesize="5" export="false" sort="list" keepStatus ="true" uid="postBean" requestURI="/viewPostsAdmin.do">
			<%
			  Posts temp = (Posts)pageContext.getAttribute( "postBean" );
			%>
			<display:column title="Delete Post" sortable="false" headerClass="sortable">
			<% 
			pageContext.setAttribute( "postId", temp.getPostId());
			%>
			<a onclick="deleteUrl(<c:out value="${postId}"/>)"><img alt="View Image" src="/beautyWorld/img/deletePost.png" /></a>
			</display:column>
			<display:column title="Edit Post" sortable="false" headerClass="sortable">
			<%
			  pageContext.setAttribute( "editUrl", RequestUtils.getBaseURI(request)+"/editPostActivity.do?method=editPost&postId="+ temp.getPostId() +"");
			%>
			<a href="<c:out value="${editUrl}"/>"><img alt="View Image" src="/beautyWorld/img/editPost.png" /></a>
			</display:column>
			<display:column title="View Post" sortable="false" headerClass="sortable">
			<%
			  pageContext.setAttribute( "viewUrl", RequestUtils.getBaseURI(request)+"/viewPaxDetailPost.do?method=displayPost&postId="+ temp.getPostId() +"");
			%>
			<a href="<c:out value="${viewUrl}"/>"><img alt="View Image" src="/beautyWorld/img/viewPost.png" /></a>
			</display:column>
			<display:column property="postType" title="Post Type" sortable="true" headerClass="sortable" />
			<display:column property="postTitle" title="Post Title" sortable="true" headerClass="sortable" />
			<display:column property="dateCreated" title="Created" sortable="true" headerClass="sortable" />
			<display:column property="datePublished" title="Published" sortable="true" headerClass="sortable" />
		</display:table>		
</c:when>
<c:otherwise>
<p> No posts to view </p>
</c:otherwise>
</c:choose>
</div>
<div id="confirmOverlayout">
</div>
</body>
</html>