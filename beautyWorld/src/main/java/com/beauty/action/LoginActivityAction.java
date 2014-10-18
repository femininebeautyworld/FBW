/**
 * 
 */
package main.java.com.beauty.action;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.domain.User;
import main.java.com.beauty.form.LoginActivityForm;
import main.java.com.beauty.service.RegisterActivityService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author vinay
 * @param <HttpServletRequest>
 * @param <HttpServletResponse>
 * 
 */
public class LoginActivityAction extends Action {

	private final String SUCCESS = "success";
	private final String FAILURE = "failure";
	private final String SUCCESS_ADMIN = "success_admin";

	private RegisterActivityService registerActivityService;

	public void setRegisterActivityService(
			RegisterActivityService registerActivityService) {
		this.registerActivityService = registerActivityService;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, NoSuchAlgorithmException, InvalidKeySpecException {

		LoginActivityForm loginActivityForm = (LoginActivityForm) form;

		String generatedSecuredPasswordHash = null;
		boolean matched = false;
		User user = new User();
		if (loginActivityForm.getEmailAddress() != null) {
			user = registerActivityService.getUserById(loginActivityForm
					.getEmailAddress().toLowerCase());
		}
		if (user != null) {
			generatedSecuredPasswordHash = user.getPassword();
			matched = validatePassword(loginActivityForm.getPassword(),
					generatedSecuredPasswordHash);
		}
		if (matched) {
			return mapping.findForward(SUCCESS);
		} else {
			return mapping.findForward(FAILURE);
		}
	}

	private static boolean validatePassword(String originalPassword,
			String storedPassword) throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);

		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt,
				iterations, hash.length * 8);
		SecretKeyFactory skf = SecretKeyFactory
				.getInstance("PBKDF2WithHmacSHA1");
		byte[] testHash = skf.generateSecret(spec).getEncoded();

		int diff = hash.length ^ testHash.length;
		for (int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}
		return diff == 0;
	}

	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
					16);
		}
		return bytes;
	}
}
