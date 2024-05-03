package practicejava;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditedStartingPage extends JFrame {

    public EditedStartingPage() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        JButton jButton5 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue background

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24)); // Updated font style and size
        jLabel1.setText("Welcome to the Hospital Portal");
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Centered text
        jLabel1.setForeground(Color.DARK_GRAY); // Set text color

        // Initialize buttons with specific properties
        initButton(jButton1, "Patient Information");
        initButton(jButton2, "Medical Information");
        initButton(jButton3, "Insurance Information");
        initButton(jButton5, "LOGOUT");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))) // Add button for LOGOUT
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE) // Add button for LOGOUT
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void initButton(JButton button, String text) {
        button.setText(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(204, 229, 255)); // Light blue on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE); // White when not hovered
            }
        });
        button.addActionListener(evt -> buttonActionPerformed(button.getText()));
    }

    private void buttonActionPerformed(String text) {
        System.out.println("Button Pressed: " + text);  // Debug statement
        JFrame obj;
        obj = switch (text) {
            case "Patient Information" -> new EditedPatientInfo();
            case "Medical Information" -> new MedicalInformation_1();
            case "Insurance Information" -> new InsuranceInformation1();
            case "LOGOUT" -> new LoginPage();
            default -> null;
        };
        if (obj != null) {
            obj.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EditedStartingPage().setVisible(true);
        });
    }

    // Variables declaration
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    // End of variables declaration
}