package com.shamengxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller: 创建控制器（处理器）对象
 *  控制器：叫做后端控制器（back controller),自定义的类处理请求的。
 *  位置：在类的上面，表示创建此类的对象，对象放到springmvc的容器中。
 *
 * @RequestMapping
 *      属性 value ： 表示所有请求地址的公共前缀，相当于是模块名称。
 *      位置 ： 在类的上面
 */
@Controller
@RequestMapping("/student")
public class MyController {

    /**
     * @RequestMaping 请求映射
     *      属性：value 请求中的uri地址，唯一值，以"/"开头
     *      位置：1.在方法的上面（必须的） 2.在类定义的上面（可选）
     *      作用：把指定的请求，交给指定的方法处理，等同于url-pattern
     *
     * 返回值ModeAndView：表示本次请求的处理结果（数据和视图）
     *      Model：表示数据
     *      View：表示视图
     */
    @RequestMapping(value = {"/add.do","/first.do"})
    public ModelAndView dosome(){
        System.out.println("执行了MyController的doSome方法");
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg","处理了some.do请求");
        mv.addObject("fun","执行了doSome方法");

        mv.setViewName("show");

        //返回结果
        return mv;
    }

    @RequestMapping(value = {"/query.do","/second.do"})
    public ModelAndView doOther(){
        System.out.println("执行了MyController的doOther方法");

        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("msg","处理了other.do请求");
        mv.addObject("fun","执行了doOther方法");

        mv.setViewName("other");

        //返回结果
        return mv;
    }
}
