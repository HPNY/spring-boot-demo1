package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//是@ResponseBody和@Controller的组合注解
@RequestMapping("/say")
public class HelloController {

    @Autowired
    private Person person;

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        return "id=" + id;
    }
}
