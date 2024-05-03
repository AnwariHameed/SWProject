package practicejava;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import javax.swing.border.Border;

public class EditedPatientInfo extends JFrame {

    // Form components as class-level variables
    private JTextField patientIdField = new JTextField(20);
    private JTextField nameField = new JTextField(20);
    private JTextField ageField = new JTextField(20);
    private JComboBox<String> maritalStatusComboBox = createMaritalStatusComboBox();
    private JTextField phoneNumberField = new JTextField(20);
    private ButtonGroup genderGroup = new ButtonGroup();

    public EditedPatientInfo() {
        initComponents();
        setTitle("Patient Information Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Apply a consistent font and border to all text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Border roundedBorder = createRoundedBorder();
        Component[] components = {
            patientIdField, nameField, ageField, phoneNumberField, maritalStatusComboBox
        };
        for (Component comp : components) {
            comp.setFont(textFieldFont);
            if (comp instanceof JComponent) {
                ((JComponent) comp).setBorder(roundedBorder);
            }
        }

        // Adding form fields
        addFormField(formPanel, gbc, "Patient ID:", patientIdField);
        addFormField(formPanel, gbc, "Name:", nameField);
        addFormField(formPanel, gbc, "Age:", ageField);
        addFormField(formPanel, gbc, "Marital Status:", maritalStatusComboBox);
        addFormField(formPanel, gbc, "Phone Number:", phoneNumberField);

        // Gender Radio Buttons
        JPanel genderPanel = createGenderPanel();
        addFormField(formPanel, gbc, "Gender:", genderPanel);

        // Submit Button
        JButton submitButton = createSubmitButton();
        gbc.insets = new Insets(20, 10, 10, 10);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        // Add form panel to the frame
        getContentPane().add(formPanel);
        pack();
    }

    private Border createRoundedBorder() {
        return BorderFactory.createLineBorder(Color.BLACK, 1, true);
    }

    private void addFormField(JPanel panel, GridBagConstraints gbc, String labelText, Component field) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(label, gbc);
        panel.add(field, gbc);
    }

    private JPanel createGenderPanel() {
        JPanel genderPanel = new JPanel(new FlowLayout());
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");

        maleButton.setActionCommand("Male");
        femaleButton.setActionCommand("Female");

        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        return genderPanel;
    }

    private JComboBox<String> createMaritalStatusComboBox() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Single");
        comboBox.addItem("Married");
        comboBox.addItem("Divorced");
        comboBox.addItem("Widowed");
        return comboBox;
    }

    private JButton createSubmitButton() {
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.addActionListener(e -> onSubmit());
        return submitButton;
    }

    private void onSubmit() {
        String patientId = patientIdField.getText();
        String name = nameField.getText();
        String age = ageField.getText();
        String maritalStatus = (String) maritalStatusComboBox.getSelectedItem();
        String phoneNumber = phoneNumberField.getText();
        String gender = null;

        // Check if any gender radio button is selected
        Enumeration<AbstractButton> buttons = genderGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                gender = button.getActionCommand();
                break;
            }
        }

        // Check if any required field is empty
        if (patientId.isEmpty() || name.isEmpty() || age.isEmpty() || phoneNumber.isEmpty() || gender == null) {
            JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Assuming submission is successful
            JOptionPane.showMessageDialog(this, "Patient Information Submitted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            openMedicalInformation(); // Open Medical Information after successful submission
        }
    }

    private void openMedicalInformation() {
        new MedicalInformation_1().setVisible(true);
        dispose(); // Close the current frame
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new EditedPatientInfo().setVisible(true));
    }
}
