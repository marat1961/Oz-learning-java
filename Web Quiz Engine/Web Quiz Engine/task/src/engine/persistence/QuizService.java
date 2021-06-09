package engine.persistence;

import engine.Answer;
import engine.Quiz;
import engine.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        quizzes.put(lastId, quiz);
        return quiz;
    }

    public Quiz getById(int id) {
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

    public Response solve(long id, Answer answer) {
        Quiz quiz = quizzes.get(id);
        boolean ok = (quiz != null && quiz.geAnswer() == answer.getAnswer());
        return new Response(ok);
    }
}
