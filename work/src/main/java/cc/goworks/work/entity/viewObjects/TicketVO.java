package cc.goworks.work.entity.viewObjects;

/**
 * Created by ge on 12/05/2018.
 */
public class TicketVO {
    private String id;
    private String title;
    private String text;
    private String quizzer;
    private String quizzerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuizzer() {
        return quizzer;
    }

    public void setQuizzer(String quizzer) {
        this.quizzer = quizzer;
    }

    public String getQuizzerName() {
        return quizzerName;
    }

    public void setQuizzerName(String quizzerName) {
        this.quizzerName = quizzerName;
    }
}
