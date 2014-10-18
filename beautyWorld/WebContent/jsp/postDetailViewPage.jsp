<!DOCTYPE html>

<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/beautyWorld/css/imageCarousel.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="/beautyWorld/js/jquery.carouFredSel-6.0.4-packed.js"></script>
<script type="text/javascript">
$(function() {
	
	$('#carousel span').append('<img src="img/carousel_glare.png" class="glare" />');
	$('#thumbs a').append('<img src="img/carousel_glare_small.png" class="glare" />');
 
	$('#carousel').carouFredSel({
		responsive: true,
		circular: false,
		auto: false,
		items: {
			visible: 1,
			width: 200,
			height: '56%'
		},
		scroll: {
			fx: 'directscroll'
		}
	});
 
	$('#thumbs').carouFredSel({
		responsive: true,
		circular: false,
		infinite: false,
		auto: false,
		prev: '#prev',
		next: '#next',
		items: {
			visible: {
				min: 2,
				max: 6
			},
			width: 150,
			height: '66%'
		}
	});
 
	$('#thumbs a').click(function() {
		$('#carousel').trigger('slideTo', '#' + this.href.split('#').pop() );
		$('#thumbs a').removeClass('selected');
		$(this).addClass('selected');
		return false;
	});
 
});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="carousel-wrapper">
		<img id="shadow" src="img/carousel_shadow.png" />
			<div id="carousel">
				<c:forEach var="vidContent" items="${postVideoList}">
					<c:if test="${vidContent.postVideoUrl ne null}">
						<div>
							<iframe draggable="true" width="560" height="315" src="${vidContent.postVideoUrl}"></iframe>
						</div>
					</c:if>
				</c:forEach>

				<c:forEach var="picContent" items="${post.postPictureContents}">
					<c:if test="${picContent.postPicture ne null}">
						<span id="${fn:substringBefore(picContent.postPicture,'.')}"> <img src="${picContent.postPicture}" width="550" height="310" /></span>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div id="thumbs-wrapper">
			<div id="thumbs">
				<c:forEach var="picContent" items="${post.postPictureContents}">
					<c:if test="${picContent.postPicture ne null}">
						<a href="#${fn:substringBefore(picContent.postPicture,'.')}"> <img src="${picContent.postPicture}" width="100" height="100" /></a>
					</c:if>
				</c:forEach>
			</div>
			<a id="prev" href="#"></a>
		    <a id="next" href="#"></a>
		</div>
			<div>
				<h2>
					<c:out value="${post.postTitle}" escapeXml="false"/>
				</h2>
			</div>
			<div>
				<p>
					<c:out value="${post.postDescription}" escapeXml="false"/>
				</p>
			</div>
	</div>
</body>
</html>