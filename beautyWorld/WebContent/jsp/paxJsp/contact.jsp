<%@ include file="/jsp/taglib.jspf"%>

<div id="content">
	<!-- <div class="container">-->

	<div id="single_cont">

		<div class="single_left">

			<div class="single_inside_content">

				<p>Contact Form</p>
				
				<div><font color="red">${successMessage}</font></div>

				<form id="vscf" class="vscf" enctype="multipart/form-data" action="/beautyWorld/contactUsActivity.do?method=submit" method="post" name="contactUsForm">
					<div>
						<label for="vscf_name">
							Name: <span class="error"><html:errors property="name" /></span>
						</label>
						<input type="text" value="" maxlength="50" class="" id="vscf_name" name="name">
					</div>
					<div>
						<label for="vscf_email">
							Email: <span class="error"><html:errors property="email" /></span>
						</label>
						<input type="text" value="" maxlength="50" class="" id="vscf_email" name="email">
					</div>
					<div>
						<label for="vscf_subject">
							Subject: <span class="error"><html:errors property="subject" /></span>
						</label>
						<input type="text" value="" class="" maxlength="50" id="vscf_subject" name="subject">
					</div>
					<div>
						<label for="vscf_message">
							Message: <span class="error"><html:errors property="message" /></span>
						</label>
						<textarea class="" rows="10" id="vscf_message" name="message"></textarea>

					</div>
					<div>
						<input type="submit" id="vscf_send" name="form_send" value="Submit" >
					</div>
				</form>

			</div>
			<!--//single_inside_content-->

			<br> <br>

		</div>
		<!--//single_left-->


		<div class="clear"></div>

	</div>
	<!--//single_cont-->

	<!-- </div> -->
	<!--//container-->
</div>