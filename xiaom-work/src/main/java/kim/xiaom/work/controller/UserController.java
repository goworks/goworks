package kim.xiaom.work.controller;

import kim.xiaom.work.controller.wrapper.StatusVO;
import kim.xiaom.work.converter.UserConverter;
import kim.xiaom.work.entity.dataObjects.UserDO;
import kim.xiaom.work.entity.viewObjects.UserVO;
import kim.xiaom.work.service.UserService;
import kim.xiaom.work.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ge on 12/05/2018.
 */
@CrossOrigin(origins = {"http://localhost:*", "*"})
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public StatusVO login(@RequestBody UserVO userVO) {
        userService.login(userConverter.convert(userVO));
        return ResponseUtils.ok();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public StatusVO register(@RequestBody UserVO userVO) {
        userService.register(userConverter.convert(userVO));
        return ResponseUtils.ok();
    }

    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public UserDO getProfile(Authentication authentication) {
        UserDO principal = (UserDO) authentication.getPrincipal();
        UserDO userDO = userService.getUserByUsername(principal.getUsername());
        userDO.setPassword(null);
        return userDO;
    }
}
