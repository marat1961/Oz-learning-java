import java.util.*;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int uc = scanner.nextInt();
        final int lc = scanner.nextInt();
        final int nc = scanner.nextInt();
        final int pl = scanner.nextInt();
        PasswordGenerator gen = new PasswordGenerator(uc, lc, nc, pl);
        String pw = gen.build();
        System.out.println(pw);
    }

}

class PasswordGenerator {
    int uc;
    int lc;
    int nc;
    int pl;
    final Random random = new Random();
    final StringBuilder sb = new StringBuilder();

    public PasswordGenerator(int uc, int lc, int nc, int pl) {
        this.uc = uc;
        this.lc = lc;
        this.nc = nc;
        this.pl = pl;
    }

    public String build() {
        int n = uc + lc + nc;
        if (n < pl) {
            lc = lc + pl - n;
            n = pl;
        }
        while (n-- > 0) {
            if (uc > 0 && uc >= lc) {
                uc--;
                sb.append(getRandomChar('A', 'Z'));
            } else if (lc > 0 && lc >= nc) {
                lc--;
                sb.append(getRandomChar('a', 'z'));
            } else if (nc > 0) {
                nc--;
                sb.append(getRandomChar('0', '9'));
            }
        }
        return sb.toString();
    }

    private char getRandomChar(char lo, char hi) {
        int n = hi - lo;
        int r = 0;
        int i = sb.length() - 1;
        int last = i >= 0 ? sb.charAt(i) : 0;
        do {
            r = lo + random.nextInt(n);
        } while (r == last);
        return (char) r;
    }
}