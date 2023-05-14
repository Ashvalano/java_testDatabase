/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jc
 */
public class controller {
    
    login log;
    
    public controller(login log) {
        this.log = log;
   
        log.allListener(new ActionBtn());    
    }
    
    class ActionBtn extends JButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            

        }
    }
}
