<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>Feminine Beauty World</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link media="all" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/jsp/paxJsp/style.css" id="cyclone-template-style-dark-css" rel="stylesheet">
<link media="all" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/jsp/paxJsp/style.css" id="cyclone-template-style-default-css" rel="stylesheet">
<link media="all" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/jsp/paxJsp/style.css" id="cyclone-template-style-standard-css" rel="stylesheet">
<link media="all" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/jsp/paxJsp/style.css" id="cyclone-template-style-thumbnails-css" rel="stylesheet">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,200">
<link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans">
<link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato: 300,400,700,900">
<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<link title="no title" media="screen" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/jsp/paxJsp/style.css" rel="stylesheet">
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<link title="no title" media="screen" type="text/css" href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/mobile.css" rel="stylesheet">
<link href="<%=RequestUtils.getBaseURI(request)%>/css/paxCss/slicknav.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/jquery.infinitescroll.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/jquery.slicknav.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/retina-1.1.0.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/flickerplate.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/jquery.stalactite.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/jquery-finger-v0.1.0.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/modernizr-custom-v2.7.1.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/jquery.carouFredSel-6.2.1.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/paxJs/scripts.js"></script>

<!--css and js for multiple image display-->



<style type="text/css">
body {
	
}
</style>
</head>
<body class="home blog">

	<tiles:insert attribute="header" />

	<tiles:insert attribute="body" />

	<tiles:insert attribute="footer" />

</body>
</html>