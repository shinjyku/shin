package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FilterSample implements Filter {

  public void init(FilterConfig fConfig) throws ServletException {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		  throws IOException, ServletException {
	  
	  response.setContentType("text/html; charset=UTF-8");  
      request.setCharacterEncoding("UTF-8");
	  
      System.out.println("Filter IN");
	  
      chain.doFilter(request, response);

    System.out.println("Filter OUT");
	  

  }

  public void destroy() {
  }
}