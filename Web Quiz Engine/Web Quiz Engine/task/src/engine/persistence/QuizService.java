package engine.persistence;

import engine.Quiz;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class QuizService {

    TreeMap<Integer, Quiz> quizzes;

    public QuizService() {
        quizzes = new TreeMap<>();
    }

    public Quiz add(Quiz quiz) {
        Integer lastId = quizzes.size() > 0 ? quizzes.lastKey() : 1;
        quiz.setId(lastId);
        return quiz;
    }

    public Quiz getById(int id) {
        return quizzes.get(id);
    }
}
