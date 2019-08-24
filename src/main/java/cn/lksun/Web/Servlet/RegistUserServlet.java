package cn.lksun.Web.Servlet;

import cn.lksun.Dao.impl.UserImpl;
import cn.lksun.Domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userData = request.getParameter("data");
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userData, User.class);
        UserImpl userImpl = new UserImpl();
        userImpl.createUser(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
