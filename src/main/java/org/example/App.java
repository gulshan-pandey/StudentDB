package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{

    public static void main( String[] args ) throws SQLException {


        System.out.println( "***************************WELCOME TO StudentDB Manager***********************************\n\n" );




        Scanner sc = new Scanner(System.in);
        System.out.println("Which action do you want to perform: \n 1. Fetch Data \n 2. Insert Data \n 3. Batch Execute \n 4. Delete Data  ");

        int choice = 0;

        try {
            choice = sc.nextInt();
        } catch (Exception e) {}


        try(Connection connection = DBOperations.getConnection()){
        Statement statement = connection.createStatement();

        switch(choice){
            case 1:
                ResultSet fetchData = statement.executeQuery("Select * from stu");
                try {
                    CRUDOperations.fetch(fetchData) ;       // calling fetch data function
                } catch (SQLException e) {
                    System.out.println("error occured while fetching the data " + e.getMessage());;
                }
                break;



            case 2:                         // Insert data
               CRUDOperations.Insert(statement, sc);
            break;


              /*  int row = statement.executeUpdate("INSERT INTO stu VALUES(8, 'vipul','vipul@gmail.com','43343582');");       // when update query execute in mysql, the number of rows affected is returned
                if(row>0){
                    System.out.println("data inserted successfully");
                    System.out.println(row);
                }else{
                    System.out.println("sorry data not inserted");
                }
                break;    */





            case 3:                     // batch operation
                ResultSet tempMaxId = statement.executeQuery("SELECT MAX(stu_id) as max_id FROM stu;");
                int tempId=0;
                while(tempMaxId.next()){
                    tempId =tempMaxId.getInt("max_id");
                    tempId++;
                }

                CRUDOperations.Batch(connection,tempId, sc);
                break;




            case 4:
               CRUDOperations.Delete(statement,sc);
                break;



            default:
                System.out.println("please select valid Option!");
        }
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (SQLException e) {
            System.out.println("An error occurred while interacting with the database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        finally {
            sc.close();
        }
    }

}

