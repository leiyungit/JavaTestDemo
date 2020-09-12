package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 获取请求头信息, 防盗链
@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String value = request.getHeader("referer");
            System.out.println(value);
            response.setContentType("text/html;charset=utf-8");
            if(value.contains("localhost"))
                response.getWriter().write("域名验证通过");
            else
                response.getWriter().write("域名验证不通过");

    }
}
