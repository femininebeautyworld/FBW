/**
 * 
 */
package main.java.com.beauty.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.beauty.domain.User;

/**
 * @author vinay
 * 
 */
public class AuthenticationFilter implements Filter {

	private String[] roleNames;
	private String onErrorUrl;

	public void init(FilterConfig arg0) throws ServletException {
		String roles = arg0.getInitParameter("roles");
		if (roles == null || "".equals(roles))
			roleNames = new String[0];
		else {
			roles.trim();
			roleNames = roles.split(" ");
		}

		onErrorUrl = arg0.getInitParameter("onError");
		if (onErrorUrl == null || "".equals(onErrorUrl))
			onErrorUrl = "login.do";
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		request.getServletContext().log("Requested Resource::" + uri);

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			request.getServletContext().log("Unauthorized access request");
			res.sendRedirect("login.do");
		} else {
			boolean hasRole = false;
			for (int i = 0; i < roleNames.length; i++) {
				if (user.getRole().equals(roleNames[i])) {
					hasRole = true;
					break;
				}
			}
			// pass the request along the filter chain
			if (hasRole) {
				chain.doFilter(request, response);
			} else {
				request.getServletContext().log("Unauthorized access request");
				res.sendRedirect("login.do");
			}
		}

	}

	public void destroy() {
		// close any resources here
	}

}
