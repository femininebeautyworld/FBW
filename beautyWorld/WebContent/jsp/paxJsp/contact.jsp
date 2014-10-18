<p>
	<span style="color: #555555;">Use Free Plugin “</span><a target="_blank" href="https://wordpress.org/plugins/very-simple-contact-form/">Very Simple Contact Form</a><span style="color: #555555;">”</span>
</p>

<form action="" method="post" id="vscf" class="vscf">
	<div>
		<label for="vscf_name">
			Name: <span class="error  hide">Please enter at least 3 characters</span>
		</label>
		<input type="text" value="" maxlength="50" class="" id="vscf_name" name="form_name">
	</div>
	<div>
		<label for="vscf_email">
			Email: <span class="error  hide">Please enter a valid email</span>
		</label>
		<input type="text" value="" maxlength="50" class="" id="vscf_email" name="email">
	</div>
	<div>
		<label for="vscf_subject">
			Subject: <span class="error  hide">Please enter at least 3 characters</span>
		</label>
		<input type="text" value="" class="" maxlength="50" id="vscf_subject" name="form_subject">
	</div>
	<div>
		<label for="vscf_message">
			Message: <span class="error  hide">Please enter at least 10 characters</span>
		</label>
		<textarea class="" rows="10" id="vscf_message" name="form_message"></textarea>

	</div>
	<div>
		<input type="submit" id="vscf_send" name="form_send" value="Submit">
	</div>
</form>