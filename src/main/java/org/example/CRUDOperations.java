package org.example;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CRUDOperations {

    public static void fetch(Statement statement) throws SQLException {

            //Class.forName("com.mysql.jdbc.Driver");
            ResultSet fetchData = statement.executeQuery("Select * from stu");
            System.out.println("*******************STUDENT DETAILS*****************************************************************");
            while(fetchData.next()){
                System.out.println("Student id: " +  fetchData.getInt("stu_id"));
                System.out.println("Student name: " +  fetchData.getString("name"));
                System.out.println("Student email: " +  fetchData.getString("email"));
                System.out.println("Student phone number: " +  fetchData.getString("phone_no"));
                System.out.println("*************************************************************************************************");
            }
    }




    public static void Delete(Statement statement, Scanner sc) throws SQLException {

        CRUDOperations.fetch(statement);       // calling fetch data function (to show the data before deleting));          // showing all the data before deletion
        System.out.println("\nEnter the id of the record to delete:");
        int deleteId = sc.nextInt();
        int i = statement.executeUpdate("DELETE FROM stu WHERE stu_id = " + deleteId + ";");
        if(i>0){
            System.out.println("data deleted successfully");
        }else{
            System.out.println("data not deleted, Something went wrong... please try again");
        }
    }





    public static void Insert(Statement statement, Scanner sc) throws SQLException {
        ResultSet MaxId = statement.executeQuery("SELECT MAX(stu_id) as max_id FROM stu;");
        int id=0;
        while(MaxId.next()){
            id =MaxId.getInt("max_id");
            id++;
            System.out.println("Student id : " + id);
        }

        System.out.println("Enter the name: ");
//                sc.nextLine();                                  // to clear the buffer
        String name = sc.next();
        System.out.println("Enter the email: ");
        String email = sc.next();
        System.out.println("Enter the Phone Number: ");
        String phone = sc.next();

        int row = statement.executeUpdate("INSERT INTO stu VALUES(" +id+" , '"+name+"', '"+email+"' , '"+phone+"');");                 // when update query execute in mysql, the number of rows affected is returned

        if(row>0){
            System.out.println("data inserted successfully");
        }else{
            System.out.println("something went wrong");
        }

    }





    public static void Batch(Connection connection, int tempId ,Scanner sc) throws SQLException , InputMismatchException {

        System.out.println("Enter the number of rows you want to add :");

        int rows = sc.nextInt();
        String[] bulkQueries =  new String[rows];

        for(int i =0; i<rows;i++){
            System.out.println("Enter the name: ");
            String names = sc.next();
            System.out.println("Enter the email: ");
            String emails = sc.next();
            System.out.println("Enter the Phone Number: ");
            String phones = sc.next();


            bulkQueries[i]="INSERT INTO stu VALUES(" +tempId+" , '"+names+"', '"+emails+"' , '"+phones+"');";
            tempId++;

        }
        Statement batchStatement = connection.createStatement();

        for(String query : bulkQueries){
            batchStatement.addBatch(query);
        }

        int[] ints = batchStatement.executeBatch();// will return int[]

        for(int i =0; i<ints.length; i++){
            if(ints[i]>0) System.out.println("data entered successfully");
            else System.out.println("something went wrong in batch processing");
        }
    }


}
