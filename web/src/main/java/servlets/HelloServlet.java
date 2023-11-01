package servlets;

import entity.Book;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BooksService;
import service.UsersService;

import java.io.IOException;
import java.util.List;

public class HelloServlet extends HttpServlet {
    public final static UsersService usersService = new UsersService();
    public final static BooksService booksService = new BooksService();

    @Override
    public void init() throws ServletException {

        String userPatch = "C:/users.json";

        List<User> users = usersService.readFromJson(userPatch);

        for(User u:users){
            usersService.saveUser(u);
        }


        String bookPatch = "C:/books1.json";
        List<Book> books = booksService.readFromJson(bookPatch);
        for (Book b : books) {
            booksService.saveBook(b);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = "/index.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
