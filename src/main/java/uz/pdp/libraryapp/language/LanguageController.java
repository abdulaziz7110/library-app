package uz.pdp.libraryapp.language;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageDao languageDao;

    private static int Id;

    @GetMapping
    public String viewLanguage(Model m){
        m.addAttribute("languageList",languageDao.getAllLanguage());
        return "view-language";
    }

    @GetMapping("/get-form")
    public String getForm(){
        return "language-form";
    }

    @PostMapping("/add")
    public String saveLanguage(@RequestParam("language") String lang){

        languageDao.saveLanguage(lang);

        return "redirect:/language";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id ){

        Id = id;

        return "edit-language";
    }

    @PostMapping("/editLanguage")
    public String editLanguage(@RequestParam("language") String lang){

        Language language = new Language(Id,lang);

        languageDao.editLanguage(language);

        return "redirect:/language";
    }



    @GetMapping("/delete/{id}")
    public String deleteLang(@PathVariable int id){

        languageDao.delete(id);

        return "redirect:/language";
    }

}
