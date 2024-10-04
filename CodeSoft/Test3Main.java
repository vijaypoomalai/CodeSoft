package CodeSoft;

public class Test3Main {
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(500.00);

        ATM atm = new ATM(userAccount);

        atm.start();
    }
}
