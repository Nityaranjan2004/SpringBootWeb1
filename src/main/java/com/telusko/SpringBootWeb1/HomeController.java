package com.telusko.SpringBootWeb1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String Home(){
        System.out.println("home method called");
        return "index";
    }


//servelet way


//    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session){
//
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1+num2;
//        System.out.println("in addition is"+result);
//
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }


//Springboot using session
//    @RequestMapping("/add")
//    public String add(int num1,int num2, HttpSession session){
//
//
//        int result = num1+num2;
//        System.out.println("in addition is"+result);
//
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }




//    //Springboot using model object
//    @RequestMapping("/add")
//    public String add(int num1, int num2, Model model){
//
//
//        int result = num1+num2;
//        System.out.println("in addition is"+result);
//        //model
//        model.addAttribute("result",result);
//        //view
//        return "result";
//    }




    //Springboot using model and view object
    @RequestMapping("/add")
    public ModelAndView add(int num1, int num2, ModelAndView mv){


        int result = num1+num2;
        System.out.println("in addition is"+result);
        //model add the data
        mv.addObject("result",result);
        //setting the view name
        mv.setViewName("result");

        return mv;
    }

//need for model attribute
//    @RequestMapping("/addAlian")
//    public ModelAndView addAlian(int aid, String aname, ModelAndView mv){
//        Alian alian = new Alian();
//        mv.addObject("alian",alian);
//        alian.setAid(aid);
//        alian.setAname(aname);
//
//        mv.setViewName("result");
//
//        return mv;
//    }

//using model attribute
    @RequestMapping("/addAlian")
    public String addAlian(@ModelAttribute("alian1") Alian alian){
        return "result";
    }
}
