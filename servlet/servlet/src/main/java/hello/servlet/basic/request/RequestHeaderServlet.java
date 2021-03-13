package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//헤더정보 알아보기
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
    }


    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - START ---");
        String method = request.getMethod();
        String protocol = request.getProtocol();
        String scheme = request.getScheme();
        System.out.println("method = " + method);
        System.out.println("protocol = " + protocol);
        System.out.println("scheme = " + scheme);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String queryString = request.getQueryString();  //쿼리스트링(=쿼리파라미터)
        System.out.println("queryString = " + queryString);

        boolean secure = request.isSecure();            //http 's'
        System.out.println("secure = " + secure);

        System.out.println("--- REQUEST-LINE - END ---");
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");


        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));

        String contentType = request.getContentType();
        System.out.println("contentType = " + contentType);

        System.out.println("--- Headers - end ---");
    }
}
