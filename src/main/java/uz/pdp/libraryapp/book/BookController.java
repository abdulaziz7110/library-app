package uz.pdp.libraryapp.book;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.libraryapp.author.AuthorDao;
import uz.pdp.libraryapp.category.CategoryDao;
import uz.pdp.libraryapp.language.LanguageDao;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    // FIELD INJECTION
    // SETTER INJECTION
    // CONSTRUCTOR INJECTION


    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final LanguageDao languageDao;


    //    @GetMapping
//    public String getAllBooks(HttpServletRequest request, HttpServletResponse response) {
//        List<BookDto> allBooksFromDb = bookDao.getAllBooksFromDb();
//        request.setAttribute("kitoblar", allBooksFromDb);
//
//        return "view-books";
//    }


    @GetMapping
    public String getAllBooks(Model model) {
        List<BookDto> allBooksFromDb = bookDao.getAllBooksFromDb();
        model.addAttribute("kitoblar", allBooksFromDb);
        return "view-books";
    }

    @GetMapping("/get-form")
    public String getForm(Model model) {
        model.addAttribute("authorList", authorDao.getAllAuthorsForSelect());
        model.addAttribute("categoryList", categoryDao.getAllCategory());
        model.addAttribute("languageList", languageDao.getAllLanguage());
        // TODO: 08/09/22 categoryni ham tepadagi authorList ga o'xshab berib yuboring, iltimos.... 
        return "book-form";
    }
//
//    @PostMapping
//    public String saveBook(HttpServletRequest request, HttpServletResponse response){
//        request.getParameter("title");
//        request.getParameter("description");
//        //...
//        //...
//        //...
//        //...
//
//    }


    @PostMapping
    public String saveBook(BookDto bookDto) {
        System.out.println(bookDto);

        bookDao.addBoook(bookDto);

        int last_id = bookDao.takeId();

        bookDao.addBooksAuthorDB(last_id,bookDto.getAuthorsIds());

        bookDao.addBooksCategories(last_id,bookDto.getCategoryId());

        return "redirect:/books";

    }

    @GetMapping("/delete/{id}")
    public String deleteBooks(@PathVariable int id){

        bookDao.deleteBooksAuthors(id);

        bookDao.deleteBooksCategories(id);

        bookDao.deleteBooks(id);

        return "redirect:/books";
    }


    @GetMapping("/edit/{id}")
    public String edit$form(@PathVariable int id, Model model){

        model.addAttribute("id",id);
        model.addAttribute("authorList", authorDao.getAllAuthorsForSelect());
        model.addAttribute("categoryList", categoryDao.getAllCategory());
        model.addAttribute("languageList", languageDao.getAllLanguage());

        return "edit-book";
    }

    @PostMapping("/edit/hhh")
    public String editBook(BookDto bookDto, @RequestParam("id") int id){

        System.out.println(id);

        bookDto.setId(id);

        bookDao.deleteBooksAuthors(id);
        bookDao.deleteBooksCategories(id);

        System.out.println(bookDto);

        bookDao.editBooks(bookDto);

        List<Integer> authorsIds = bookDto.getAuthorsIds();


        System.out.println("sssgit");
        bookDao.addBooksAuthorDB(bookDto.getId(),authorsIds);
        bookDao.addBooksCategories(bookDto.getId(),bookDto.getCategoryId());

        return "redirect:/books";

    }
}
