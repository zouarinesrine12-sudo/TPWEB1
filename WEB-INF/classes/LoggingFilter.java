
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    private String logPrefix;

    @Override
    public void init(FilterConfig config) throws ServletException {

        logPrefix = config.getInitParameter("logPrefix");

        System.out.println(logPrefix + " LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
                         throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println(logPrefix + " Before servlet: "
                + req.getRequestURL());

        chain.doFilter(request, response);

        System.out.println(logPrefix + " After servlet: "
                + req.getRequestURL());
    }

    @Override
    public void destroy() {
        System.out.println(logPrefix + " LoggingFilter destroyed");
    }
}
