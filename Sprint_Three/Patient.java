import java.util.ArrayList;
import java.util.List;

class MedicalRecord {
    private String date;
    private String diagnosis;
    private String medication;
    private String doctor;

    public MedicalRecord(String date, String diagnosis, String medication, String doctor) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.doctor = doctor;
    }

    // Getters and setters
}

class Patient {
    private int id;
    private String name;
    private String dob;
    private String gender;
    private String address;
    private String contact;
    private List<MedicalRecord> medicalRecords;

    public Patient(int id, String name, String dob, String gender, String address, String contact) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.medicalRecords = new ArrayList<>();
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // Getters and setters
}

class HospitalManagementSystem {
    private List<Patient> patients;

    public HospitalManagementSystem() {
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        HospitalManagementSystem hospitalSystem = new HospitalManagementSystem();

        // Adding patients
        Patient patient1 = new Patient(1, "John Doe", "1990-01-01", "Male", "123 Main St", "555-1234");
        Patient patient2 = new Patient(2, "Jane Smith", "1985-05-15", "Female", "456 Elm St", "555-5678");

        hospitalSystem.addPatient(patient1);
        hospitalSystem.addPatient(patient2);

        // Adding medical records
        MedicalRecord medicalRecord1 = new MedicalRecord("2024-04-08", "Flu", "Tamiflu", "Dr. Smith");
        MedicalRecord medicalRecord2 = new MedicalRecord("2024-03-20", "Broken arm", "Painkillers", "Dr. Johnson");

        patient1.addMedicalRecord(medicalRecord1);
        patient2.addMedicalRecord(medicalRecord2);

        // Example: Finding patient by ID
        int patientIdToFind = 1;
        Patient foundPatient = hospitalSystem.findPatientById(patientIdToFind);
        if (foundPatient != null) {
            System.out.println("Patient found: " + foundPatient.getName());
        } else {
            System.out.println("Patient not found.");
        }
    }
}