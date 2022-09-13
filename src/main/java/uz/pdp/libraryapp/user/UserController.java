package uz.pdp.libraryapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @GetMapping()
    public String viewUsers(Model model){

        model.addAttribute("userList",userDao.getAllUsers());

        return "view-users";
    }

    @GetMapping("/add-form")
    public String viewForm(){
        return "user-form";
    }

    @PostMapping()
    public String addUser(User user){

        userDao.addUser(user);

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){

        userDao.deleteUser(id);

        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id,Model model){

        model.addAttribute("id",id);

        return "edit-user";
    }

    @PostMapping("/edit/hhh")
    public String editUser( User user, @RequestParam("id") int id){

        user.setId(id);

        userDao.editUser(user);

        return "redirect:/users";

    }

}
