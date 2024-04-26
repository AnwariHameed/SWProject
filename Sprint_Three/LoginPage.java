/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicejava;


import javax.swing.*;
/**
 *
 * @author amena
 */

public class LoginPage extends JFrame {

    public LoginPage() {
        initComponents();
    }

    private void initComponents() {
        // Add your login page GUI components here
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}

