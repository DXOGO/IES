package com.dxogo.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingGET(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            @RequestParam(name="message", required=false, defaultValue="") String message,
            Model model
    )
    {
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        return "greeting";
    }

    @PostMapping("/greeting")
    @ResponseBody
    public Greeting greetingPOST( @RequestBody Map<String, Object> payload) {
        
        String name = "World";
        String message = "";
        
        if (payload.containsKey("name")) {
            name = (String)payload.get("name");
        }
        
        if (payload.containsKey("message")) {
            message = (String)payload.get("message");
        }
        return new Greeting(String.format("Hello, %s!", name), message);
    }

}
