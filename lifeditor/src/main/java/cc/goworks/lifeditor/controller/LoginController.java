package cc.goworks.lifeditor.controller;

import cc.goworks.lifeditor.common.WebResult;
import cc.goworks.lifeditor.service.UserService;
import cc.goworks.lifeditor.tunnel.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public WebResult getMethodNotSupport() {
        return WebResult.fail("/login get method not support");
    }

    @PostMapping
    public WebResult login(@RequestParam String identifier, @RequestParam String password) {
        UserDO rawUserDO = new UserDO();
        rawUserDO.setUsername(identifier);
        rawUserDO.setPassword(password);
        userService.login(rawUserDO);
        return WebResult.success();
    }
}
