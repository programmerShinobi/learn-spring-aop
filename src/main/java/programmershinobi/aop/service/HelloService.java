package programmershinobi.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloService {

    public String hello(String name) {
        log.info("Call HelloService.hello({})", name);
        return "Hello " + name;
    }

    public String hello(String firstName, String lastName) {
        log.info("Call HelloService.hello({}, {})", firstName, lastName);
        return "Hello " + firstName + " " + lastName;
    }

    public String bye(String name) {
        log.info("Call HelloService.bye({})", name);
        return "Bye " + name;
    }

    public void test() {
        log.info("Call HelloService.test()");
    }

}
