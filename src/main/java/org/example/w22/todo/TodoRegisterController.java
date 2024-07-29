package org.example.w22.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.example.w22.todo.dao.TodoDAO;

import java.io.IOException;

@WebServlet(value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Todo Register doGet");

        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //step1 - 브라우저에서 전달하는 데이터 수집
        log.info("Todo Register do Post");

        String title = req.getParameter("title");
        String writer = req.getParameter("writer");

        //문제가 있다면? title이나 writer 등이 공백이다.. >> 예외처리


        log.info("title: " + title);
        log.info("writer: " + writer);
        //step2 - 데이터 가공해서 VO, DTO 객체를 생성
        TodoVO vo = TodoVO.builder()
                .title(title)
                .writer(writer)
                .build();

        log.info("TodoVO: " + vo);

        //step3 - Service, DAO에게 처리를 부탁
        try{
            Integer tno = TodoDAO.INSTANCE.insert(vo);
            //step4 - 결과 전송
            resp.sendRedirect("/todo/list?tno=" + tno);
        } catch(Exception e)
        {
            resp.sendRedirect("/todo/register?error=input");
        }




    }
}
