public class Main {

    public static void main(String[] args) {
        Secret[] secret = Secret.values();
        int n = 0;
        for (Secret s : secret) {
            if (s.toString().startsWith("STAR")) {
                n++;
            }
        }
        System.out.println(n);
    }
}

/* sample enum for inspiration
   enum Secret {
    STAR, CRASH, START, // ...
}
*/