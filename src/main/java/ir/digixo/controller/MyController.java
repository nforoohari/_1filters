package ir.digixo.controller;

import ir.digixo.annotation.TimeTracker;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping(value = "/time",method = RequestMethod.GET)
    @TimeTracker
    String  m()
    {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "home";
    }

    @GetMapping("/m2")
    String m2(){
        return "home";
    }



}
