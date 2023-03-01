package homework.medicialCenter;

import homework.medicialCenter.model.Doctor;
import homework.medicialCenter.model.Patient;
import homework.medicialCenter.storage.PersonStorage;
import homework.medicialCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static PersonStorage personStorage = new PersonStorage();


    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_DOCTOR:
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION:
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID:
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_DATA_BY_ID:
                    changeDoctorData();
                    break;
                case ADD_PATIENT:
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR:
                    printAllPatientsByDoctor();
                    break;
                case PRINT_TODAYS_PATIENTS:
                    personStorage.printTodayPatients();
                    break;
                default:
                    System.out.println("Wrong command please try again");


            }

        }
    }

    private static void printAllPatientsByDoctor() {
        personStorage.printDoctors();
        System.out.println("Please choose doctor's id");
        String id = scanner.nextLine();
        Doctor doctor = personStorage.getDoctorById(id);
        if (doctor != null) {
            personStorage.searchPatientsByDoctor(doctor);
        } else {
            System.out.println("Doctor with " + id + " does not exists ");
        }
    }

    private static void addPatient() {
        personStorage.printDoctors();
        System.out.println("Please choose doctor's id");
        String id = scanner.nextLine();
        Doctor doctor = personStorage.getDoctorById(id);
        if (doctor != null) {
            try {
                System.out.println("Please input id,name,surname,phone,registerDateTime(dd-MM-yyyy HH:mm)");
                String patientDataStr = scanner.nextLine();
                String[] patientData = patientDataStr.split(",");
                Date registerDateTime = DateUtil.stringToDateTime(patientData[4]);
                if (personStorage.isDoctorAvailable(registerDateTime, doctor)) {
                    Patient patient = new Patient();
                    patient.setId(patientData[0]);
                    patient.setName(patientData[1]);
                    patient.setSurname(patientData[2]);
                    patient.setPhone(patientData[3]);
                    patient.setDoctor(doctor);
                    patient.setRegisterDateTime(registerDateTime);
                    patient.setRegisterDateTime(DateUtil.stringToDateTime(patientData[4]));
                    personStorage.add(patient);
                    System.out.println("Patient registered");
                }else {
                    System.out.println("Doctor is unavailable in that date time, please choose another");
                }
            } catch (ParseException e) {
                System.out.println("Incorrect registerDate Time. please try again");

            }


        }

    }


    private static void changeDoctorData() {
        personStorage.printDoctors();
        System.out.println("Please input Id");
        String id = scanner.nextLine();
        Doctor doctorById = personStorage.getDoctorById(id);
        if (doctorById != null) {
            System.out.println("Please input name,surname,email,phone,profession ");
            String doctorDataStr = scanner.nextLine();
            String[] doctorData = doctorDataStr.split(",");
            doctorById.setName(doctorData[0]);
            doctorById.setSurname(doctorData[1]);
            doctorById.setEmail(doctorData[2]);
            doctorById.setPhone(doctorData[3]);
            doctorById.setProfession(doctorData[4]);
            System.out.println("Doctor was updated");
        } else {
            System.out.println("Doctor with " + id + " does not exists");
        }
    }


    private static void deleteDoctorById() {
        personStorage.printDoctors();
        System.out.println("Please choose id");
        String doctorId = scanner.nextLine();
        Doctor doctor = personStorage.getDoctorById(doctorId);
        if (doctor != null) {
            personStorage.deleteDoctorById(doctorId);
        } else {
            System.out.println("Wrong id.please try again");
        }

    }

    private static void searchDoctorByProfession() {
        System.out.println("Please input profession");
        String profession = scanner.nextLine();
        personStorage.searchDoctorByProfession(profession);
    }

    private static void addDoctor() {
        System.out.println("Please input id,name,surname,email,phone,profession ");
        String doctorDataStr = scanner.nextLine();
        String[] doctorData = doctorDataStr.split(",");
        String doctorId = doctorData[0];
        Doctor doctorById = personStorage.getDoctorById(doctorId);
        if (doctorById == null) {
            Doctor doctor = new Doctor();
            doctor.setId(doctorId);
            doctor.setName(doctorData[1]);
            doctor.setSurname(doctorData[2]);
            doctor.setEmail(doctorData[3]);
            doctor.setPhone(doctorData[4]);
            doctor.setProfession(doctorData[5]);
            personStorage.add(doctor);
            System.out.println("Doctor added");
        } else {
            System.out.println("Doctor with " + doctorId + " already exists");
        }


    }

}
