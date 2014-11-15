<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<div id="content">
	<div class="container blog_container">

		<div class="single_full_cont">
			<div class="single_left">

				<div id="posts_cont">
					<br> <br> <br> <br>
					<h1 class="single_title" align="center">
						<c:out value="${post.postTitle}" />
					</h1>
					<c:choose>
						<c:when test="${fn:length(post.postPictureContents) > 0 }">
							<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
								<div align="center">
									<img width="450" height="350" src="${postPictureContent.postPicture}" class="attachment-sb-home-image wp-post-image" alt="img4b">

									<p>
										<c:out value="${postPictureContent.postPictureDescription}" escapeXml="false" />
									</p>
									<div class="clear"></div>
								</div>
								<!--//home_post_box-->

								<div class="home_post_box clear"></div>

							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="postVideoContent" items="${post.postVideoContents}" varStatus="loop">
								<div align="center">
									<iframe frameborder="0" width="450" height="350" allowfullscreen="allowfullscreen" src="//${postVideoContent.postVideoUrl}"> </iframe>
									<p>
										<c:out value="${postVideoContent.postVideoDescription}" escapeXml="false" />
									</p>
									<div class="clear"></div>
								</div>
								<!--//home_post_box-->

								<div class="home_post_box clear"></div>

							</c:forEach> 
						</c:otherwise>
						</c:choose>
				</div>
				<!--//posts_cont-->


			</div>
			<!-- //single_left -->
			<div class="clear"></div>

		</div>
		<!--//single_full_cont-->


		<div class="clear"></div>


	</div>
	<!--//container-->
</div>