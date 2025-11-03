package indigodev.com.co.mvcprueba.controllers;

import indigodev.com.co.mvcprueba.models.User;
import indigodev.com.co.mvcprueba.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/app")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("title", "Hello world");
        model.addAttribute("message", "Hello world from userController");
        model.addAttribute("user", new User("Juan", "Martinez"));

        return "view";
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("title", "User List");
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title", "User Form");
        model.addAttribute("user", new User());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("title", "User save");
        User user = userService.findById(id);
        model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String form(User user, Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("title", "User save");
        User userSave = userService.save(user);
        String message = user.getId() == null ? "User has been saved" : "User was updated with id: " + userSave.getId();
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/app/";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        User user = userService.findById(id);
        userService.delete(user);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully");
        return "redirect:/app/";
    }

}
