package com.week5.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {

        String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("-->"+con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        con=(Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String sql="select id,username,password,email,gender,birthdate from usertable where username="+username+"and password="+password+"";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);

            PrintWriter writer = response.getWriter();
            PreparedStatement ps = con.prepareStatement("Select * from usertable where username=? and password=?");

            ps.setString(1, username);
            ps.setString(2, password);
            //ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getInt("username"));
                request.setAttribute("password",rs.getInt("password"));
                request.setAttribute("email",rs.getInt("email"));
                request.setAttribute("gender",rs.getInt("gender"));
                request.setAttribute("birthdate",rs.getInt("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

                //writer.println("Login Success!!!");
                //writer.println("Welcome"+username);
            }else{
                request.setAttribute("message","User name or Password Error!!!");
                request.getRequestDispatcher("login,jsp").forward(request,response);
                //System.out.print("Username or password Error!!!");
            }
            //writer.println("Username or Password Error!!!");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
