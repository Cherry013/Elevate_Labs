import java.util.*;

public class Bank {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> list = new ArrayList<User>();

    // Checks duplicate phone number
    public int check_phone(int phone) {
        for (User i : list) {
            if (i.phone == phone) {
                return 1;
            }
        }
        return -1;
    }

    // checks account number exist or not
    public int check_num(int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).account_num == num) {
                return i;
            }
        }
        return -1;
    }

    //Method for new user
    public void new_user() {
        int account_num;
        if (!list.isEmpty()) {
            User lastUser = list.get(list.size() - 1);
            account_num = lastUser.account_num + 1;
        } else {
            account_num = 10000001;
        }
        int count = 5;
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter new password");
        String pass = sc.next();
        while (true) {
            System.out.println("Enter Phone number");
            int phone = sc.nextInt();
            int ph = check_phone(phone);
            if (ph == 1 && count > 1) {
                System.out.println("An account already exists on this number, enter new number");
                System.out.println("You have " + (count - 1) + " tries left");
                count--;
                continue;
            } else if (ph == -1) {
                System.out.println("Account created successfully");
                list.add(new User(account_num, name, 0, pass, phone));
                break;
            }
            break;
        }
    }

    //Method for display users list
   public void view_user() {
    if (list.isEmpty()) {
        System.out.println("No users are available to display.");
    } else {
        System.out.println("------ Users List ------");
        for (User i : list) {
            System.out.println(i);
        }
        System.out.println("------------------------");
    }
}


    //Deposit Method to money deposit
    public void deposit() {
    int count = 5;
    while (true) {
        System.out.print("Enter your account number : ");
        int account_number = sc.nextInt();
        int check = check_num(account_number);
        if (check < 0 && count > 1) {
            System.out.println("Wrong Account number !");
            System.out.println("You have " + (count - 1) + " Tries left");
            count--;
            continue;
        }
        else if (check >= 0) {
            System.out.print("Enter the amount you want to deposit: ");
            int deposit = sc.nextInt();
            list.get(check).account_balance += deposit;
            list.get(check).addTransaction("Deposit", deposit);
            System.out.println("Your " + deposit + " amount deposited successfully.");
            break;
        }
        break;
    }
}

//Withdraw method
public void withdraw() {
    int count = 5, check = -1;
    while (count > 0) {
        count--;
        System.out.print("Account No: ");
        int acc = sc.nextInt();
        System.out.print("Password: ");
        String pass = sc.next();

        check = check_num(acc);
        if (check >= 0) {
            User user = list.get(check);
    if (user != null && user.getPassword().equals(pass)) break;
}


        System.out.println("Invalid account/password! Tries left: " + count);
        if (count == 0) return;
    }

    System.out.print("Enter Withdraw amount: ");
    int amt = sc.nextInt();
    if (amt > list.get(check).account_balance) {
        System.out.println("Insufficient balance!");
    } else {
        list.get(check).account_balance -= amt;
        list.get(check).addTransaction("Withdraw", amt);
        System.out.println("Withdrawn " + amt+ " amount successfully");
    }
}



// View Transactions
public void viewTransactionHistory() {
    System.out.print("Enter your account number to view history : ");
    int account_number = sc.nextInt();
    int check = check_num(account_number);
    if (check >= 0) {
        list.get(check).viewTransactions();
    } else {
        System.out.println("Account not found!");
    }
}
    public static void main(String[] args) {
    Bank obj = new Bank();
    System.out.println("Welcome to my Test Bank app ");
    while (true) {
        System.out.println("1. New User     2. Display users");
        System.out.println("3. Deposit      4. Withdraw");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print(" Please select your option from above : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: 
                    obj.new_user(); 
                    break;
            case 2: 
                    obj.view_user();
                    break;
            case 3: 
                    obj.deposit(); 
                    break;
            case 4: 
                    obj.withdraw(); 
                    break;
            case 5: 
                    obj.viewTransactionHistory();
                    break;
            case 6:
                    System.out.println("Thanks for using my Banking app  ^_^");

                    return;
            default: 
                    System.out.println("Wrong option !"); 
                    break;
        }
    }
}

}