package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    //ModelAndView : 모델과 뷰 정보를 담고있음
    public ModelAndView process() {
        //논리적 뷰이름
        return new ModelAndView("new-form");
    }
}
