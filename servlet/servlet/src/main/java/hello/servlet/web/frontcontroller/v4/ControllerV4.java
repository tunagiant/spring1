package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    /**
     * @param paramMap
     * @param model key:논리뷰이름 Object:멤버or리스트
     * @return viewName
     */

    String process(Map<String, String> paramMap, Map<String, Object> model);
}
