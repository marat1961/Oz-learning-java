package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;
import java.util.Set;

public class Quiz {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;
    private String title;
    private String text;
    private String[] options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer answer;

    public Quiz() {
    }

    public Quiz(String title, String text, String[] options, Integer answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @JsonIgnore
    public Integer getAnswer() {
        return answer;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
