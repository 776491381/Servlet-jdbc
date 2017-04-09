package cn.fyypumpkin.servlet;

import cn.fyypumpkin.service.MaintianService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fyy on 4/9/17.
 */
public class deleteBatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] ids = req.getParameterValues("id");
        MaintianService maintianService = new MaintianService();
        maintianService.deleteBatch(ids);


        req.getRequestDispatcher("/ListServlet").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}
