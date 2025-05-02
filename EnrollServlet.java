import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseId = request.getParameter("courseId");
        if (courseId == null || courseId.trim().isEmpty()) {
            response.sendRedirect("DashboardServlet");
            return;
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            List<String> enrolledCourses = (List<String>) session.getAttribute("enrolledCourses");
            if (enrolledCourses != null && !enrolledCourses.contains(courseId)) {
                enrolledCourses.add(courseId);
            }
        }

        response.sendRedirect("DashboardServlet");
    }
}
