package com.example.PP_3_1_2_Spring_Boot.controller;

import com.example.PP_3_1_2_Spring_Boot.model.User;
import com.example.PP_3_1_2_Spring_Boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user/home";
    }

    @GetMapping("/profile")
    public String getUser(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/profile";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "user/add";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") User user) {
        userService.updateUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
