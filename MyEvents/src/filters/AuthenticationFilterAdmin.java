
package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/admin/*")
public class AuthenticationFilterAdmin implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        boolean loggedIn=false;
        Object usertype=null;
        
        if(session != null){
        	loggedIn = session.getAttribute("username") != null;
        	usertype = session.getAttribute("usertype");
        }
        
        if (loggedIn && usertype=="admin") {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/MyEvents/login.jsp");
        }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		
	}

}

