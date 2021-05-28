package engine.persistence;

import engine.Quiz;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public QuizService() {
    }

    public Quiz add(Quiz quiz) {
        quiz.setId(1);
        quiz.setAnswer(2);
        return quiz;
    }
}
