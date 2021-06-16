import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}$";
        String s = scanner.nextLine();
        System.out.println(s.matches(regex) ? "YES" : "NO");

    }
}