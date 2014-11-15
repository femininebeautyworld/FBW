<%@page import="org.apache.catalina.connector.Request"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>
<head>
<jsp:include page="linkCss.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in</title>
</head>
<body>
	<div align="center">
		<div align="left">
			<font size="3" color="#FF0000"> <%
 	if ( request.getAttribute("alreadyExistingAccountError") != null ) {%> <%=request.getAttribute("alreadyExistingAccountError")%> <%
					}
			%>
			</font>
		</div>
		<div align="left">
		<br>
		<br>
		    <div align="center"><font class="rainbow" face="courier;bold;" size="5">Welcome to Feminine Beauty World</font></div>
			<h3>Sign in</h3>
			<html:form action="/loginActivity">
				<div align="left"></div>
				<div align="left">
					Email or User ID<br>
					<html:text styleClass="input-highlight" size="40" maxlength="64" property="emailAddress" />
					&nbsp;<font size="3" color="#FF0000"> <b><html:errors property="emailAddress" /></b></font> <br> Password <br>
					<html:password styleClass="input-highlight" size="40" maxlength="64" property="password" />
					&nbsp;<font size="3" color="#FF0000"> <b><html:errors property="password" /></b></font> <br> <span class="sd-sv"><a href="">forgot your email or user ID</a> or <a href="">forgot
							your password</a>?</span><br> <br>
				</div>
				<div align="left">
					<html:submit styleClass="button" value="Sign in" />
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>