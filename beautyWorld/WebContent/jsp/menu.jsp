<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<ul>
	<li>
		<h2>Categories</h2>
		<ul>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/viewPostsAdmin.do">Home</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType">Participant Home</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/createPostActivity.do?method=display">Create Post</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/register.do">Register</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/contactUs.do">Contact Us</a></li>
		</ul>
	</li>
</ul>