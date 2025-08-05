import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CRUD SR = new CRUD();
        
        while (true) {
            
            System.out.println("\n\n  Do you want to change anything in the records?");
            System.out.println("If Yes enter 'y', for No enter 'n'");
            char ch = sc.next().charAt(0);
            ch = Character.toLowerCase(ch);
            if (ch == 'y') {
                System.out.println("  Choose what you want to change the record....");
                System.out.println("1. Add a new Record     2. Display the Records");
                System.out.println("3. Update the Record     4. Delete the records");
                int sel = sc.nextInt();
                switch (sel) {
                    case 1: SR.add(); /* Creates Records */
                        break;
                    case 2: SR.view(); /* Display all Records */
                        break;
                    case 3: SR.update(); /* Update the Record */
                        break;
                    case 4: SR.delete(); /* To Delete Record or Records */
                        break;
                    default: System.out.println("Wrong choice entered");
                        break;
                }

            } else {
                System.out.println("Thanks for Using the program \n");
                break;
            }
            
        }

    }
}