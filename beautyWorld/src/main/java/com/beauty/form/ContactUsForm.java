/**
 * 
 */
package main.java.com.beauty.form;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * @author vinay
 * 
 */
public class ContactUsForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6011368408003463555L;

	private String name;

	private String email;

	private String subject;

	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (this.name == null || this.name.length() < 1) {
			errors.add("name", new ActionMessage(
					"error.contactname.required"));
		}
		
		if (this.email == null || this.email.length() < 1) {
			errors.add("email", new ActionMessage(
					"error.emailaddress.required"));
		}
		
		if (!this.email.isEmpty()) {
			if (!isValidEmailAddress(this.email)) {
				errors.add("email", new ActionMessage(
						"error.valid.email.address"));
			}
		}
		if (this.subject == null || this.subject.length() < 1) {
			errors.add("subject", new ActionMessage(
					"error.subject.required"));
		}
		if (this.message == null || this.message.length() < 1) {
			errors.add("message", new ActionMessage(
					"error.message.required"));
		}

		return errors;
	}
	
	public static boolean isValidEmailAddress(String emailAddress) {

		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(emailAddress);
			emailAddr.validate();
		} catch (AddressException e) {
			result = false;
		}
		return result;
	}

}
