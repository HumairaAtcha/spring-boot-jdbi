package pm.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "spring-boot-jdbi is alive\n";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello!\n";
    }
}
