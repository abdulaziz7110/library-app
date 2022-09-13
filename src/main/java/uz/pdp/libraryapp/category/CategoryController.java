package uz.pdp.libraryapp.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryDao categoryDao;

    private static int Id;

    @GetMapping
    public String viewCategory(Model m){
        m.addAttribute("categoryList",categoryDao.getAllCategory());
        return "view-category";
    }

    @GetMapping("/get-form")
    public String getForm(){
        return "category-form";
    }

    @PostMapping()
    public String saveCategory(Category category){

        categoryDao.saveCategory(category);

        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id ){

        Id = id;

        return "edit-category";
    }

    @PostMapping("/editCategory")
    public String editLanguage(Category category){

        category.setId(Id);

        categoryDao.editCategory(category);

        return "redirect:/category";
    }



    @GetMapping("/delete/{id}")
    public String deleteLang(@PathVariable int id){

        categoryDao.deleteCategory(id);

        return "redirect:/category";
    }

}
