package mappers.impl;

import dto.BookDTO;
import entity.Book;
import mappers.BookMapper;

import java.util.Optional;

public class BookMapperImpl implements BookMapper {
    private static int coutBook = 0;


    @Override
    public Optional<Book> bookDTOToBook(Optional<BookDTO> bookDTO) {
        Book book = Book.builder()
                .id(coutBook++)
                .author(bookDTO.get().getAuthor())
                .title(bookDTO.get().getTitle())
                .build();
        return Optional.of(book);
    }

    @Override
    public Optional<BookDTO> bookToBookDTO(Optional<Book> book) {
        BookDTO bookDTO = BookDTO.builder()
                .author(book.get().getAuthor())
                .title(book.get().getTitle())
                .build();
        return Optional.of(bookDTO);
    }
}
