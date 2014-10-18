/**
 * 
 */
package main.java.com.beauty.action;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.domain.User;
import main.java.com.beauty.form.RegisterActivityForm;
import main.java.com.beauty.service.RegisterActivityService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author vinay
 * 
 */
public class RegisterActivityAction extends Action {

	private final String SUCCESS = "success";
	private final String FAILURE = "failure";
	private RegisterActivityService registerActivityService;

	public void setRegisterActivityService(
			RegisterActivityService registerActivityService) {
		this.registerActivityService = registerActivityService;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, NoSuchAlgorithmException, InvalidKeySpecException {

		User user = new User();
		RegisterActivityForm registerActivityForm = (RegisterActivityForm) form;

		int existCount = 0;
		if (registerActivityForm.getEmailAddress() != null) {
			existCount = registerActivityService
					.getUserCountById(registerActivityForm.getEmailAddress()
							.toLowerCase());
		}
		if (existCount > 0) {
			request.setAttribute("alreadyExistingAccountError",
					"You already have an account with us. Please Sign in");
			return mapping.findForward(FAILURE);
		}

		user.setLastName(registerActivityForm.getLastName());
		user.setFirstName(registerActivityForm.getFirstName());
		user.setEmailAddress(registerActivityForm.getEmailAddress()
				.toLowerCase());
		user.setPassword(registerActivityForm.getCurrentPassword());

		String generatedSecuredPasswordHash = generateStrongPasswordHash(user
				.getPassword());

		user.setPassword(generatedSecuredPasswordHash);

		/* save */
		registerActivityService.registerUser(user);
		System.out.println("Object saved successfully.....!!");
		return mapping.findForward(SUCCESS);
	}

	protected static String generateStrongPasswordHash(String password)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		int iterations = 1000;
		char[] chars = password.toCharArray();
		byte[] salt = getSalt().getBytes();

		PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		SecretKeyFactory skf = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return iterations + ":" + toHex(salt) + ":" + toHex(hash);
	}

	protected static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt.toString();
	}

	protected static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

}
