package kim.xiaom.blog.domain;

import java.io.Serializable;

/**
 * Created by ge on 31/12/2017.
 */
public class Post implements Serializable {
    private String id;
    private String text;
    private String title;
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
