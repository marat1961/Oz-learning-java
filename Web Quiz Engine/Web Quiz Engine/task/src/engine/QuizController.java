package engine;

import engine.persistence.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Answer getLine(@RequestParam("answer") int answer) {
        Answer r;
        if (answer == 2) {
            return new Answer(true, "Congratulations, you're right!");
        } else {
            return new Answer(false, "Wrong answer! Please, try again.");
        }
    }

     @PostMapping(value = "/quizzes", consumes = "application/json")
     public Quiz CreateQuiz(@RequestBody Quiz quiz) {
         return quizService.add(quiz);
     }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuizById(@RequestParam("id") int id) {
        return quizService.getById(id);
    }

}