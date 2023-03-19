package com.shamengxin.controller;

import com.shamengxin.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    /**
     * 控制器方法返回String，表示逻辑名称。需要项目中配置视图解析器
     * @param name
     * @param age
     * @return
     */


    /**
     * 控制器方法返回String，表示完整视图路径。项目中不能配置视图解析    @RequestMapping(value = "return-string-view1.do")
     *     public String doReturnStringView1(HttpServletRequest request, String name, Integer age){
     *         System.out.println("执行了MyController的doReturnStringView1方法name="+name+",age="+age);
     *
     *         //处理数据
     *         request.setAttribute("myname",name);
     *         request.setAttribute("myage",age);
     *
     *         //返回结果,forward,转发到show.jsp
     *         return "show";
     *     }器
     * @param request
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "return-string-view2.do")
    public String doReturnStringView2(HttpServletRequest request, String name, Integer age){
        System.out.println("执行了MyController的doReturnStringView2方法name="+name+",age="+age);

        //处理数据
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);

        //返回结果,forward,转发到show.jsp
        //使用视图解析器  /WEB-INF/view/ /WEB-INF/view/show.jsp .jsp
        return "/WEB-INF/view/show.jsp";
    }

    /**
     * 控制器方法返回的是void，响应ajax请求。使用HttpServletRespon
     */

}
