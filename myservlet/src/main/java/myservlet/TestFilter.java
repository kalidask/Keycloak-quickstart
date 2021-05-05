package myservlet;

import org.keycloak.adapters.servlet.*;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class TestFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {






		HttpServletRequest request = (HttpServletRequest) req;
		RefreshableKeycloakSecurityContext context =  (RefreshableKeycloakSecurityContext)request.getAttribute("org.keycloak.KeycloakSecurityContext");
		//or
		//=  (RefreshableKeycloakSecurityContext)request.getSession().getAttribute("org.keycloak.KeycloakSecurityContext");

		AccessToken token = context.getToken();
		String sub = token.getSubject();//user internal code
		System.out.println(sub);
		String loginName = token.getPreferredUsername();//Login account
		System.out.println(loginName);

		//Realm role list
		Access access = token.getRealmAccess();
		Set<String> roles =  access.getRoles();
		System.out.println(roles);

		//client role list
		//Map<clientId,roleList>
		Map<String, Access>  ma = token.getResourceAccess();
		for (String key : ma.keySet()) {
			System.out.println(key);//clientID
			// The current user has a list of roles in the key client
			System.out.println(ma.get(key).getRoles());

		}
		// Build the business application's own security context request.getSession().setAttribute("loginName", loginName);

		// Request to continue to pass
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}
}