package indigodev.com.co.mvcprueba.controllers;

import indigodev.com.co.mvcprueba.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/app")
public class UserController {

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("title", "Hello world");
        model.addAttribute("message", "Hello world from userController");
        model.addAttribute("user", new User("Juan", "Martinez"));
        return "view";
    }


}
