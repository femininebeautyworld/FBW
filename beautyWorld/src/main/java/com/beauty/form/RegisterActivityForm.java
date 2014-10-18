/**
 * 
 */
package main.java.com.beauty.form;

import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import main.java.com.beauty.servlet.RoseIndiaCaptcha;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 * @author vinay
 * 
 */
public class RegisterActivityForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2748072010007676251L;
	private String password;
	private String lastName;
	private String firstName;
	private Date dob;
	private String emailAddress;
	private String confirmEmailAddress;
	private String currentPassword;
	private String confirmPassword;
	private String address;
	private String city;
	private String state;
	private String country;
	private Long zipcode;
	private String jcaptchaResponse;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getConfirmEmailAddress() {
		return confirmEmailAddress;
	}

	public void setConfirmEmailAddress(String confirmEmailAddress) {
		this.confirmEmailAddress = confirmEmailAddress;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	public String getJcaptchaResponse() {
		return jcaptchaResponse;
	}

	public void setJcaptchaResponse(String jcaptchaResponse) {
		this.jcaptchaResponse = jcaptchaResponse;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (this.firstName == null || this.firstName.length() < 1) {
			errors.add("firstName", new ActionMessage(
					"error.FirstName.required"));
		}
		if (this.lastName == null || this.lastName.length() < 1) {
			errors.add("lastName", new ActionMessage("error.LastName.required"));
		}
		if (this.emailAddress == null || this.emailAddress.length() < 1) {
			errors.add("emailAddress", new ActionMessage(
					"error.emailaddress.required"));
		}
		if (this.confirmEmailAddress == null
				|| this.confirmEmailAddress.length() < 1) {
			errors.add("confirmEmailAddress", new ActionMessage(
					"error.confirmemailaddress.required"));
		}
		if (!this.emailAddress.isEmpty() && !this.confirmEmailAddress.isEmpty()) {
			if (!isValidEmailAddress(this.emailAddress)) {
				errors.add("emailAddress", new ActionMessage(
						"error.valid.email.address"));
			}
			if (!this.emailAddress.equalsIgnoreCase(this.confirmEmailAddress)) {
				errors.add("emailAddress", new ActionMessage(
						"error.email.donotmatch"));
			}
		}
		if (this.currentPassword == null || this.currentPassword.length() < 1) {
			errors.add("currentPassword", new ActionMessage(
					"error.password.required"));
		}
		if (this.confirmPassword == null || this.confirmPassword.length() < 1) {
			errors.add("confirmPassword", new ActionMessage(
					"error.confirmpassword.required"));
		}
		if (!this.currentPassword.isEmpty() && !this.confirmPassword.isEmpty()) {
			if (!this.currentPassword.equals(this.confirmPassword)) {
				errors.add("currentPassword", new ActionMessage(
						"error.passwords.donotmatch"));
			}
		}
		
		String c= (String)request.getSession().getAttribute(RoseIndiaCaptcha.CAPTCHA_KEY) ;
		if(!this.jcaptchaResponse.equals(c)){
			errors.add("jcaptchaResponse", new ActionMessage(
					"error.jcaptchaResponse.donotmatch"));
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.password = null;
	}
}
