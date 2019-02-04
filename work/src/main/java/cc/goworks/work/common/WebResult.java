package cc.goworks.work.common;

import java.io.Serializable;

/**
 * Created by ge on 27/01/2018.
 */
public class WebResult<T> implements Serializable {
    private T data;
    private boolean success;
    private String message;

}
