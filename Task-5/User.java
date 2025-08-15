import java.util.ArrayList;

public class User {
    int account_num;
    String name;
    int account_balance;
    String password;
    int phone;
    ArrayList<String> transactions = new ArrayList<>();

    public User(int account_num, String name, int account_balance, String password, int phone) {
        this.account_num = account_num;
        this.name = name;
        this.account_balance = account_balance;
        this.password = password;
        this.phone = phone;
    }
    
    public String getPassword() {
    return password;
    }


    // Method to add transaction record
    public void addTransaction(String type, int amount) {
        String record = String.format("%-12s | %-8d | %-10d", type, amount, account_balance);
        transactions.add(record);
    }

    // Method to view transaction history
    public void viewTransactions() {
        System.out.println("\n----------------------------------------");
        System.out.println("      TRANSACTION HISTORY for " + name);
        System.out.println("----------------------------------------");
        System.out.printf("%-12s | %-8s | %-10s\n", "Type", "Amount", "Balance");
        System.out.println("----------------------------------------");
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("----------------------------------------\n");
    }

    
    public String toString() {
        return "Account No: " + account_num + ", Name: " + name +
                ", Balance: " + account_balance;
    }
}