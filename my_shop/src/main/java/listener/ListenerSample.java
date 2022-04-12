package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerSample implements ServletContextListener {

  public void contextInitialized(ServletContextEvent arg0) {
    ServletContext context = arg0.getServletContext();
    Integer count = 0;
    context.setAttribute("count", count);
  }

  public void contextDestroyed(ServletContextEvent arg0) {
  }
}