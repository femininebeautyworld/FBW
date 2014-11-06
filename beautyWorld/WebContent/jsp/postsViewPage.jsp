<%@page import="java.util.*"%>
<%@page import="main.java.com.beauty.domain.Posts"%>
<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<%@ include file="/jsp/taglib.jspf"%>

<html>
<head>
<jsp:include page="linkCss.jsp" />
</head>
<body>
<br>
<br>
<font face="Courier New" color="black" size="4"><b>Feminine Posts :</b></font>
<br>
<br>
<div align="center">
<c:choose>
<c:when test="${fn:length(viewPostsList) gt 0}">
		<display:table class="CSSTableGenerator" name="viewPostsList" pagesize="5" export="false" sort="list" keepStatus ="true" uid="postBean" requestURI="/viewPosts.do">
			<display:column title="Post Image" sortable="false">
				<img alt="View Image" src="http://www.infoniac.com/uimg/smile-small.jpg" />
			</display:column>
			<display:column property="postTitle" title="Post Title" sortable="true" headerClass="sortable" />
			<display:column property="postType" title="Post Type" sortable="true" headerClass="sortable" />
			<display:column property="dateCreated" title="Created" sortable="true" headerClass="sortable" />
			<display:column property="datePublished" title="Published" sortable="true" headerClass="sortable" />
			<display:column title="View Post" sortable="false" headerClass="sortable">
			<%
			  Posts temp = (Posts)pageContext.getAttribute( "postBean" );
			  pageContext.setAttribute( "viewUrl", RequestUtils.getBaseURI(request)+"/viewDetailPost.do?method=displayPost&postId="+ temp.getPostId() +"");
			%>
			<a href="<c:out value="${viewUrl}"/>"><img alt="View Image" src="/beautyWorld/img/viewPost.png" /></a>
			</display:column>
			<display:column title="Edit Post" sortable="false" headerClass="sortable">
			<%
			  Posts temp = (Posts)pageContext.getAttribute( "postBean" );
			  pageContext.setAttribute( "editUrl", RequestUtils.getBaseURI(request)+"/editPostActivity.do?method=editPost&postId="+ temp.getPostId() +"");
			%>
			<a href="<c:out value="${editUrl}"/>"><img alt="View Image" src="/beautyWorld/img/editPost.png" /></a>
			</display:column>
		</display:table>		
</c:when>
<c:otherwise>
<p> No posts to view </p>
</c:otherwise>
</c:choose>
</div>
</body>
</html>