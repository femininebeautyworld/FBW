<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="linkCss.jsp" />
<script>
	window.onload = function() {
		var confirmEmailAddress = document
				.getElementBystyleId('confirmEmailAddress');
		confirmEmailAddress.onpaste = function(e) {
			e.preventDefault();
		};

		var confirmPassword = document.getElementBystyleId('confirmPassword');
		confirmPassword.onpaste = function(e) {
			e.preventDefault();
		};
	};
	function callLoginAction() {
		location.href = "http://localhost:8080/beautyWorld/login.do";
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style type="text/css"></style>
</head>
<body>
	<div align="center">
		<h1>Create your Account</h1>
	</div>
	<div align="center">
		Already have an account?<br> <br>
		<html:submit styleClass="button" value="Sign in" onclick="callLoginAction()" />
		<br> <br>
	</div>
	<div align="left">
		<html:form action="/registrationActivity">
			<strong>Fill in below the required(<font size="3" color="#FF0000">*</font>) details to register
			</strong>
			<br>
			<br>
			<table>
				<tbody>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>First name</strong> &nbsp;<font size="3" color="#FF0000"> <b><html:errors property="firstName" /></b></font></th>
						<th align="left">&nbsp;&nbsp;&nbsp; <strong><font size="3" color="#FF0000">*</font>Last name</strong> &nbsp;<font size="3" color="#FF0000"> <b><html:errors property="lastName" /></b></font>
							<br>
						</th>
					</tr>
					<tr>
						<td><html:text styleClass="register-input-highlight" property="firstName" maxlength="64" size="20" /></td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;<html:text styleClass="register-input-highlight" property="lastName" maxlength="64" size="20" /><br>
						</td>
					</tr>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>Email Address</strong></th>
					</tr>
					<tr>
						<td><html:text styleClass="register-input-highlight" property="emailAddress" maxlength="64" size="46" styleId="emailAddress" /></td>
						<td>&nbsp; <font size="3" color="#FF0000"><b><html:errors property="emailAddress" /></b></font>
						</td>
					</tr>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>Confirm Email Address</strong></th>
					</tr>
					<tr>
						<td><html:text styleClass="register-input-highlight" property="confirmEmailAddress" maxlength="64" size="46" styleId="confirmEmailAddress" /></td>
						<td>&nbsp; <font size="3" color="#FF0000"><b><html:errors property="confirmEmailAddress" /></b></font>
						</td>
					</tr>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>Create your password</strong></th>
					</tr>
					<tr>
						<td><html:password styleClass="register-input-highlight" property="currentPassword" maxlength="20" size="46" /></td>
						<td>&nbsp; <font size="3" color="#FF0000"><b><html:errors property="currentPassword" /></b></font>
						</td>
					</tr>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>Confirm password</strong></th>
					</tr>
					<tr>
						<td><html:password styleClass="register-input-highlight" property="confirmPassword" maxlength="20" size="46" styleId="confirmPassword" /></td>
						<td>&nbsp; <font size="3" color="#FF0000"><b><html:errors property="confirmPassword" /></b></font>
						</td>
					</tr>
					<tr>
						<th align="left" width="200px"><strong><font size="3" color="#FF0000">*</font>Please enter the following code below</strong></th>
					</tr>
					<tr>
						<td align="left"><img src="Captcha.jpg" border="0"><br></td>
					</tr>
					<tr>
						<td><html:text styleClass="register-input-highlight" property="jcaptchaResponse" styleId="jcaptchaResponse" /></td>
						<td>&nbsp;<font size="3" color="#FF0000"><b><html:errors property="jcaptchaResponse" /></b></font>
						</td>
					</tr>
				</tbody>
			</table>
			<font style="font: bolder;" size="3"><b>By clicking "Register Now" I agree that:</b></font>
			<ul>
				<li><font size="2.5">I have read and accepted the <a href="javascript:void(0)">User Agreement</a> and <a href="javascript:void(0)">Privacy Policy</a>.
				</font></li>
				<li><font size="2.5">I may receive communications from feminine beauty world.</font></li>
				<li><font size="2.5">I am at least 18 years old.</font></li>
			</ul>
			<html:submit styleClass="button" value="Register Now" />
		</html:form>
	</div>

</body>
</html>