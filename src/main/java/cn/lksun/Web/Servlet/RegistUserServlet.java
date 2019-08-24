package cn.lksun.Web.Servlet;

import cn.lksun.Dao.impl.UserImpl;
import cn.lksun.Domain.ResultInfo;
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
        // 获取json
        String userData = request.getParameter("data");
        // 获取User对象
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userData, User.class);
        // User实例
        UserImpl userImpl = new UserImpl();

        // 获取当前username是否重复
        if (userImpl.count(user.getUsername()) > 0){
            // 用户名重复
            ResultInfo resultInfo = new ResultInfo(false);
            resultInfo.setMsg("【"+user.getUsername()+"】已存在请重试");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(s);
            return;
        }
        if(userImpl.createUser(user) > 0) {
            ResultInfo resultInfo = new ResultInfo(true);
            resultInfo.setMsg("创建成功，请登录。。。");
            ObjectMapper mapper = new ObjectMapper();
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(s);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
