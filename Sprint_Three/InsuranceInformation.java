/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicejava;

import javax.swing.*;

/**
 *
 * @author Sager amena
 */


public class InsuranceInformation extends JFrame {

    public InsuranceInformation() {
        initComponents();
    }

    private void initComponents() {
        // Add your insurance information GUI components here
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsuranceInformation().setVisible(true);
            }
        });
    }
}

