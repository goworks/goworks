package kim.xiaom.work.service;

import kim.xiaom.work.entity.dataObjects.UserDO;

/**
 * Created by ge on 12/05/2018.
 */
public interface UserService {
    UserDO getUserById(String userId);
    UserDO getUserByUsername(String username);
    void createUser(UserDO userDO);
    void login(UserDO userDO);
    void register(UserDO userDO);
}
