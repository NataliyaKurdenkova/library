package servlets;

import dto.BookDTO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static servlets.HelloServlet.booksService;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {

    private List<Optional<BookDTO>> books;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        books = booksService.getBooks();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1> Книги: </h1>");


        for (Optional<BookDTO> b : books)
            writer.println("<p style='color:Blue'> " + b + "</p>");

        writer.println("</body></html>");
        writer.close();


    }
}
