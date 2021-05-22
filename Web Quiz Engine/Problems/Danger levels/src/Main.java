enum DangerLevel {
    HIGH,
    MEDIUM,
    LOW;

    int getLevel() {
        return 3 - ordinal();
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        DangerLevel high = DangerLevel.HIGH;
//        DangerLevel medium = DangerLevel.MEDIUM;
//        System.out.println(medium.getLevel());
//        System.out.println(high.getLevel() > medium.getLevel());
//    }
//}

