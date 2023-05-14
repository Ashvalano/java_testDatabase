/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testdatabase;

/**
 *
 * @author jc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static login log = new login();

    public static void main(String[] args) {
        controller controller = new controller(log);
        log.setVisible(true);
    }
    
}
