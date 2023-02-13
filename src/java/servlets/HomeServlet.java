package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();

        if(session.getAttribute("username")==null){
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);      
        }
        else{
            String username=(String)session.getAttribute("username");
        request.setAttribute("username",username);
       getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action!=null&&action.equals("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("us");
            session.removeAttribute("invalid");
            session.removeAttribute("username");
            session.removeAttribute("password");
           // session.invalidate();
            session.setAttribute("invalid", "Logged Out");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}