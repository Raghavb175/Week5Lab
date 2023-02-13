package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;


public class LoginServlets extends HttpServlet {
   private AccountService ac = new AccountService();
   
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =request.getSession();
        if(session.getAttribute("username")!=null&&session.getAttribute("password")==null){
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        else{
            String invalid = (String)session.getAttribute("invalid");
        request.setAttribute("username",invalid);
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        request.setAttribute("username",username);
        request.setAttribute("password",password);
         getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(username==null || username.equals("")||password==null||password.equals("")){
            request.setAttribute("invalid", "Invalid Login.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else{
            Object us=ac.login(username,password);
            if(us==null){
                request.setAttribute("invalid", "Invalid Login.");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            else{
              HttpSession session =request.getSession();
              session.setAttribute("username", username);
              session.setAttribute("password", null);
              getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            }
        }
    }
}