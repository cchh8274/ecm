package cn.kanmars.ecm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kanmars on 2016/12/4.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("redirect:/login/login.dhtml");
        return mv;
    }

    @RequestMapping("/404.html")
    public ModelAndView t404(){
        ModelAndView mv = new ModelAndView("errorpage/404");
        mv.addObject("title","404 Not Found");
        mv.addObject("content","404 Not Found");
        return mv;
    }

    @RequestMapping("/500.html")
    public ModelAndView t500(){
        ModelAndView mv = new ModelAndView("errorpage/500");
        mv.addObject("title","500 Not Found");
        mv.addObject("content","500 Not Found");
        return mv;
    }
}
