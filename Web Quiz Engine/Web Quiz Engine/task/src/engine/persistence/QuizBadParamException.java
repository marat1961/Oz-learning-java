package engine.persistence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK)
public class QuizBadParamException extends RuntimeException {
    public QuizBadParamException() {
        super("Bad param !");
    }
}
