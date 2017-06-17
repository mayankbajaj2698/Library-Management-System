/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_management_system;
import admin.newStream;
import admin.newStudent;
import java.sql.*;
import java.util.ArrayList;
import javax.xml.transform.stream.StreamSource;
import student.*;
import librarian.*;
/**
 *
 * @author Mayank Bajaj
 */
public class Library_Management_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select b_code,b_name from streams");
            ArrayList<String> streams = new ArrayList<String>();
            ArrayList<String> codes = new ArrayList<String>();
            while(rs.next()){
               codes.add(rs.getString(1));
               streams.add(rs.getString(2));
            }
            new Login(stmt,codes,streams).setVisible(true);
            //new book(stmt,streams,codes,null,"2K15/SE/038").setVisible(true);
            //new newBook(stmt,streams,codes).setVisible(true);
            //new StudentPage("Mayank Bajaj", "2K15/SE/038", "Software Engineering", "G-20/279 Sec-7 Rohini",9716523488L, "mayankbajaj2698@gmail.com", stmt).setVisible(true);
            //new newStudent(stmt,codes,streams).setVisible(true);
            //new newStream(stmt).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
