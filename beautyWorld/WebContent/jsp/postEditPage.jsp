<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ page import="main.java.com.beauty.form.PostActivityForm"%>
<%@ include file="/jsp/taglib.jspf"%>
<html>
<head>
<jsp:include page="linkCss.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Post</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="<%=RequestUtils.getBaseURI(request)%>/js/tiny_mce/tiny_mce.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<!-- jQuery Code executes on Date Format option ----->
<script src="<%=RequestUtils.getBaseURI(request)%>/js/script.js"></script>
<link rel="stylesheet" href="<%=RequestUtils.getBaseURI(request)%>/css/date.css">

<script type="text/javascript">
tinyMCE.init({
        // General options
        mode : "textareas",
        theme : "advanced",
        plugins : "autolink,lists,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",

        // Theme options
        theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect,fontselect,fontsizeselect",
        theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
        theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
        theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,spellchecker,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,blockquote,pagebreak,|,insertfile,insertimage",
        theme_advanced_toolbar_location : "top",
        theme_advanced_toolbar_align : "left",
        theme_advanced_statusbar_location : "bottom",
        theme_advanced_resizing : true,

        // Skin options
        skin : "o2k7",
        skin_variant : "silver",

        // Drop lists for link/image/media/template dialogs
        template_external_list_url : "js/template_list.js",
        external_link_list_url : "js/link_list.js",
        external_image_list_url : "js/image_list.js",
        media_external_list_url : "js/media_list.js"
});
</script>
<!-- <script type="text/javascript" src="js/nicEdit-latest.js"></script> -->
<!-- <script type="text/javascript">
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() }); // convert all text areas to rich text editor on that page
</script> -->
<script type="text/javascript">
$(document).ready(function () {
    $('#confirmOverlay').hide();
});

function showDiv() {
	   document.getElementById('confirmOverlay').style.display = 'block';
	}
function hideDiv() {
	   document.getElementById('confirmOverlay').style.display = 'none';
	}
function hideTextAreaDiv() {
	var view = document.getElementById("view");
	var selectedValue = view.options[view.selectedIndex].value;
	if ( selectedValue == "straight" ) {
			document.getElementById("c2").style.display = 'none';
			document.getElementById("v2").style.display = 'none';
		} else {
			document.getElementById("c2").style.display = 'block';
			document.getElementById("v2").style.display = 'block';
		}
	}
	/*  DO NOT USE WITH SUBMIT TYPE BUTTONS */
	function callUrl(urlToCall) {
		window.location = urlToCall;
	}

	function getContentFormName() {
		/*
		 for(var i = 0; i < document.forms.length;i++)
		 {
		 if(document.forms[i].id != 'quickSearchForm')
		 {
		 return document.forms[i].id;
		 }
		 }
		 */
		return "contentForm";
	}

	function getContentForm() {
		return document.forms[getContentFormName()];
	}

	function toLoginWithForm(formName) {
		document.forms[formName].action = "<%=request.getContextPath()%>/login.do";
	}
	function toLogin() {
		toLoginWithForm(getContentFormName());
	}

	function setFocusWithForm(formName) {
		document.forms[formName].elements[0].focus();
	}
	function setFocus() {
		setFocusWithForm(getContentFormName());
	}

	function setDispatchWithForm(target, formName) {
		document.forms[formName].method.value = target;
	}
	function setDispatch(target) {
		setDispatchWithForm(target, getContentFormName());
	}

	/*  DO NOT USE WITH SUBMIT TYPE BUTTONS */
	function setDispatchAndSubmitWithForm(target, formName) {
		document.forms[formName].method.value = target;
		document.forms[formName].submit();
	}
	function setDispatchAndSubmit(target) {
		setDispatchAndSubmitWithForm(target, getContentFormName());
	}

	function setActionAndDispatchWithForm(myaction, target, formName) {
		document.forms[formName].method.value = target;
		document.forms[formName].action = myaction;
	}
	function setActionAndDispatch(myaction, target) {
		setActionAndDispatchWithForm(myaction, target, getContentFormName());
	}

	/*  DO NOT USE WITH SUBMIT TYPE BUTTONS */
	function setActionDispatchAndSubmitWithForm(myaction, target, formName) {
		document.forms[formName].method.value = target;
		document.forms[formName].action = myaction;
		document.forms[formName].submit();
	}
	function setActionDispatchAndSubmit(myaction, target) {
		setActionDispatchAndSubmitWithForm(myaction, target,
				getContentFormName());
	}

	function setActionAndSubmit(myaction) {
		setActionAndSubmitWithForm(myaction, getContentFormName());
	}
	function setActionAndSubmitWithForm(myaction, formName) {
		document.forms[formName].action = myaction;
		document.forms[formName].submit();
	}

	function imgSwap(theImg, theFile) {
		image = eval("document.all." + theImg);
		image.src = "/images/" + theFile;
	}

	function ltrim(str) {
		var wspace = new String(" \t\n\r");
		var s = new String(str);
		if (wspace.indexOf(s.charAt(0)) != -1) {
			var j = 0, i = s.length;
			while (j < i && wspace.indexOf(s.charAt(j)) != -1) {
				j++;
			}
			s = s.substring(j, i);
		}
		return s;
	}

	function rtrim(str) {
		var wspace = new String(" \t\n\r");
		var s = new String(str);
		if (wspace.indexOf(s.charAt(s.length - 1)) != -1) {
			var i = s.length - 1; // Get length of string
			while (i >= 0 && wspace.indexOf(s.charAt(i)) != -1) {
				i--;
			}
			s = s.substring(0, i + 1);
		}

		return s;
	}

	function trim(str) {
		return rtrim(ltrim(str));
	}

	/*  This function is to select all options in a multi-valued <select> */
	function selectAll(elementId) {
		var element = document.getElementById(elementId);
		len = element.length;
		if (len != 0) {
			for (i = 0; i < len; i++) {
				element.options[i].selected = true;
			}
		}
	}

	var newWindow = null;

	function closeWin() {
		if (newWindow != null) {
			if (!newWindow.closed)
				newWindow.close();
		}
	}

	function popUpWinInMiddle(url, strWidth, strHeight) {
		leftVal = (640 - strWidth) / 2;
		topVal = (480 - strHeight) / 2;

		if (screen) {
			topVal = (screen.availHeight - strHeight) / 2;
			leftVal = (screen.availWidth - strWidth) / 2;
		}

		var tools = "";
		tools = "resizable,toolbar=no,location=no,scrollbars=no,width="
				+ strWidth + ",height=" + strHeight + ",left=" + leftVal
				+ ",top=" + topVal;
		newWindow = window.open(url, 'newWin', tools);
		newWindow.focus();
	}

	function popUpWin(url, type, strWidth, strHeight, closeWindowFlag,
			scrollbars) {
		if (closeWindowFlag == true) {
			closeWin();
		}

		if (type == "fullScreen") {
			strWidth = screen.availWidth - 10;
			strHeight = screen.availHeight - 160;
		}

		var strScrollbars = "no";
		if (scrollbars == true) {
			strScrollbars = "yes";
		}

		var tools = "";
		if (type == "standard" || type == "fullScreen")
			tools = "resizable,toolbar=yes,location=yes,scrollbars="
					+ strScrollbars + ",menubar=yes,width=" + strWidth
					+ ",height=" + strHeight + ",top=0,left=0";
		if (type == "console")
			tools = "resizable,toolbar=no,location=no,scrollbars="
					+ strScrollbars + ",width=" + strWidth + ",height="
					+ strHeight + ",left=0,top=0";
		newWindow = window.open(url, 'newWin', tools);
		newWindow.focus();
	}

	function popUpWinInMiddle(url, name, type, strWidth, strHeight,
			closeWindowFlag, scrollbars) {
		if (closeWindowFlag == true) {
			closeWin();
		}

		if (type == "fullScreen") {
			strWidth = screen.availWidth - 10;
			strHeight = screen.availHeight - 160;
		}

		if (screen) {
			topVal = (screen.availHeight - strHeight) / 2;
			leftVal = (screen.availWidth - strWidth) / 2;
		}

		var strScrollbars = "no";
		if (scrollbars == true) {
			strScrollbars = "yes";
		}

		var tools = "";
		if (type == "standard" || type == "fullScreen")
			tools = "resizable,toolbar=yes,location=yes,scrollbars="
					+ strScrollbars + ",menubar=yes,width=" + strWidth
					+ ",height=" + strHeight + ",left=" + leftVal + ",top="
					+ topVal;
		if (type == "console")
			tools = "resizable,toolbar=no,location=no,scrollbars="
					+ strScrollbars + ",width=" + strWidth + ",height="
					+ strHeight + ",left=" + leftVal + ",top=" + topVal;
		newWindow = window.open(url, name, tools);
		newWindow.focus();
	}

	/* Finds an element by name in the form. */
	function findElement(theForm, elementName) {
		for (var i = 0; i < theForm.elements.length; i++) {
			if ((theForm.elements[i].name.indexOf(elementName) > -1)) {
				return theForm.elements[i];
			}
		}
		return null;
	}

	/* Clears the date mask from an input field. */
	function clearDateMask(field) {
		//this date mask should match what is in DateUtils.standardDateFormat
		if (field.value == 'MM/DD/YYYY') {
			field.value = '';
		}
		field.blur();
	}

	/* Sets focus on the first visable, editable input field on the content form */
	function setFocusOnFirstInput() {
		setFocusOnInput(1);
	}

	/* Sets focus on the (## specified) visable, editable input field on the content form */
	function setFocusOnInput(number) {
		var count = 1;
		// for each element in each form
		for (i = 0; i < getContentForm().length; i++) {
			// if it's not a hidden element
			if (getContentForm()[i].type != "hidden") {
				// and it's not disabled
				if (getContentForm()[i].disabled != true) {
					if (count == number) {
						// set the focus to it
						getContentForm()[i].focus();
						break;
					} else {
						//increment count
						count++;
					}
				}
			}
		}
	}
</script>
<style type="text/css"></style>
</head>
<body>
	<div align="left">
		<html:form styleId="contentForm" action="/createPostActivity" method="post" enctype="multipart/form-data">
			<html:hidden property="method" />
			<html:hidden property="postId" />
			<html:hidden property="pictureContentsListSize" />
			<html:hidden property="pictureContentsListCount" />
			<%
				Integer pictureContentsListSize = (Integer) request
							.getSession().getAttribute("pictureContentsListSize");
					request.getSession().setAttribute("pictureContentsListSize",
							pictureContentsListSize);
			%>
			<table>
				<tbody>
					<tr>
						<td>Post Title:</td>
						<td><html:text styleClass="register-input-highlight" property="postTitle" maxlength="100" size="20" /></td>
					</tr>
					<tr>
						<td>Post Type:</td>
						<td><html:select styleClass="register-input-highlight" property="postType" size="7">
								<html:option value="" disabled="true">none</html:option>
								<html:option value="fashion">Fashion</html:option>
								<html:option value="beauty">Beauty</html:option>
								<html:option value="health">Health</html:option>
								<html:option value="hair">Hair Styles</html:option>
								<html:option value="diy">Diys</html:option>
								<html:option value="celebrity">Celebrity Fashion</html:option>
								<html:option value="jewelry">Jewelry</html:option>
								<html:option value="bags">Hand Bags</html:option>
								<html:option value="shoes">Shoes</html:option>
								<html:option value="others">Others</html:option>
							</html:select></td>
					</tr>
					<tr>
						<td>Post Display Type:</td>
						<td><html:select styleId="view" styleClass="register-input-highlight" property="postViewType" size="3">
								<html:option value="straight">Straight View</html:option>
								<html:option value="alternate">Slide View</html:option>
								<html:option value="alternateHorizontal">Alternate Horizontal View</html:option>
							</html:select></td>
					</tr>
					<tr>
					<td>Post Publish Date:</td> 
					<td><html:text styleId="datepicker" styleClass="register-input-highlight" property="datePublished" maxlength="100" size="20" /></td>
					</tr>
					<tr>
					<td>Post Publish Time:</td> 
					<td>HH:<html:text property="postHours" maxlength="2" size="2" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; MM:<html:text property="postMinutes" maxlength="2" size="2" /></td>
					</tr>
					<tr>
						<td>Post Description:</td>
						<td><html:textarea style="width: 604px; height: 150px;" styleClass="register-input-highlight" property="postDescription" rows="4" cols="50">
							</html:textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><br>
							<button type="button" class="button" onclick="setDispatchAndSubmit('updatePost')">Submit</button>&nbsp;&nbsp;
							<button type="button" class="button" onclick="showDiv()">Cancel</button></td>
					</tr>

				</tbody>
			</table>
			<div id="confirmOverlay">
				<div id="confirmBox">

					<h3>Are you sure. Do you want to cancel the changes ?</h3>

					<div id="confirmButtons" align="center">
						<a id="yesButton" class="buttonBlue" href="<%=RequestUtils.getBaseURI(request)%>/viewPostsAdmin.do">Yes<span></span></a> <a id="noButton" class="buttonRed" href="#" onclick="hideDiv()">No<span></span></a>
					</div>
				</div>
			</div>
		</html:form>
	</div>
</body>
</html>