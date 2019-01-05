package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@SpringBootApplication
@RequestMapping("/demo")
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        Myconf myconf = (Myconf) applicationContext.getBean("myconf");
        String configDetails = myconf.showMyconf();
        System.out.print(configDetails);
    }

    @GetMapping("hello")
    public String sayHello() {
        return "hello ,spring-boot";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        User user = new User();
        if (id == 6688) {
            user.setName("bill");
            user.setAge(18);
            user.setSex("man");
            user.setPhoneNumber("18232480449");
            user.setId(id);
        }
        return user;
    }

    @PostMapping("body")
    public String withBody(@RequestBody String body) {
        return "posted request body '" + body + "'";
    }

    @PostMapping("entity")
    public String withEntity(HttpEntity<String> entity) {
        return "posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
    }

    @GetMapping("group")
    public User withGroup(User user) {
        return user;
    }

    @GetMapping("request")
    public String standardRequestArgs(HttpServletRequest request, Locale locale) {
        StringBuilder builder = new StringBuilder();
        builder.append("request=").append(request);
        builder.append(",locale=").append(locale);
        return builder.toString();
    }


}

