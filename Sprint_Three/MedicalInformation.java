package patientrecordapp;

import javax.swing.*;

public class MedicalInformation extends JFrame {

    public MedicalInformation() {
        initComponents();
    }

    private void initComponents() {
        // Add your medical information GUI components here
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicalInformation().setVisible(true);
            }
        });
    }
}
