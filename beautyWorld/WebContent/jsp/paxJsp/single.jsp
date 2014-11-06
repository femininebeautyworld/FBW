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
				<div class="single_inside_content">
					<c:choose>
						<c:when test="${fn:length(post.postPictureContents) > 0 }">
							<c:if test="${fn:length(post.postPictureContents) > 1 }">
								<link rel="stylesheet" href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/responsiveslides.css">
								<link rel="stylesheet" href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/themes.css">
								<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
								<script src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/responsiveslides.min.js"></script>
								<script>
									// You can also use "$(window).load(function() {"
									$(function() {

										// Slideshow 1
										$("#slider1").responsiveSlides({
											auto : false,
											pager : true,
											nav : true,
											speed : 500,
											maxwidth : 400,
											namespace : "centered-btns"
										});

									});
								</script>
								<!--//Multi_Pic_inside_content-->
								<div id="wrapper">
									<br> <br> <br> <br>
									<h1 class="single_title" align="center">
										<c:out value="${post.postTitle}" />
									</h1>
									<!-- Slideshow 1 -->
									<div class="rslides_container">
										<ul class="rslides" id="slider1">
											<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
												<li><img width="600" height="800" src="${postPictureContent.postPicture}">
													<p style="color: #222222;" align="left">
														<span style="color: #666666;"> 
														    <c:if test="${post.postViewType ne 'straight'}">
																<c:out value="${postPictureContent.postPictureDescription}" escapeXml="false" />
															</c:if>
														</span>
													</p></li>
											</c:forEach>
										</ul>
									</div>
									<c:if test="${post.postViewType eq 'straight'}">
										<c:out value="${post.postDescription}" escapeXml="false" />
									</c:if>
								</div>
							</c:if>

							<c:if test="${fn:length(post.postPictureContents) eq 1 }">
								<br>
								<br>
								<br>
								<br>
								<h1 class="single_title" align="center">
									<c:out value="${post.postTitle}" />
								</h1>
								<!--//Single_Pic_inside_content-->
								<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
									<p style="color: #222222;">
										<c:forEach var="postVideoContent" items="${post.postPictureContents}" varStatus="loop">
											<img width="600" height="800" alt="img2" src="${postPictureContent.postPicture}">
										</c:forEach>
									</p>
								</c:forEach>
								<p style="color: #222222;">
									<span style="color: #666666;"><c:out value="${post.postDescription}" escapeXml="false" /></span>
								</p>
								<!--//Single_Pic_inside_content-->
							</c:if>
						</c:when>
						<c:otherwise>
							<br>
							<br>
							<br>
							<br>
							<h1 class="single_title" align="center">
								<c:out value="${post.postTitle}" />
							</h1>
							<c:forEach var="postVideoContent" items="${post.postVideoContents}" varStatus="loop">
								<!--//video_inside_content-->
								<p>
									<iframe frameborder="0" width="850" height="480" allowfullscreen="allowfullscreen" src="${postVideoContent.postVideoUrl}"> </iframe>
								</p>
								<p style="color: #222222;">
									<span style="color: #666666;"><c:out value="${post.postDescription}" escapeXml="false" /></span>
								</p>
							</c:forEach>
						</c:otherwise>
					</c:choose>
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