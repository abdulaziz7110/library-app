package uz.pdp.libraryapp.record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Record {

    private Integer id;
    private boolean isReturned;
    private Timestamp timestamp;
    private Integer userId;
    private Integer bookId;
    private List<Integer> bookIds;

}
