package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    //서블릿과 똑같은 모양으로 만듬  //다른컨트롤러들이 구현함
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
