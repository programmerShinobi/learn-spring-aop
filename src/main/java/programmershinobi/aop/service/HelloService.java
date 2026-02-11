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

    public String bye(String name) {
        log.info("Call HelloService.bye({})", name);
        return "Bye " + name;
    }

}
