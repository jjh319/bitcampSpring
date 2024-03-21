package user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import user.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/user/writeForm")
    public String writeForm() {

        return "/user/writeForm";
    } // writeForm


    @PostMapping(value = "user/checkId")
    @ResponseBody
    public String checkId(@RequestParam String id) {


        return userService.checkId(id);
    } // checkId


} // end class
