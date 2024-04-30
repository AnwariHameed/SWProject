package practicejava;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import practicejava.InsuranceInformation1;

public class MedicalInformation_1 extends JFrame {

    private JTextArea textMedicalCondition, textAllergies, textSurgeries, textCurrentMedication;
    private JLabel labelMedicalCondition, labelAllergies, labelSurgeries, labelCurrentMedication;
    private JScrollPane scrollMedicalCondition, scrollAllergies, scrollSurgeries, scrollCurrentMedication;
    private JButton submitButton;

    public MedicalInformation_1() {
        initComponents();
        setTitle("Medical Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 600)); // Set a minimum size
        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    private void initComponents() {
        // Create a bold font for the labels and text areas
        Font boldFont = new Font("SansSerif", Font.BOLD, 14);

        // Create a border for the text areas
        Border textBorder = BorderFactory.createLineBorder(Color.GRAY, 1);

        labelMedicalCondition = new JLabel("Medical Condition:");
        labelMedicalCondition.setFont(boldFont);
        textMedicalCondition = new JTextArea(5, 20);
        textMedicalCondition.setFont(boldFont);
        textMedicalCondition.setBorder(textBorder);
        scrollMedicalCondition = new JScrollPane(textMedicalCondition);

        labelAllergies = new JLabel("Allergy(ies):");
        labelAllergies.setFont(boldFont);
        textAllergies = new JTextArea(5, 20);
        textAllergies.setFont(boldFont);
        textAllergies.setBorder(textBorder);
        scrollAllergies = new JScrollPane(textAllergies);

        labelSurgeries = new JLabel("Surgeries:");
        labelSurgeries.setFont(boldFont);
        textSurgeries = new JTextArea(5, 20);
        textSurgeries.setFont(boldFont);
        textSurgeries.setBorder(textBorder);
        scrollSurgeries = new JScrollPane(textSurgeries);

        labelCurrentMedication = new JLabel("Current Medication:");
        labelCurrentMedication.setFont(boldFont);
        textCurrentMedication = new JTextArea(5, 20);
        textCurrentMedication.setFont(boldFont);
        textCurrentMedication.setBorder(textBorder);
        scrollCurrentMedication = new JScrollPane(textCurrentMedication);

        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitMedicalInformation();
            }
        });

        // Create a panel with a GridBagLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 20, 10, 20); // Provide some padding

        // Add components to the form panel
        formPanel.add(labelMedicalCondition, gbc);
        formPanel.add(scrollMedicalCondition, gbc);
        formPanel.add(labelAllergies, gbc);
        formPanel.add(scrollAllergies, gbc);
        formPanel.add(labelSurgeries, gbc);
        formPanel.add(scrollSurgeries, gbc);
        formPanel.add(labelCurrentMedication, gbc);
        formPanel.add(scrollCurrentMedication, gbc);
        formPanel.add(submitButton, gbc);

        // Create another panel that will contain the form panel and center everything
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around the form panel

        getContentPane().add(mainPanel); // Add the main panel to the frame
        pack(); // Pack the frame to fit the preferred size of the components
    }

    private void submitMedicalInformation() {
        String medicalCondition = textMedicalCondition.getText();
        String allergies = textAllergies.getText();
        String surgeries = textSurgeries.getText();
        String currentMedication = textCurrentMedication.getText();

        // Basic validation
        if (medicalCondition.isEmpty() || allergies.isEmpty() || surgeries.isEmpty() || currentMedication.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulation of saving to database
        if (saveToDatabase(medicalCondition, allergies, surgeries, currentMedication)) {
            JOptionPane.showMessageDialog(this, "Information Submitted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            // Open the Insurance Information section
            openInsuranceInformation();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit information", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openInsuranceInformation() {
        new InsuranceInformation1().setVisible(true);
        dispose(); // Close the current frame
    }

    private boolean saveToDatabase(String medicalCondition, String allergies, String surgeries, String currentMedication) {
        // Simulate saving to a database (in this case, just print the data)
        System.out.println("Medical Condition: " + medicalCondition);
        System.out.println("Allergy(ies): " + allergies);
        System.out.println("Surgeries: " + surgeries);
        System.out.println("Current Medication: " + currentMedication);

        // Simulate successful saving (return true) or failure (return false)
        return true; // Change this based on your implementation
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MedicalInformation_1());
    }
}
