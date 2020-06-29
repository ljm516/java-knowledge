package top.ljming.springmvc.learn.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.ljming.springmvc.learn.mvc.service.StartService;

@Controller
public class StartController {

    @Autowired
    private StartService startService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("hello world");
        return "index.jsp";
    }

}
