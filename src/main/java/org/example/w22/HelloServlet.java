package org.example.w22;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String msg = "Hello Sang gyu";

        request.setAttribute("msg",msg);
        //간단한 메세지만 전달하기
        try {
            request.getRequestDispatcher("/WEB-INF/hello2.jsp").forward(request,response);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void destroy() {
    }
}