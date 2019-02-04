package cc.goworks.work.service;

import cc.goworks.work.tunnel.model.StaffDO;

public interface StaffService {
    StaffDO getById(String userId);
    StaffDO getByUsername(String username);
    void createUser(StaffDO StaffDO);
    void login(StaffDO StaffDO);
    StaffDO getUserByUsernameAndPassword(String username, String password);
}
