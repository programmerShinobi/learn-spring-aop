package programmershinobi.aop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    void helloService() {
        Assertions.assertEquals("Hello Faqih", helloService.hello("Faqih"));
        Assertions.assertEquals("Hello Faqih Pratama Muhti", helloService.hello("Faqih", "Pratama Muhti"));
        Assertions.assertEquals("Bye Asri", helloService.bye("Asri"));

        helloService.test();
    }

}
