package mappers;

import dto.BookDTO;
import entity.Book;

import java.util.Optional;

public interface BookMapper {
    Optional<Book> bookDTOToBook(Optional<BookDTO> bookDTO);

    Optional<BookDTO> bookToBookDTO(Optional<Book> book);
}
