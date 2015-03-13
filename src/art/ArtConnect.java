/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package art;

import opinion.*;
import education.*;
import sports.*;
import Storage.*;
import CustomExceptions.TerminateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yousufkhan
 */
public class ArtConnect {
    
    public static Connection CreateConntection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager
                    .getConnection("jdbc:mysql://localhost/thesis",
                            "root", "");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            return c;
            

        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    
    public static Statement CreateStatement(Connection c){

        Statement stmt = null;
        try {
            System.out.println("Create statement successfully");
            return stmt = c.createStatement();
            
        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    public static void insertData(Statement stmt, String link) {
        
        try {
            String sql = "INSERT INTO art (link,status) "
                    + "VALUES ('"+link+"',0);";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                throw new TerminateException();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    
}
