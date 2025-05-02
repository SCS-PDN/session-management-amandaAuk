import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final Map<String, String> USERS = new HashMap<>();
    static {
        USERS.put("student1", "pass123");
        USERS.put("student2", "pass456");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null && password.equals(USERS.get(username))) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("enrolledCourses", new java.util.ArrayList<String>());
            response.sendRedirect("DashboardServlet");
        } else {
            response.sendRedirect("login.html?error=Invalid+Credentials");
        }
    }
}
