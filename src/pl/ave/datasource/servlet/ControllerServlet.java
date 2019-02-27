package pl.ave.datasource.servlet;

import pl.ave.datasource.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String comment = request.getParameter("comment");
        String option = request.getParameter("option");
        String message = null;
        if("add".equals(option)){
            try{
                DbUtil.insert(username,comment);
                message = "Dodano komentarz";
            }catch(SQLException e){
                message = "nie udało się dodać komentarza";
                e.printStackTrace();
            }
        }else if("delete".equals(option)){
            try {
                DbUtil.delete(username);
                message = "Skasowano komentarz";
            }catch(SQLException e){
                e.printStackTrace();
                message = "Nie udało się skasować komentarza";
            }
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
