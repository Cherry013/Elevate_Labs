import java.util.*;

public class Student_Records{

    static ArrayList<Integer> Id = new ArrayList<Integer>();
    static ArrayList<String> Name = new ArrayList<String>();
    static ArrayList<Integer> Marks = new ArrayList<Integer>();

    static Scanner sc = new Scanner(System.in);

    /* To add new records */
    void add(){
        System.out.print("How many records you want to add?..");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            int f =0;
            while (true) {
                f++;
                System.out.print("Id: ");
                int k = sc.nextInt();
                /* To check the Duplicates */
                if(Id.contains(k)){
                    System.out.println("Id is already present re-enter");
                    if (f>=5){break;}
                    continue;
                }
                else{
                    Id.add(k);
                    break;
                }
            }
            if (f>=5) {
                System.out.println("You have tried five times check the records and re-enter");
                break;
            }
            else{
                System.out.print("Name: ");
                String na = sc.next();
                Name.add(na);
                System.out.print("Marks: ");
                int ma = sc.nextInt();
                Marks.add(ma);
            }
        }

        view();

    }

    /* To Display Existing Records */
    void view(){
        System.out.println("Current Student Records");
            System.out.println("ID      NAME            Marks");
            for(int i=0;i<Id.size();i++){
                System.out.println(Id.get(i)+" |    "+Name.get(i)+"      |            "+Marks.get(i));
            }
    }

    /* To Update Existing Records */
    void update(){

        System.out.print("Enter the Id of the record you want to change : ");
        int k=sc.nextInt();
        if (Id.contains(k)) {
            k = Id.indexOf(k);
            System.out.println("1. Id   2. Name   3. Marks");
            System.out.print("What do you want to update '1' or '2' or '3'?..");
            int u=sc.nextInt();
            switch (u) {
                case 1:System.out.println("Enter the new Id: ");
                    int s = sc.nextInt();
                    if (!Id.contains(s)) {
                        Id.set(k, s);
                    }
                    break;
                case 2:System.out.print("Enter the new Name: ");
                    String na = sc.next();
                    Name.set(k, na);
                    System.out.println("Name updated successfully");
                    break;
                case 3: System.out.print("Enter new Marks: ");
                    int ma=sc.nextInt();
                    Marks.set(k, ma);
                    System.out.println("Marks updated successfully");
                    break;
            
                default: System.out.println("Wrong choice Entered");
                    break;
            }

        }
        else{
            System.out.println("Id Does not exist in the records");
        }

        
    }
    void delete(){
        System.out.println("1. Delete Particular record     2. Delete all Records");
        System.out.print("What is your choice '1' or '2'?..");
        int k = sc.nextInt();
        if (k==1) {
            /* To remove particular record */
            System.out.println("enter the Id of the record you want to delete: ");
            k=sc.nextInt();
            k = Id.indexOf(k);
            Id.remove(k);
            Name.remove(k);
            Marks.remove(k);
            System.out.println("Record has been successfully deleted");
            
        } else if (k==2) {
            /* To remove all records */
            Id.clear();
            Name.clear();
            Marks.clear();
            System.out.println("All records have been removed");
        }
        else{
            System.out.println("Wrong Choice Entered");
        }
        }
    
    public static void main(String[] args) {
        Student_Records SR = new Student_Records();
        
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
                    case 1: SR.add();
                        break;
                    case 2: SR.view();
                        break;
                    case 3: SR.update();
                        break;
                    case 4: SR.delete();
                        break;
                    default:
                        break;
                }

                System.gc();

            } else {
                System.out.println("Thanks for Using the program \n");
                break;
            }
            
        }

    }
}