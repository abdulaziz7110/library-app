package uz.pdp.libraryapp.record;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryapp.book.BookDao;
import uz.pdp.libraryapp.book.BookDto;
import uz.pdp.libraryapp.user.UserDao;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/record")
public class RecordController {

    private final BookDao bookDao;
    private final UserDao userDao;

    private final RecordDao recordDao;

    @GetMapping("/get-form")
    public String viewRecordForm(Model m){

        m.addAttribute("bookList",bookDao.getAllBooksFromDb());

        m.addAttribute("userList",userDao.getAllUsers());

        return "record-form";
    }

    @GetMapping
    public String viewRecord(Model m){

        List<RecordDto> recordDtoList = recordDao.getAllRecords();

        m.addAttribute("recordList",recordDao.getAllRecords());

        System.out.println(recordDtoList);
        return "view-record";
    }

    @PostMapping
    public String saveRecord(Record record){

        recordDao.saveRecord(record);

        return "redirect:/record";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable int id){

        recordDao.deleteRecord(id);

        return "redirect:/record";
    }


}
