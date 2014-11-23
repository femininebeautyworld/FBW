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
							<link rel="stylesheet" href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/responsiveslides.css">
							<link rel="stylesheet" href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/themes.css">
							<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
							<script src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/responsiveslides.min.js"></script>
							<script>
											// You can also use "$(window).load(function() {"
											$(function() {

												// Slideshow 1
												$("#slider1")
														.responsiveSlides(
																{
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
							<div id="wrapper" align="center">
								<br> <br> <br> <br>
								<!-- Slideshow 1 -->
								<c:if test="${post.postViewType eq 'alternate'}">
									<div class="rslides_container">
									<h1 class="single_title">
									<c:out value="${post.postTitle}" />
								    </h1>
										<ul class="rslides" id="slider1">
											<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
												<li><img width="600" height="800" src="${postPictureContent.postPicture}">
													<p style="color: #222222;" align="left">
														<span style="color: #666666;"> <c:out value="${postPictureContent.postPictureDescription}" escapeXml="false" />
														</span>
													</p></li>
											</c:forEach>
										</ul>
									</div>
								</c:if>
								<c:if test="${post.postViewType eq 'alternateHorizontal'}">
									<div align="center">
										<h1 class="single_title">
											<c:out value="${post.postTitle}" />
										</h1>
										<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
											<p>
												<img width="600" height="800" src="${postPictureContent.postPicture}">
											</p>
											<p style="color: #222222;">
												<span style="color: #666666;"><c:out value="${postPictureContent.postPictureDescription}" escapeXml="false" /></span>
											</p>

											<!--//video_inside_content-->
											<c:if test="${postPictureContent.postPicVideoUrl ne null}">
												<p>
													<iframe frameborder="0" width="850" height="480" allowfullscreen="allowfullscreen" src="//${postPictureContent.postPicVideoUrl}"> </iframe>
												</p>
												<p style="color: #222222;">
													<span style="color: #666666;"><c:out value="${postPictureContent.postPicVideoDesc}" escapeXml="false" /></span>
												</p>
                                           </c:if>
										</c:forEach>
									</div>
								</c:if>
								<c:if test="${post.postViewType eq 'straight'}">
									<div class="rslides_container">
									<h1 class="single_title">
									<c:out value="${post.postTitle}" />
								    </h1>
										<ul class="rslides" id="slider1">
											<c:forEach var="postPictureContent" items="${post.postPictureContents}" varStatus="loop">
												<li><img width="600" height="800" src="${postPictureContent.postPicture}"></li>
											</c:forEach>
										</ul>
									</div>
									<p style="color: #222222;">
										<span style="color: #666666;"><c:out value="${post.postDescription}" escapeXml="false" /></span>
									</p>
								</c:if>
							</div>
						</c:when>
						<c:otherwise>
							<br>
							<br>
							<br>
							<br>
							<div align="center">
								<h1 class="single_title">
									<c:out value="${post.postTitle}" />
								</h1>
								<c:forEach var="postVideoContent" items="${post.postVideoContents}" varStatus="loop">
									<!--//video_inside_content-->

									<table style="border-spacing: 35px;">
										<tr align="left">
											<td><p>
													<iframe frameborder="0" width="850" height="480" allowfullscreen="allowfullscreen" src="//${postVideoContent.postVideoUrl}"> </iframe>
												</p>
											<td>
											<td align="right"><iframe
													src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2FFeminineBeautyWorld&amp;width&amp;height=290&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true"
													scrolling="no" frameborder="0" style="border: none; overflow: hidden; height: 290px;" allowTransparency="true"></iframe></td>
										</tr>
									</table>
									<p style="color: #222222;">
										<span style="color: #666666;"><c:out value="${post.postDescription}" escapeXml="false" /></span>
									</p>
								</c:forEach>
							</div>
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