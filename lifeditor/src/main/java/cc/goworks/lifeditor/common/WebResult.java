package cc.goworks.lifeditor.common;

import java.io.Serializable;

/**
 * Created by ge on 27/01/2018.
 */
public class WebResult<T> implements Serializable {
    private T data;
    private boolean success;
    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static WebResult success() {
        return success(null);
    }

    public static <T> WebResult success(T data) {
        WebResult<T> result = new WebResult<>();
        result.setData(data);
        result.setSuccess(true);
        result.setMessage("ok");
        return result;
    }

    public static <T> WebResult fail(String message) {
        WebResult<T> result = new WebResult<>();
        result.setSuccess(false);
        result.setMessage(message);
        return result;
    }
}
