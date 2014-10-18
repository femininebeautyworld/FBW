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
public class LoginActivityForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6252566485153025216L;

	private String emailAddress;
	private String password;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (this.emailAddress == null || this.emailAddress.length() < 1) {
			errors.add("emailAddress", new ActionMessage(
					"error.emailaddress.required"));
		}
		if (!this.emailAddress.isEmpty()) {
			if (!isValidEmailAddress(this.emailAddress)) {
				errors.add("emailAddress", new ActionMessage(
						"error.valid.email.address"));
			}
		}
		if (this.password == null || this.password.length() < 1) {
			errors.add("password", new ActionMessage(
					"error.password.required"));
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
