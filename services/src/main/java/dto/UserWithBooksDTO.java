package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UserWithBooksDTO {
    private String login;
    private List<BookDTO> books;
}
