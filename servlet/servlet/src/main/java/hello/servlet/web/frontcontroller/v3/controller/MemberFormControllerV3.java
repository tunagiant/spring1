package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        //논리적인이름(URI부분에서 특정될 수 있는부분:맵의 키로 설정해놓았기때문)
        return new ModelView("new-form");
    }
}
