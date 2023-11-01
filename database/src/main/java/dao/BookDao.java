package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class BookDao {

    private final Map<String, Book> bookMap = new HashMap<>();

    public Optional<Book> findBookById(long id) {
        Book book = bookMap.values().stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .get();
        return Optional.of(book);
    }

    public Optional<Book> findBookByTitle(String title) {
        Book book = bookMap.entrySet().stream()
                .filter(b -> title.equals(b.getValue().getTitle()))
                .findFirst()
                .get()
                .getValue();

        return Optional.of(book);
    }

    public Optional<Book> findBookByAuthor(String author) {
        Book book = bookMap.entrySet().stream()
                .filter(b -> author.equals(b.getKey()))
                .findFirst()
                .get()
                .getValue();

        return Optional.of(book);
    }

    public List<Optional<Book>> getBooks() {
        List<Optional<Book>> books = bookMap.values().stream()
                .map(b -> Optional.of(b))
                .collect(Collectors.toList());
        return books;
    }

    public boolean saveBook(Book book){
        if(!book.equals(null)) {
            bookMap.put(book.getAuthor(), book);
            return true;
        }
        return false;
    }

    public List<Book> readFromJson(String path) {
        List<Book> books=new ArrayList<>();
        if (path != null) {
            byte[] jsonData = new byte[0];
            try {
                jsonData = Files.readAllBytes(Paths.get(path));
                ObjectMapper objectMapper = new ObjectMapper();
                Book book = objectMapper.readValue(jsonData, Book.class);
                books.add(book);

            } catch (IOException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return books;

    }

}
