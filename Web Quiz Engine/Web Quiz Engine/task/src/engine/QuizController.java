package engine;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuizController {

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

}