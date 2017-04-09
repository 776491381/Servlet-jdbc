package cn.fyypumpkin.servlet;

import cn.fyypumpkin.service.MessageService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by fyy on 4/9/17.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //设置编码
        req.setCharacterEncoding("UTF-8");
        //接受页面的参数值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        //向页面传递参数值
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        //查询消息列表并传递给页面
        MessageService messageService = new MessageService();
        req.setAttribute("messageList", messageService.query(command, description));
        //页面跳转
        req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);


    }
}
