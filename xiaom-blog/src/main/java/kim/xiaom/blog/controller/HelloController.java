package kim.xiaom.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wnow20 on 23/12/2017.
 */
@RestController
public class HelloController {
    @GetMapping("")
    public String sayHello() {
        return "Hello Blog!";
    }
}
