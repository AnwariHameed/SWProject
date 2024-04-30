package practicejava;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

public class InsuranceInformation1 extends JFrame {

    private JLabel labelInsuranceProvider, labelPolicyNumber, labelGroupNumber;
    private JTextField textInsuranceProvider, textPolicyNumber, textGroupNumber;
    private JButton submitButton;

    public InsuranceInformation1() {
        initComponents();
        setTitle("Insurance Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 600)); // Set a minimum size
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    private void initComponents() {
        Font boldFont = new Font("SansSerif", Font.BOLD, 14);

        // Custom rounded border
        Border roundedBorder = new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int r = 10; // The radius of the rounded edges
                RoundRectangle2D round = new RoundRectangle2D.Float(x, y, width - 1, height - 1, r, r);
                g2d.setColor(Color.GRAY);
                g2d.draw(round);
                g2d.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(4, 8, 4, 8);
            }

            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                insets.left = insets.right = 8;
                insets.top = insets.bottom = 4;
                return insets;
            }
        };

        labelInsuranceProvider = new JLabel("Insurance Provider:");
        labelInsuranceProvider.setFont(boldFont);
        textInsuranceProvider = new JTextField(20);
        textInsuranceProvider.setFont(boldFont);
        textInsuranceProvider.setBorder(roundedBorder);

        labelPolicyNumber = new JLabel("Policy Number:");
        labelPolicyNumber.setFont(boldFont);
        textPolicyNumber = new JTextField(20);
        textPolicyNumber.setFont(boldFont);
        textPolicyNumber.setBorder(roundedBorder);

        labelGroupNumber = new JLabel("Group Number:");
        labelGroupNumber.setFont(boldFont);
        textGroupNumber = new JTextField(20);
        textGroupNumber.setFont(boldFont);
        textGroupNumber.setBorder(roundedBorder);

        submitButton = new JButton("Submit");
        submitButton.setFont(boldFont);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitInsuranceInformation();
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        panel.add(labelInsuranceProvider, gbc);
        panel.add(textInsuranceProvider, gbc);
        panel.add(labelPolicyNumber, gbc);
        panel.add(textPolicyNumber, gbc);
        panel.add(labelGroupNumber, gbc);
        panel.add(textGroupNumber, gbc);
        panel.add(submitButton, gbc);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
    }

    private void submitInsuranceInformation() {
        String insuranceProvider = textInsuranceProvider.getText();
        String policyNumber = textPolicyNumber.getText();
        String groupNumber = textGroupNumber.getText();

        if (insuranceProvider.isEmpty() || policyNumber.isEmpty() || groupNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Display the submitted information
            System.out.println("Insurance Provider: " + insuranceProvider);
            System.out.println("Policy Number: " + policyNumber);
            System.out.println("Group Number: " + groupNumber);
            JOptionPane.showMessageDialog(this, "Information Submitted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Close the Insurance Information section
            dispose();
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InsuranceInformation1().setVisible(true);
        });
    }
}

