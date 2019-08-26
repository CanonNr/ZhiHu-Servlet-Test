package cn.lksun.Web.Servlet;

import cn.lksun.Domain.ResultInfo;
import cn.lksun.Domain.User;
import cn.lksun.Service.UserService;
import cn.lksun.Service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/api/loginUserServlet")
public class LoginUserServlet extends HttpServlet {
    protected ResultInfo resultInfo = new ResultInfo();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        ObjectMapper mapper = new ObjectMapper();
        //Map map = mapper.readValue(data, Map.class);
        //System.out.println(map.get("username"));
        User user = new User();
        user = mapper.readValue(data, User.class);

        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(user);
        if (login == null){
            resultInfo.setFlag(false);
            resultInfo.setMsg("账号或密码错误");
            String s = mapper.writeValueAsString(resultInfo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(s);
            return;
        }
        // 添加session
        request.getSession().setAttribute("user",login);


        resultInfo.setFlag(true);
        String s = mapper.writeValueAsString(resultInfo);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(s);
        Object user1 = request.getSession().getAttribute("user");
        return;


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
