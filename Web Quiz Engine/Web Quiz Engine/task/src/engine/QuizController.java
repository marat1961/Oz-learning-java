package engine;

import engine.persistence.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public Quiz getResponse() {
        String[] options = {"Robot", "Tea leaf", "Cup of coffee", "Bug"};
        Quiz r = new Quiz("The Java Logo",
                "What is depicted on the Java logo?",
                options, 2);
        return r;
    }

    @PostMapping("/quiz")
    public Response getLine(@RequestParam("answer") int answer) {
        Response r;
        if (answer == 2) {
            return new Response(true);
        } else {
            return new Response(false);
        }
    }

    @PostMapping(value = "/quizzes", consumes = "application/json")
    public Quiz CreateQuiz(@RequestBody Quiz quiz) {
        return quizService.add(quiz);
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@RequestParam("id") int id) {
        Quiz quiz = quizService.getById(id);
        return quiz;
    }

    @GetMapping("/quizzes")
    public List<Quiz> getQuizzes() {
        return quizService.getQuizzes();
    }

    @PostMapping(value = "/quizzes/{id}/solve")
    public Response solveQuiz(@PathVariable long id, @RequestBody Answer userAnswer) {
        return quizService.solve(id, userAnswer);
    }

}