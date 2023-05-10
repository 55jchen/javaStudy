package com.qjc.maven;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author: qjc
 * @Date: 2023/5/10 15:16
 * @Description: TODO
 **/
public class HelloServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse  response) throws ServletException ,IOException{
        response.getWriter().write("hello maven web");
    }
}
