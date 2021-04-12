package com.guiyusong.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type= request.getParameter("text");
        String name=request.getParameter("txt");
        if(name==null)
        {
            response.sendRedirect("index.jsp");
        }else{
            if (name=="baidu")
            {
                response.sendRedirect("https://www.baidu.com/s?sw="+name);
            }else{
                if (name=="bing"){
                    response.sendRedirect("https://www.bing.com/s?sw="+name);
                }else{
                    if (name=="google"){
                        response.sendRedirect("https://www.google.com/s?sw="+name);
                    }
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HTML><TITLE>Usingervlets<TITLE></HEAD>");
        out.println("<BODY BGCOLOR=#123123>");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
