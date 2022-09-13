package uz.pdp.libraryapp.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.libraryapp.author.AuthorDto;
import uz.pdp.libraryapp.category.CategoryDto;
import uz.pdp.libraryapp.language.Language;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {
    private Integer id;
    private String title;
    private String description;
    private Integer isbn;
    private List<AuthorDto> authorDtoList;
    private List<Integer> authorsIds;
    private Integer categoryId;
    private Integer languageId;
}
