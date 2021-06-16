import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ex = "[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}";
        boolean ok = s.matches(ex);
        System.out.println(ok);
    }
}