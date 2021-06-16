package engine;

import engine.persistence.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@Validated
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping(value = "/quizzes", consumes = "application/json")
    public Quiz CreateQuiz(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@PathVariable("id") Long id) {
        Quiz quiz = quizService.getById(id);
        return quiz;
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() {
        return quizService.getQuizzes();
    }

    @PostMapping(value = "/quizzes/{id}/solve")
    public Response solveQuiz(@PathVariable Long id, @RequestBody String s) {
        System.out.println(s);
        String[] a = s.split("=");
        Integer r = a.length > 1 ? Integer.parseInt(a[1]) : -1;
        Answer answer = new Answer(r);
        if (quizService.solve(id, answer)) {
            return new Response(true);
        }
        return new Response(false);
    }

}