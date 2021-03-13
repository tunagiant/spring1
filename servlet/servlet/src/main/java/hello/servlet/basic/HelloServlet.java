package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// /hello로 접근 시 서블릿이 호출됨
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    //WAS가 request, response객체 만들어서 서블렛에 던져줌
    //서블릿이 호출되면 service메서드가 호출됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username"); //쿼리파라미터받아옴
        System.out.println("username = " + username);

        response.setContentType("text/plain");              //헤더
        response.setCharacterEncoding("utf-8");             //헤더
        response.getWriter().write("hello " + username); //http 바디에 데이터가 들어감
    }
}
