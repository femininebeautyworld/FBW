<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<div id="home_cont">
		<div id="stalac_cont" class="gridalicious">
			<!-- //stalac_box -->
			<c:forEach var="post" items="${posts}" varStatus="loop">
			<c:if test="${loop.index % 5 eq 0}">
			<div class="galcolumn" id="item${loop.index+1}MAwUE" style="width: 48.0867%; padding-left: 30px; padding-bottom: 30px; float: left; box-sizing: border-box;">
			</c:if>
				<div class="item stalac_box" style="margin-bottom: 30px; opacity: 1;">
				<c:choose>
				    <c:when test="${post.postPictureUrl ne null}">
					<span class="stalac_box_img"> <a href="http://dessign.net/sidegridtheme/female-photography-design/"><img width="683" height="1024" alt="img2" class="attachment-large wp-post-image"
							src="${post.postPictureUrl}" style="width: 100%; height: auto; display: block; margin-left: auto; margin-right: auto;"></a>
					</span>
					<!-- //stalac_box_img -->
					<h3>
						<a href="http://dessign.net/sidegridtheme/female-photography-design/">${post.postTitle}</a>
					</h3>
					<p>${post.postDescription}</p>
					</c:when>
					<c:otherwise>
					<span class="stalac_box_img"> <iframe frameborder="0" width="500" height="338" allowfullscreen="" mozallowfullscreen="" webkitallowfullscreen=""
							src="${post.postVidUrl}" style="width: 100%; height: auto; display: block; margin-left: auto; margin-right: auto;"></iframe>

					</span>
					<!-- //stalac_box_img -->
					<h3>
						<a href="http://dessign.net/sidegridtheme/another-video-post/">${post.postTitle}</a>
					</h3>
					<p>${post.postVideoDesc}</p>
					</c:otherwise>
				</c:choose>
				</div>
			<c:if test="${(loop.index ne 0 && (loop.index+1) % 5 eq 0 ) || (loop.index+1) eq fn:length(posts) }">
			</div>
			</c:if>
			</c:forEach>
			<div style="clear: both; height: 0px; width: 0px; display: block;" id="clearMAwUE"></div>
		</div>
		<!--//stalac_cont-->
	</div>
	<!--//home_cont-->