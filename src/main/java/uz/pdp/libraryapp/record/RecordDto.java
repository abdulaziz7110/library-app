package uz.pdp.libraryapp.record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.libraryapp.book.Book;
import uz.pdp.libraryapp.book.BookDto2;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class RecordDto {

    private Integer userId;
    private String userFullname;
    private String phoneNumber;
    private String dateTime;
    private Integer recordId;
    private boolean isReturned;
    private List<BookDto2> bookList;

}
