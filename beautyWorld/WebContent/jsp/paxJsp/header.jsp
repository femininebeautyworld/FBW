<%@ page import="main.java.com.beauty.util.RequestUtils"%>

<!--<div class="side_header_spacing"></div>-->
<header id="side_header">
	<div class="side_header_inside">
		<div class="header_bottom">

			<!-- <div class="container"> -->

			<div>
				<a href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType"><img alt="logo" class="logo" src="/beautyWorld/img/paxImg/logo_pic.jpg"></a><br>
				<font size="3" face="Zapf Chancery, cursive;"><a href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType">Feminine Beauty World</a></font>
			</div>
			<!--//logo_cont-->
			<!--	
				<div class="header_right_text">
									</div> -->
			<!-- //header_right_text -->

			<div class="clear"></div>
			<div class="header_container">
				<div class="header_social">
				   Follow us on:<br>
					<a target="_blank" href="https://www.facebook.com/FeminineBeautyWorld"> <img width="25" height="25" alt="facebook" src="/beautyWorld/img/paxImg/facebook-icon@2x.png">
					</a> <a target="_blank" href="http://www.pinterest.com/vcfbw/"> <img width="25" height="25" alt="pinterest" src="/beautyWorld/img/paxImg/pinterest-icon@2x.png">
					</a> <a target="_blank" href="http://instagram.com/femininebeautyworld"> <img width="25" height="25" alt="picasa" src="/beautyWorld/img/paxImg/picasa-icon@2x.png">
					</a> <a target="_blank" href="https://plus.google.com/106495188444653564735/posts"> <img width="25" height="25" alt="google plus"
						src="/beautyWorld/img/paxImg/google-plus-icon@2x.png">
					</a>
				</div>
				<div class="clear"></div>
				<!--//header_social-->
			</div>
			<!-- //header_container -->

			<div class="header_menu">
				<ul class="menu" id="main_header_menu">
					<li class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-11" id="menu-item-11"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType">Home</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-12" id="menu-item-12"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=fashion">Fashion</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-13" id="menu-item-13"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=beauty">Beauty</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-14" id="menu-item-14"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=health">Health</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-15" id="menu-item-15"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=hair">Hair Styles</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-16" id="menu-item-16"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=diy">Diys</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-17" id="menu-item-17"><a
						href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=celebrity">Celebrity Fashion</a></li>
					<li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-132" id="menu-item-132"><a href="#">Accessories</a>
						<ul class="sub-menu" style="display: block;">
							<li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-18" id="menu-item-18"><a
								href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=jewelry">Jewelry</a></li>
							<li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-19" id="menu-item-19"><a
								href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=bags">Hand Bags</a></li>
							<li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-20" id="menu-item-20"><a
								href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=shoes">Shoes</a></li>
							<li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-21" id="menu-item-21"><a
								href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType&postType=others">Others</a></li>
						</ul></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-22" id="menu-item-22"><a href="<%=RequestUtils.getBaseURI(request)%>/aboutUs.do">About Us</a></li>
					<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-23" id="menu-item-23"><a href="<%=RequestUtils.getBaseURI(request)%>/contactUs.do">Contact</a></li>
				</ul>
			</div>
			<!--//header_menu-->
			
			<div class="footer_copyright">
				&copy; 2014 All Rights Reserved.<br>
				<a href="<%=RequestUtils.getBaseURI(request)%>/homePage.do?method=fetchResultsByPostType">Feminine Beauty World</a>
				<div class="clear"></div>
			</div>
			<!--//footer_copyright-->

			<div class="clear"></div>
			<!-- </div> -->
			<!--//container-->

		</div>
		<!--//header_bottom-->
	</div>
	<!-- //side_header_inside -->
</header>
<!--//header-->
<!--<div class="header_spacing"></div>-->