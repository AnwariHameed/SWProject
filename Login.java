import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        // Create JFrame and set its properties
        setTitle("Hospital Management System Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create a panel to hold all components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Create user label and text field
        JLabel userLabel = new JLabel("Username:");
        userTextField = new JTextField();

        // Create password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        // Create login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Add components to panel
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for alignment
        panel.add(loginButton);

        // Add panel to frame
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        char[] password = passwordField.getPassword();

        // Here, you should have your logic to verify username and password
        // This is just a placeholder for demonstration purposes
        if ("admin".equals(username) && "password".equals(new String(password))) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            // You'd transition to your next screen here.
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the login window
        SwingUtilities.invokeLater(() -> {
            Login loginWindow = new Login();
            loginWindow.setVisible(true);
        });
    }
}