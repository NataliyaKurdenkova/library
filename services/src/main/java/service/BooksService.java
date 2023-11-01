package service;

import dao.BookDao;
import dto.BookDTO;
import entity.Book;
import mappers.BookMapper;
import mappers.impl.BookMapperImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BooksService {
    private final BookDao bookDao = new BookDao();
    private final BookMapper bookMapper = new BookMapperImpl();

    public List<Optional<BookDTO>> getBooks() {

        return bookDao.getBooks().stream()
                .map(l -> (bookMapper.bookToBookDTO(l)))
                .collect(Collectors.toList());

    }

    public Optional<BookDTO> getBookById(long id) {
        return bookMapper.bookToBookDTO(bookDao.findBookById(id));
    }

    public Optional<BookDTO> getBookTitle(String title) {
        return bookMapper.bookToBookDTO(bookDao.findBookByTitle(title));
    }

//    public Optional<BookDTO> getBookByAuthor(String author) {
//
//        Optional<Book> bookByAuthor = bookDao.findBookByAuthor(author);
//        return bookMapper.bookToBookDTO(bookByAuthor);
//    }


    public boolean saveBook(Book book){
        return bookDao.saveBook(book);
    }

    public List<Book> readFromJson(String bookPatch) {
        return bookDao.readFromJson(bookPatch);
    }
}
