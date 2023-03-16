package com.shamengxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    /**
     * 逐个接收请求参数
     * 要求：请求中的参数名和控制器方法的形参名一样。按名称对应接收请求参数
     *
     * 参数接收：
     *  1. 框架使用request对象，接收参数
     *      String name = request.getParameter("name");
     *      String age = request.getParameter("age");
     *  2. 在中央调度器的内部调用doPropertyParam方法时，按名称对象传递参数
     *      doPropertyParam(name,Integer.valueOf(age))
     *          框架可以实现请求参数 String 到 int ,long ,float ,double等类型的转换。
     */
    @RequestMapping(value = "receive-property.do")
    public ModelAndView doPropertyParam(String name,Integer age){
        System.out.println("执行了MyController的doPropertyParam方法name="+name+",age="+age);
        ModelAndView mv = new ModelAndView();

        mv.addObject("myname",name);
        mv.addObject("myage",age);

        mv.setViewName("show");

        //返回结果
        return mv;
    }

}
