/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jc
 */
public class model {
    login log = new login();
    
    controller cc = new controller(log);
    
    static String JDBC_DRIVER;
    static String DB_URL;

    static Connection conn;
    static Statement stmt;
    static PreparedStatement pstm;

    // DataBase Credential
    static String USER;
    static String PASS;
    
    
    public model() {
            JDBC_DRIVER = "com.mysql.jdbc.Driver";
            DB_URL = "jdbc:mysql://localhost:3306/javatestdb?zeroDateTimeBehavior=CONVERT_TO_NULL";

//             DB_URL = "jdbc:mysql://192.168.3.120:3306/java_interns_crud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            // Database Credentials
            USER = "root";
            PASS = "";
            
          
            try {
                    // Registering JDBC Driver
                    //Class.forName(JDBC_DRIVER);x
                    // Opening a Connection
                    System.out.println("Connecting to Database...");
                    conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                    System.out.println("Connected!\n");
            } catch (Exception ex) {
                    ex.printStackTrace();
            }
    }
        // register
        public void register(String username,String password){
        try {
            stmt = conn.createStatement();
            String query = " INSERT INTO table1 (username, password)"+" VALUES (?,?)";
            pstm = conn.prepareStatement(query);
            //DB.pstm = DB.conn.prepareStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registered Successfully");
        }
        catch (Exception e) {
                //System.err.println("Got an exception!");
                //System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e);
        } 
    }
            
        public boolean login(String username, String password) {
            try {
                stmt = conn.createStatement();
                String query = "Select *from table1 WHERE username=? and password=?";
                pstm = conn.prepareStatement(query);
                pstm.setString(1, username);
                pstm.setString(2, password);
                ResultSet rs = pstm.executeQuery();
                
                if(rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    return true;
//                    cam.setVisible(true);
                }
                
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
                }
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
            }
            
            return false;
        }
    
}
