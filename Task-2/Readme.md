 # Task-2

 ## Student Record Management System

### In the 3 Java files [Student.java](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/Student.java) file helps in creating objects, [CRUD.java](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java) file helps in performing operations and we perform the operations from [Main.java](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/Main.java) file

All records are stored in the form of objects in the ArrayList and Those Objects are Student objects which are divided into 3 fields 'Id', 'Name' and 'Marks'

I have created the CLI-based CRUD system for Record Management, I have created 4 methods in the CRUD java file representing the CRUD System those are 
### 1. [add()](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java#L29) to Create records ----> C
--> add() method you can create single or multiple records at same time and you cannot enter the same Id again as we cannot accept the duplicates but 'Name' and 'Marks' can be repeated but not 'Id' as it need to be kept unique.
### 2. [view()](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java#L65) to read records  ----> R
--> view() method you read the records that existing after you have added it does not have any default records.
### 3. [update()](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java#L74) to update records -> U
--> update() method is used to update a particular field in a particular record based on Student 'Id'.
### 4. [delete()](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java#L97) to remove records -> D
--> delete() method is used to delete a particular records or all records.

### [int check(int id)](https://github.com/Cherry013/Elevate_Labs/blob/main/Task-2/CRUD.java#L10)
--> This method is used to check the given 'id' number is in the ArrayList or not. If 'Id' exists then it returns index number else it returns '-1'.
