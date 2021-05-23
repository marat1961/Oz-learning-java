import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() { }

    public static void increaseBalance(Account account, long amount) {
        Field field = null;
        try {
            field = account.getClass().getDeclaredField("balance");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        long balance = 0;
        try {
            balance = (long) field.get(account) + amount;
            field.set(account, balance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws Exception {
//        AccountUtils utils = new AccountUtils();
//        Account account = new Account(1000);
//        utils.increaseBalance(account, 500);
//        account.print();
//    }
}

//class Account {
//    private long balance;
//
//    public Account(long balance) {
//        this.balance = balance;
//    }
//
//    public void print() {
//        System.out.println(balance);
//    }
//}
