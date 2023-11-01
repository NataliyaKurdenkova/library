package servlets;

import dto.UserDTO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static servlets.HelloServlet.usersService;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private List<Optional<UserDTO>> users;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        users = usersService.getUsers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1> Пользователи: </h1>");


        for (Optional<UserDTO> u : users)
            writer.println("<p style='color:Blue'> " + u + "</p>");


        writer.println("</body></html>");
        writer.close();
    }
}
