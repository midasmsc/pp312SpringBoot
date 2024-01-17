package springbootfirstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springbootfirstapp.model.User;
import springbootfirstapp.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/allUsers"})
    public String displayAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/addUser")
    public String displayNewUserForm(Model model) {
        model.addAttribute("headerMessage", "Add new user");
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/allUsers";
    }

    @GetMapping("/editUser")
    public String displayEditUserForm(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("headerMessage", "Edit user");
        model.addAttribute("user", user);
        return "editUser";
    }


    @PostMapping("/editUser")
    public String saveEditedUser(@ModelAttribute("user") User user) {
        //user.setId(id);
        userService.saveUser(user);
        return "redirect:/allUsers";
    }


    @GetMapping("/deleteUser")
    public String deleteUserById(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }

}