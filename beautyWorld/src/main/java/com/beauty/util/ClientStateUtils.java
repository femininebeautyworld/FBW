/*package main.java.com.beauty.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClientStateUtils {
	private static final Log logger = LogFactory.getLog(ClientStateUtils.class);

	public static String generateEncodedLink(String siteURLPrefix,
			String pagePath, Map clientStateParameterMap, boolean doubleEncode) {
		Map paramMap = null;
		String link = "";

		// Password to be used to serialize parameter via ClientState Utilities
		String clientStatePassword = ClientStatePasswordManager
				.getGlobalPassword();
		// see if the pagePath already contains a clientState
		int index = pagePath.indexOf("clientState");
		int endIndex = pagePath.length();
		if (index > 0) {
			endIndex = pagePath.indexOf("&", index + 12);
			String temp = pagePath.substring(index + 12, endIndex);
			try {
				temp = URLDecoder.decode(temp, "UTF-8");
				paramMap = ClientStateSerializer.deserialize(temp,
						clientStatePassword);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		if (paramMap == null) {
			paramMap = clientStateParameterMap;
		} else {
			// iterate over passed params and add to map (which will overwrite
			// existing parameters by the
			// same name
			for (Iterator iter = clientStateParameterMap.keySet().iterator(); iter
					.hasNext();) {
				String key = (String) iter.next();
				paramMap.put(key, clientStateParameterMap.get(key));
			}
		}
		String clientState = ClientStateSerializer.serialize(paramMap,
				clientStatePassword);

		try {
			clientState = URLEncoder.encode(clientState, "UTF-8");
			if (doubleEncode) {
				clientState = URLEncoder.encode(clientState, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}

		// Check to see if there are already parameters on the pagePath
		char paramOperator = '?';
		if (index > 0) {
			paramOperator = pagePath.charAt(index - 1);
		} else {
			if (pagePath.indexOf("?") > 0) {
				paramOperator = '&';
			}
		}

		if (index > 0) {
			link = siteURLPrefix + pagePath.substring(0, index - 1)
					+ paramOperator + "clientState=" + clientState
					+ pagePath.substring(endIndex);
		} else {
			link = siteURLPrefix + pagePath + paramOperator + "clientState="
					+ clientState + "&cryptoPass=1";
		}
		return link;
	}

	*//**
	 * @param siteURLPrefix
	 *            eg. http://localhost:7001/beacon
	 * @param pagePath
	 *            eg. /claim/viewClaim.do
	 * @param clientStateParameterMap
	 *            map of parameters that will be serialized into clientState
	 * @return encoded String link
	 *//*
	public static String generateEncodedLink(String siteURLPrefix,
			String pagePath, Map clientStateParameterMap) {
		return generateEncodedLink(siteURLPrefix, pagePath,
				clientStateParameterMap, false);
	}

	public static Map getClientStateMap(HttpServletRequest request) {
		Map clientStateMap = new HashMap();
		String cryptoPass = request.getParameter("cryptoPass");
		String clientState = request.getParameter("clientState");
		if (clientState != null) {
			// If cryptoPass = "1", use the password from the crypto classes,
			// otherwise use the password generated on the session.
			String password = ClientStatePasswordManager.getPassword();
			if (cryptoPass != null && cryptoPass.equals("1")) {
				password = ClientStatePasswordManager.getGlobalPassword();
			}
			// Deserialize the client state.
			try {
				clientStateMap = ClientStateSerializer.deserialize(clientState,
						password);
			} catch (InvalidClientStateException e) {
				// log the error and return empty Map
				logger.error(e.getMessage(), e);
			}
		}
		return clientStateMap;
	}

	*//**
	 * @param clientStateParameterMap
	 *            map of parameters that will be serialized into clientState
	 * @return encoded String clientState
	 *//*
	public static String generateEncodedParamMap(Map clientStateParameterMap) {
		Map paramMap = null;

		// Password to be used to serialize parameter via ClientState Utilities
		String clientStatePassword = ClientStatePasswordManager
				.getGlobalPassword();
		// see if the pagePath already contains a clientState

		if (paramMap == null) {
			paramMap = clientStateParameterMap;
		} else {
			// iterate over passed params and add to map (which will overwrite
			// existing parameters by the
			// same name
			for (Iterator iter = clientStateParameterMap.keySet().iterator(); iter
					.hasNext();) {
				String key = (String) iter.next();
				paramMap.put(key, clientStateParameterMap.get(key));
			}
		}
		String clientState = ClientStateSerializer.serialize(paramMap,
				clientStatePassword);

		try {
			clientState = URLEncoder.encode(clientState, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}

		return clientState;
	}

	public static String getParameterValue(HttpServletRequest request,
			Map clientStateMap, String key) {
		String value = request.getParameter(key);
		if (value == null) {
			try {
				value = (String) clientStateMap.get(key);
			} catch (ClassCastException cce) {
				value = ((Long) clientStateMap.get(key)).toString();
			}
		}
		return value;
	}

	public static Object getParameterValueAsObject(HttpServletRequest request,
			Map clientStateMap, String key) {
		Object value = request.getParameter(key);
		if (value == null) {
			value = clientStateMap.get(key);
		}
		return value;
	}
}*/