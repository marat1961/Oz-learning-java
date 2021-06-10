package engine.persistence;

import engine.Answer;
import engine.Quiz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
public class QuizService {

    TreeMap<Long, Quiz> quizzes;

    public QuizService() {
        quizzes = new TreeMap<>();
    }

    public Quiz add(Quiz quiz) {
        Long lastId = quizzes.size() > 0 ? quizzes.lastKey() + 1 : 1;
        quiz.setId(lastId);
        quizzes.put(lastId, quiz);
        return quiz;
    }

    public Quiz getById(Long id) {
        Quiz quiz = quizzes.get(id);
        if (quiz != null) {
            return quiz;
        } else {
            throw new QuizNotFoundException();
        }
    }

    public List<Quiz> getQuizzes() {
        List<Quiz> list = new ArrayList<>();
        list.addAll(quizzes.values());
        return list;
    }

    public boolean solve(Long id, Answer answer) {
        Quiz quiz = getById(id);
        Integer a = answer.getAnswer();
        Integer qa = quiz.getAnswer();
        System.out.println("a=" +a + ", qa=" + qa);
        return a == qa;
    }
}
