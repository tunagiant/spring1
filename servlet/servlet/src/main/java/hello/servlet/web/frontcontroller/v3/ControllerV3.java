package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    //v1, v2와 달리 servlet에 종속적이지않다(request, response객체 없음)
    ModelView process(Map<String, String> paramMap);
}
