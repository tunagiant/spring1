package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //매핑 : /hello-basic URL을 요청받으면 helloBasic() 메서드가 호출된다
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }


    /**
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping("/mapping-get-v1")
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }


    @RequestMapping(value = "/mapping-get-v2", method = RequestMethod.GET)
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }


    /**
     * PathVariable사용
     * 변수명이 같으면 생략가능
     * 경로의 템플릿({})에 있는 변수(경로변수)를 어노테이션의 파라미터로 받음
     * @PathVariable("userId") String userId -> @PathVariable userId
     * 요청 : /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {}. orderId = {}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug", "data=good"}
     */
    // /mapping-param?mode=debug
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE     //스프링문법
     */
    //헤더타입이 application/json 인 경우에만 호출됨
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
