import java.util.*;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    public void addition(int a,int b){
        System.out.println("Addition a+b= "+(a+b));
    }

    public void subtraction(int a,int b){
        System.out.println("Subtraction a-b="+(a-b));
    }

    public void multiplication(int a,int b){
        System.out.println("Multiplication a*b="+(a*b));
    }

    public void division(int a,int b){
        try {
            System.out.println("Division a/b="+(a/b));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

        Calculator Cal = new Calculator();
        
        System.out.println("Welcome to my Calculator");

        while(true){
            System.out.println("To strat Calculator enter '1' and to Quit enter '2'");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("For calculation choose the options below");
                System.out.println("1. Addtion   2.Subtraction   3.Multiplication   4.Division");
                System.out.print("Choice: ");
                ch = sc.nextInt();
                    System.out.print("Enter the values a: ");
                    int a=sc.nextInt();
                    System.out.print("b: ");
                    int b=sc.nextInt();
    
                    switch (ch) {
                        case 1:Cal.addition(a, b);
                            break;
                        case 2:Cal.subtraction(a, b);
                            break;
                        case 3:Cal.multiplication(a, b);
                            break;
                        case 4:Cal.division(a, b);
                            break;
                        default: System.out.println("Wrong choice entered");
                            break;
                    }
            }
            else{
                System.out.println("Thanks for Using Calculator");
                break;
            }

        }
    }
}
