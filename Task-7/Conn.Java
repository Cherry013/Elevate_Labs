
import java.util.Scanner;

public class Conn { 
     public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        Employee obj=new Employee();
        System.out.println("......Welcome to Employee Database App....");
        while(true) { 
            System.out.println(" ");
            System.out.println("1.Display Records    2.Insert Record");
            System.out.println("3.Update Records     4.Delete Records");
            System.out.println("5.Exit");
             System.out.print("Enter Operation you want to perform : ");
             int option=sc.nextInt();
             switch (option) {
                 case 1:
                    obj.view();
                    break;
                 case 2:
                    obj.Add();
                    break;
                 case 3:
                    obj.update();
                    break;
                 case 4:
                    obj.delete();
                    break;
                 case 5:
                    System.out.println("");
                    System.out.println("Thanks for using Employee Database App...!  ^_^");
                    return;
                default:
                    System.out.println("Wrong option Entered");
                    break;


             }

        }
    }
}