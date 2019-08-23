package cn.lksun.Web.Servlet;

import cn.lksun.Dao.UserDao;
import cn.lksun.Dao.impl.UserImpl;
import cn.lksun.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserImpl User = new UserImpl();
        User.getUserByUsername("admin");
    }
}
