<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<div id="content">
	<div class="single_container">

		<div id="single_cont">

			<!--<div class="single_left single_full">-->
			<div style="position: relative;" class="single_left">

				<h1 class="single_title">
					<c:out value="${post.postTitle}" />
				</h1>

				<div class="single_inside_content">
					<c:choose>
						<c:when test="${fn:length(post.postPictureContents) > 0 }">
							<c:if test="${fn:length(post.postPictureContents) > 1 }">
								<!--//Multi_Pic_inside_content-->
								<div style="max-width: 960px" id="cycloneslider-1-1" class="cycloneslider cycloneslider-template-standard cycloneslider-width-responsive" tabindex="0">
									<div data-cycle-timeout="4000" data-cycle-tile-vertical="true" data-cycle-tile-delay="100" data-cycle-tile-count="7" data-cycle-swipe="false" data-cycle-speed="1000"
										data-cycle-slides="&gt; div" data-cycle-prev="#cycloneslider-1-1 .cycloneslider-prev" data-cycle-pause-on-hover="true" data-cycle-pager="#cycloneslider-1-1 .cycloneslider-pager"
										data-cycle-next="#cycloneslider-1-1 .cycloneslider-next" data-cycle-log="false" data-cycle-hide-non-active="true" data-cycle-fx="scrollHorz" data-cycle-easing="" data-cycle-delay="0"
										data-cycle-auto-height-speed="250" data-cycle-auto-height-easing="null" data-cycle-auto-height="960:600" data-cycle-dynamic-height="off" data-cycle-allow-wrap="true"
										class="cycloneslider-slides cycle-slideshow" style="height: 393.75px; overflow: hidden;">
										<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
											<div class="cycloneslider-slide cycloneslider-slide-image cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1;">
												<img width="600" height="800" src="${postPictureContent.postPicture}">
											</div>
										</c:forEach>
									</div>
								</div>
							</c:if>

							<c:if test="${fn:length(post.postPictureContents) eq 1 }">
								<!--//Single_Pic_inside_content-->
								<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
									<p style="color: #222222;">
										<c:forEach var="postVideoContent" items="${post.postPictureContents}" varStatus="loop">
											<img width="600" height="800" alt="img2" src="${postPictureContent.postPicture}">
										</c:forEach>
									</p>
								</c:forEach>
								<!--//Single_Pic_inside_content-->
							</c:if>
						</c:when>
						<c:otherwise>
						<c:forEach var="postVideoContent" items="${post.postVideoContents}" varStatus="loop">
							<!--//video_inside_content-->
							<p>
								<iframe frameborder="0" width="850" height="480" allowfullscreen="allowfullscreen" src="${postVideoContent.postVideoUrl}"> </iframe>
							</p>
						</c:forEach>
						</c:otherwise>
					</c:choose>
					<p style="color: #222222;">
						<span style="color: #666666;"><c:out value="${post.postDescription}" /></span>
					</p>

				</div>
				<!--//single_inside_content-->

			</div>
			<!--//single_left-->


			<div class="clear"></div>

		</div>
		<!--//single_cont-->

	</div>
	<!--//single_container-->
</div>
<!--//content-->