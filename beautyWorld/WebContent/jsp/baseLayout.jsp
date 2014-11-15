<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/beautyWorld/css/baseLayout.css">
</head>
<body>
	<tiles:insert attribute="header" />
	<div id="page">
		<div class="bgtop">
			<div class="bgbtm">
				<!-- start content -->
				<div id="content"><br><br>
					<div align="right">
						<b>feminineBeautyWorld.com</b>|<a id="logOffButton" class="logOffButton" href="<%=RequestUtils.getBaseURI(request)%>/logoutActivity.do">Log off</a>
					</div>
					<div class="post">
						<tiles:insert attribute="body" />
					</div>
				</div>
				<!-- end content -->
				<!-- start menubar -->
				<div id="sidebar">
					<tiles:insert attribute="menu" />
				</div>
				<!-- end menubar -->
				<div style="clear: both">&nbsp;</div>
			</div>
		</div>
	</div>
	<tiles:insert attribute="footer" />
</body>
</html>