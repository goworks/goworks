package cc.goworks.lifeditor.service;

import cc.goworks.lifeditor.tunnel.model.UserDO;

public interface UserService {
    UserDO getById(String userId);
    UserDO getByUsername(String username);
    void createUser(UserDO UserDO);
    void login(UserDO UserDO);
    UserDO getUserByUsernameAndPassword(String username, String password);
}
