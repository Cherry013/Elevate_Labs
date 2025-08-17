
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Employee {
    static Scanner sc=new Scanner(System.in);
        public static Connection getConnection() throws Exception{
             Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","root"); //Enter your database URL and Mysql user name and password
           
        }

        //View records
        public static void view(){
            try {
                Connection con= getConnection();
                System.out.println("1. Dispaly all Employess    2.Display particular Employee");
                System.out.print("Enter your choice to display : ");
                int choice=sc.nextInt();
                PreparedStatement ps=null;
                if(choice==1){
                    ps=con.prepareStatement("select * from Employee_details ");
                }
                else if(choice==2){
                    System.out.print("Enter Employee Id :");
                    int user_id=sc.nextInt();
                    ps=con.prepareStatement("select * from Employee_details where id=?");
                    ps.setInt(1, user_id);
                }
                else{
                    System.out.println("Invalid Choice");
                    return;
                }
                ResultSet rs = ps.executeQuery();
                 System.out.println("\n==============================================================");
                 System.out.printf("%-5s %-20s %-10s %-15s%n", "ID", "NAME", "SALARY", "CITY");
                 System.out.println("--------------------------------------------------------------");
                 boolean found = false;
                while(rs.next()){
                     found = true;
                    System.out.printf("%-5d %-20s %-10d %-15s%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("salary"),
                    rs.getString("City"));

                }
                if(found==false){
                    System.out.println("No matching records found.");
                }
                System.out.println("==============================================================\n");
                ps.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }


        //Update Records
        public void update(){
            try {
                Connection con = getConnection();
                 System.out.print("Enter Employee Id you want to Update : ");
                 int user_id = sc.nextInt();
                 PreparedStatement checkPs = con.prepareStatement("SELECT * FROM Employee_details WHERE id=?");
                 checkPs.setInt(1, user_id);
                 ResultSet rs = checkPs.executeQuery();

                if (!rs.next()) {
                    System.out.println("No record found with the given ID.");
                    rs.close();
                    checkPs.close();
                    con.close();
                    return; // exit method if no record found
                }
                rs.close();
                checkPs.close();

                PreparedStatement ps=null;
                System.out.println("Enter choice you want to update");
                System.out.println("1. Id  2. Name  3. Salary  4. City 5.Complete record");
                int choice=sc.nextInt();
                switch(choice){
                        case 1:
                            System.out.print("Enter new Id : ");
                            int newId = sc.nextInt();
                            ps = con.prepareStatement("UPDATE Employee_details SET id=? WHERE id=?");
                            ps.setInt(1, newId);
                            ps.setInt(2, user_id);
                            break;
                        case 2:
                            System.out.print("Enter new Name: ");
                            String newName = sc.next();
                            ps = con.prepareStatement("UPDATE Employee_details SET Name=? WHERE id=?");
                            ps.setString(1, newName);
                            ps.setInt(2, user_id);
                            break;
                        case 3:
                            System.out.print("Enter new Salary: ");
                            int newSalary = sc.nextInt();
                            ps = con.prepareStatement("UPDATE Employee_details SET salary=? WHERE id=?");
                            ps.setInt(1, newSalary);
                            ps.setInt(2, user_id);
                            break;
                        case 4:
                            System.out.print("Enter new City: ");
                            String newCity = sc.next();
                            ps = con.prepareStatement("UPDATE Employee_details SET City=? WHERE id=?");
                            ps.setString(1, newCity);
                            ps.setInt(2, user_id);
                            break;
                        case 5:
                            System.out.print("Enter new Id: ");
                            int idAll = sc.nextInt();
                            System.out.print("Enter new Name: ");
                            String nameAll = sc.next();
                            System.out.print("Enter new Salary: ");
                            int salaryAll = sc.nextInt();
                            System.out.print("Enter new City: ");
                            String cityAll = sc.next();

                            ps = con.prepareStatement(
                                "UPDATE Employee_details SET id=?, Name=?, salary=?, City=? WHERE id=?"
                            );
                            ps.setInt(1, idAll);
                            ps.setString(2, nameAll);
                            ps.setInt(3, salaryAll);
                            ps.setString(4, cityAll);
                            ps.setInt(5, user_id);
                            break;

                        default:
                            System.out.println("Wrong Option");
                            return;
                }
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                     System.out.println("Record updated successfully.");
                } else {
                     System.out.println("No record found with the given ID.");
                }
                ps.close();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //insert Records
        public void Add(){
            try {
                 Connection con= getConnection();
                 PreparedStatement ps= con.prepareStatement("INSERT INTO Employee_details values(?,?,?,?)");
                  System.out.print("Enter new Id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Name: ");
                    String name = sc.next();
                    System.out.print("Enter new Salary: ");
                    int salary = sc.nextInt();
                    System.out.print("Enter new City: ");
                    String city = sc.next();
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, salary);
                    ps.setString(4, city);
                    ps.executeUpdate();
                    System.out.println("Record inserted Sucessfully");
                    ps.close();
                    con.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //delete Records
        public void delete(){
            try {
                PreparedStatement ps=null;
                Connection con=getConnection();
                System.out.println("1.Single Recod  2.Complete Records");
                System.out.print("Enter your choice to delete : ");
                int choice=sc.nextInt();
                if(choice==1){
                System.out.println("Enter Employee id to delete record : ");
                int id=sc.nextInt();
                ps=con.prepareStatement("Delete from Employee_details where id=?");
                ps.setInt(1, id);
                }
                else if(choice==2){
                    ps=con.prepareStatement("Delete from Employee_details");
                }
                else{
                    System.out.println("Wrong option Entered");
                return;
                }

                int rows_delete= ps.executeUpdate();
                if(rows_delete>1){
                    System.out.println("All Records Deleted Successfully");
                }
                else if(rows_delete==1){
                    System.out.println("Record Deletd Successfully");
                }
                else{
                    System.out.println("Invalid Record Id");
                }
                ps.close();
                con.close();
            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
}