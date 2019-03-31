package cc.goworks.lifeditor.service;

import cc.goworks.lifeditor.tunnel.model.StaffDO;

public interface StaffService {
    StaffDO getById(String userId);
    StaffDO getByUsername(String username);
    void createUser(StaffDO StaffDO);
    void login(StaffDO StaffDO);
    StaffDO getUserByUsernameAndPassword(String username, String password);
}
