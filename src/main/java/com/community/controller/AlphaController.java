package com.community.controller;

import com.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RestController
public class AlphaController {

    @RequestMapping("/hello")
    public String sayhello() {
        return "hello springboot";
    }

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/lzk")
    public String print() {
        return alphaService.printHello();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());// 获取请求数据
        System.out.println(request.getServletPath());// 获取请求路径
        Enumeration<String> headerNames = request.getHeaderNames();// 获取请求头内容
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            String val = request.getHeader(element);
            System.out.println(element + "->" + val);
        }
        System.out.println(request.getParameter("code"));

        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get获取请求参数
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return " some students";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    // Post请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    public String saveStudent(String name, int age){
        System.out.println(name + "-" + age);
        return "success";
    }

    // 响应html数据 两种方式
    // 方式一
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age",30);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    // 方式二
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","lisi");
        model.addAttribute("age",22);
        return "/demo/view";
    }

    // 响应JSON数据(异步请求)
    // Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",18);
        return map;// @ResponseBody 注解会自动将map转为JSON格式响应给浏览器
    }

    // 返回多个数据
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","张三");
        map1.put("age",18);
        list.add(map1);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","李四");
        map2.put("age",28);
        list.add(map2);
        return list;// @ResponseBody 注解会自动将list转为JSON格式响应给浏览器
    }
}
