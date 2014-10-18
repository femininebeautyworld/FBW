<%@ page import="main.java.com.beauty.util.RequestUtils"%>
<ul>
	<li>
		<h2>Categories</h2>
		<ul>
			<li><a href="#">About Us</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/viewPosts.do">Home</a></li>
			<li><a href="<%=RequestUtils.getBaseURI(request)%>/createPostActivity.do?method=display">Create Post</a></li>
			<li><a href="#">Contact Us</a></li>
		</ul>
	</li>
</ul>