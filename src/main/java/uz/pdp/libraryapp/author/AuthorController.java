package uz.pdp.libraryapp.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorDao authorDao;

    private int Id;

    @GetMapping
    public String viewAuthor(Model m){

        m.addAttribute("authorList",authorDao.getAuthorList());

        return "view-author";
    }

    @GetMapping("/get-form")
    public String getForm(){
        return "author-form";
    }

    @PostMapping
    public String saveAuthor(Author author){

        authorDao.saveAuthor(author);

        return "redirect:/author";

    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id ){

        Id = id;

        return "edit-author";
    }

    @PostMapping("/editAuthor")
    public String editAuthor(Author author){

        author.setId(Id);

        authorDao.editAuthor(author);

        return "redirect:/author";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable int id){

        authorDao.deleteAuthor(id);



        return "redirect:/author";
    }
}
