package kim.xiaom.work.controller.wrapper;

/**
 * Created by ge on 12/05/2018.
 */
public class StatusVO {
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int code;
}
