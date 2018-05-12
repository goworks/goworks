package kim.xiaom.work.service;

/**
 * Created by ge on 12/05/2018.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
