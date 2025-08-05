import java.util.ArrayList;
import java.util.Scanner;

/* CRUD Opreations */
public class CRUD {
    static ArrayList<Student> stu = new ArrayList<Student>();

    static Scanner sc = new Scanner(System.in);

    int check(int id){
        int f=0;
        int index=0;
        for(Student s: stu){
            if (s.Id == id) {
                f=1;
                break;
            }
            index++;
        }
        if(f==0){
            return -1;
        }
        else{
            return index;
        }
    }

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
                if(check(k) >0){
                    System.out.println("Id already exists in records present re-enter, you have"+(5-f)+" tries");
                    if (f>=5){break;}
                    continue;
                }
                else{break;}
            }
            if (f>=5) {
                System.out.println("You have tried five times check the records and re-enter");
                break;
            }
            else{
                System.out.print("Name: ");
                String na = sc.next();
                System.out.print("Marks: ");
                int ma = sc.nextInt();
                Student s = new Student(i, na, ma);
                stu.add(s);
            }
        }

        view();

    }

    /* To Display Existing Records */
    void view(){
        System.out.println("Current Student Records");
            System.out.println("ID   |   NAME               | Marks");
            for(Student s: stu){
                System.out.println(s.Id+" |    "+s.Name+"      |            "+s.Marks);
            }
    }

    /* To Update Existing Records */
    void update(){

        System.out.print("Enter the Id of the record you want to change : ");
        int k=sc.nextInt();
        k=check(k);
        if (k > 0) {
            System.out.println("Enter the Changes...");
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String na = sc.next();
            System.out.print("Marks: ");
            int ma = sc.nextInt();
            Student s = new Student(id, na, ma);
            stu.set(k, s);
        } else{
            System.out.println("Id Does not exist in the records");
        }

        
    }

    /* To Delete Records */
    void delete(){
        System.out.println("1. Delete Particular record     2. Delete all Records");
        System.out.print("What is your choice '1' or '2'?..");
        int k = sc.nextInt();
        if (k==1) {
            /* To remove particular record */
            System.out.print("enter the Id of the record you want to delete: ");
            k=sc.nextInt();
            k = check(k);
            if (k>=0) {
                stu.remove(k);
                System.out.println("Record has been successfully deleted");
            } else {
                System.out.println("No, Record has been found");
            }
            
        } else if (k==2) {
            /* To remove all records */
            stu.clear();
            System.out.println("All records have been removed");
        }
        else{
            System.out.println("Wrong Choice Entered");
        }
    }
}
