package engine;

public class Response {
    public static final String Ok = "Congratulations, you're right!";
    public static final String Bad ="Wrong answer! Please, try again.";

    private boolean success;
    private String feedback;

    public Response() {
        new Response(true);
    }

    public Response(boolean success) {
        this.success = success;
        if (success) {
            this.feedback = Ok;
        } else {
            this.feedback = Bad;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
