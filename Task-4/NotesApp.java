import java.io.*;
import java.util.*;
public class NotesApp {
    static Scanner sc=new Scanner(System.in);

    //Method for adding notes
    public void addnotes(){
        try {
            FileWriter fw=new FileWriter("..\\demo.txt",true); //Provide the new file location
            System.out.println("Enter Notes you want to write :Type 'exit' to finish");
            while(true){
                System.out.print("> ");
                String ab=sc.nextLine();
                if(ab.equalsIgnoreCase("exit")){
                    break;
                }
                fw.write(ab+ "\n");
            }
            fw.close();
            System.out.println("Notes saved successfully.");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method for viewing notes
    public void viewnotes() {
        try {
            FileReader fr = new FileReader("..\\demo.txt"); //Provide the new file location
            BufferedReader br = new BufferedReader(fr);

            String firstLine = br.readLine();

            if (firstLine == null) {
                System.out.println("\nNotes are empty.");
            } else {
                System.out.println("--- Your Notes ---");
                System.out.println(firstLine); // print the first line
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

            System.out.println("\n");

            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException{
        NotesApp obj=new NotesApp();
        try {
            File note=new File("..\\demo.txt");   //Provide the location where the new file should be created
            note.createNewFile();
        } catch (Exception e) {
            System.out.println(e);
        }
        while (true) {
            System.out.println(".....Welcome to Notes App.....");
            System.out.println("Enter the choice you want to perform :");
            System.out.println("1. View notes");
            System.out.println("2. Write notes");
            System.out.println("3. Exit");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    obj.viewnotes();
                    break;
                case 2:
                    obj.addnotes();
                    break;
                case 3:
                    System.out.println("Thanks for using Notes App...!");
                    return;
                default:
                    System.out.println("Entered Wrong Choice");
                    break;

            }
        }
    }
}