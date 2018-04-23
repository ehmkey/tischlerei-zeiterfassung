package at.tischlerei.fankhauser.zeiterfassung.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String homeRoot() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/customer")
    public String customer() {
        return "/customer";
    }

    @GetMapping("/employee")
    public String employee() {
        return "/employee";
    }

    @GetMapping("/order")
    public String order() {
        return "/order";
    }

    @GetMapping("/worked")
    public String worked() {
        return "/worked";
    }
}