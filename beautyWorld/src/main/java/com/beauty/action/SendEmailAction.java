/**
 * 
 */
package main.java.com.beauty.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.form.ContactUsForm;
import main.java.com.beauty.service.RegisterActivityService;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author vinay
 * 
 */
public class SendEmailAction extends DispatchAction {

	private final String SUCCESS_DISPLAY = "success_display";
	private final String SUCCESS = "success";
	private final String FAILURE = "failure";

	private RegisterActivityService registerActivityService;

	public void setRegisterActivityService(
			RegisterActivityService registerActivityService) {
		this.registerActivityService = registerActivityService;
	}

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		request.setAttribute("successMessage", request.getSession().getAttribute("successMessage"));
		
		request.getSession().removeAttribute("successMessage");

		return mapping.findForward(SUCCESS_DISPLAY);

	}

	public ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ContactUsForm contactUsForm = (ContactUsForm) form;

		InputStream inStream = new FileInputStream(
				"C:/Users/vinay/git/FeminineBeautyWorldRepository/beautyWorld/src/main/resources/com/beauty/properties/applicationResource.properties");

		// Get system properties
		Properties properties = System.getProperties();
		properties.load(inStream);

		// Recipient's email ID needs to be mentioned.
		String toEmailAddress = properties.getProperty("toEmailAddress");

		// Sender's email ID needs to be mentioned
		final String fromEmailAddress = properties
				.getProperty("fromEmailAddress");
		final String fromPassword = properties
				.getProperty("authentication.password");

		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmailAddress,
								fromPassword);
					}
				});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(fromEmailAddress));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmailAddress));

			// Set Subject: header field
			message.setSubject(contactUsForm.getSubject());

			// Now set the actual message
			message.setText("From: " + contactUsForm.getEmail() + " : "
					+ contactUsForm.getMessage());

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return mapping.findForward(FAILURE);
		}

		request.getSession().setAttribute("successMessage","We received your message. We will contact you as soon as possible. Thank you.");
		return mapping.findForward(SUCCESS);

	}

}
