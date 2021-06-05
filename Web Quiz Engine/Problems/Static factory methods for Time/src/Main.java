import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    private Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static Time noon() {
        return new Time(12, 0, 0);
    }

    public static Time midnight() {
        return new Time(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        int tmp = (int) (seconds / 3600);
        int h = tmp > 23 ? tmp % 24 : tmp;
        int m = (int) ((seconds % 3600) / 60);
        int s = (int) (seconds % 60);
        return new Time(h, m, s);
    }

    public static Time of(int h, int m, int s) {
        if (between(h, 23) && between(m, 59) && between(s, 59)) {
            return new Time(h, m, s);
        } else {
            return null;
        }
    }

    private static boolean between(int a, int hi) {
        return a >= 0 && a <= hi;
    }

}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}