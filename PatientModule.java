/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication;

/**
 *
 * @author amena 
 */
import java.util.Scanner;
public class PatientModule{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        // Dummy patient record
        String patientId = "P001";
        String name = "Amena Bakhtyar";
        int age = 21;
        String email = "bakhtyar.amena21@gmail.com";
        String gender = "Female";
        String maritalStatus = "Single";
        String phoneNumber = "987738792";
        String medicalCondition = "Fever";
        String diagnosis = "Common cold";
        String medications = "Paracetamol";
        String insuranceProvider = "XYZ Insurance";
        String insurancePolicyNumber = "123456789";

        boolean logout = false;

        while (!logout) {
            // Display menu
            System.out.println("Main Menu");
            System.out.println("1. Patient Information");
            System.out.println("2. Medical Information");
            System.out.println("3. Insurance Information");
            System.out.println("4. Back");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            
            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            // Perform action based on user choice
            switch (choice) {
                case 1:
                    displayPatientInfo(patientId, name, age, email, gender, maritalStatus, phoneNumber);
                    break;
                case 2:
                    displayMedicalInfo(medicalCondition, diagnosis, medications);
                    break;
                case 3:
                    displayInsuranceInfo(insuranceProvider, insurancePolicyNumber);
                    break;
                case 4:
                    System.out.println("Going back...");
                    break;
                case 5:
                    System.out.println("Logging out...");
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    // Method to display patient information
    private static void displayPatientInfo(String patientId, String name, int age, String email, String gender, String maritalStatus, String phoneNumber) {
        System.out.println("Patient Information:");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Marital Status: " + maritalStatus);
        System.out.println("Phone Number: " + phoneNumber);
    }

    // Method to display medical information
    private static void displayMedicalInfo(String medicalCondition, String diagnosis, String medications) {
        System.out.println("Medical Information:");
        System.out.println("Medical Condition: " + medicalCondition);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medications: " + medications);
    }

    // Method to display insurance information
    private static void displayInsuranceInfo(String insuranceProvider, String insurancePolicyNumber) {
        System.out.println("Insurance Information:");
        System.out.println("Insurance Provider: " + insuranceProvider);
        System.out.println("Insurance Policy Number: " + insurancePolicyNumber);
    }
}