package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class DoctorController {

    ArrayList<Doctor> doctorList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void loadData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("doctor.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] space = line.split("\\|");
                if (space.length == 5) {
                    doctorList.add(new Doctor(space[0], space[1], space[2], space[3], space[4]));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void display() {
        for (Doctor doctor : doctorList) {
            System.out.println(doctor.toString());
        }
    }

    public void saveDoctor(ArrayList<Doctor> ar) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("doctor.txt"));
            for (Doctor doctor : ar)
                bw.write(doctor.toString() + "\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<Doctor> addDoctor() {
        System.out.println("-------------------------------------");
        System.out.println("Input your ID: ");
        String ID = sc.next();
        System.out.println("Input your first name: ");
        String firstName = sc.next();
        System.out.println("Input your last name: ");
        String lastName = sc.next();
        System.out.println("Input your phone: ");
        String phone = sc.next();
        System.out.println("Input your specialization: ");
        String specialization = sc.next();
        doctorList.add(new Doctor(ID, firstName, lastName, phone, specialization));
        saveDoctor(doctorList);
        return doctorList;
    }

    public ArrayList<Doctor> searchID(String ID) {
        ArrayList<Doctor> rs = new ArrayList<>();
        for (Doctor t : doctorList) {
            if (t.getID().equals(ID)) {
                rs.add(t);
            }
        }
        displaySearchResult(rs);
        return rs;
    }

    public void update() {
        int choice;
        System.out.println("Enter Doctor ID: ");
        String ID = sc.next();
        ArrayList<Doctor> rs = searchID(ID);
        if (rs.isEmpty()) {
            throw new RuntimeException("Doctor code does not exist.");
        } else {
            do {
                System.out.println("1. update first name");
                System.out.println("2. update last name");
                System.out.println("3. update phone");
                System.out.println("4. update specialization");
                System.out.println("5. exit");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter your old first name: ");
                        String oldFName = sc.next();
                        sc.next();
                        System.out.println("Enter your new first name: ");
                        String newFName = sc.nextLine();
                        rs.get(0).updateFirstName(oldFName, newFName);
                        break;
                    case 2:
                        System.out.println("Enter your old last name: ");
                        String oldLName = sc.next();
                        sc.next();
                        System.out.println("Enter your new last name: ");
                        String newLName = sc.nextLine();
                        rs.get(0).updateLastName(oldLName, newLName);
                        break;
                    case 3:
                        System.out.println("Enter your old phone: ");
                        String ophone = sc.next();
                        sc.next();
                        System.out.println("Enter your new phone: ");
                        String newPhone = sc.nextLine();
                        rs.get(0).updatePhone(ophone, newPhone);
                        break;
                    case 4:
                        System.out.println("Enter your old specialization: ");
                        String oSpecialization = sc.next();
                        sc.next();
                        System.out.println("Enter your new specialization: ");
                        String newSpecialization = sc.nextLine();
                        rs.get(0).updateSpecialization(oSpecialization, newSpecialization);
                        break;
                    case 5:
                        System.out.println("Out updating");
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (choice != 5);
        }
    }

    public ArrayList<Doctor> deleteDoctor() {
        ArrayList<Doctor> delete = new ArrayList<>();
        System.out.println("Input ID: ");
        String ID = sc.next();
        for (int i = 0; i < doctorList.size(); i++) {
            Doctor bi = doctorList.get(i);
            if (bi.getID().equals(ID)) {
                doctorList.remove(i);
                i--;
            }
        }
        saveDoctor(doctorList);
        return delete;
    }

    public ArrayList<Doctor> searchFirstName(String FName) {
        ArrayList<Doctor> rs = new ArrayList<>();
        for (Doctor t : doctorList) {
            if (t.getFirstName().equals(FName)) {
                rs.add(t);
            }
        }
        displaySearchResult(rs);
        return rs;
    }

    public ArrayList<Doctor> searchLastName(String LName) {
        ArrayList<Doctor> rs = new ArrayList<>();
        for (Doctor t : doctorList) {
            if (t.getLastName().equals(LName)) {
                rs.add(t);
            }
        }
        displaySearchResult(rs);
        return rs;
    }

    public ArrayList<Doctor> searchPhone(String phone) {
        ArrayList<Doctor> rs = new ArrayList<>();
        for (Doctor t : doctorList) {
            if (t.getPhone().equals(phone)) {
                rs.add(t);
            }
        }
        displaySearchResult(rs);
        return rs;
    }

    public ArrayList<Doctor> searchSpecialization(String specialization) {
        ArrayList<Doctor> rs = new ArrayList<>();
        for (Doctor t : doctorList) {
            if (t.getSpecialization().equals(specialization)) {
                rs.add(t);
            }
        }
        displaySearchResult(rs);
        return rs;
    }

    public void displaySearchResult(ArrayList<Doctor> resultList) {
        if (resultList.isEmpty()) {
            System.out.println("No matching records found.");
        } else {
            System.out.println("Search Results:");
            for (Doctor doctor : resultList) {
                System.out.println(doctor.toString());
            }
        }
    }

    public void displaySearchDoctor() {
        int choice;
        do {
            System.out.println("--------------------------------");
            System.out.println("1. search by first name");
            System.out.println("2. search by last name");
            System.out.println("3. search by phone");
            System.out.println("4. search by ID");
            System.out.println("5. search by specialization");
            System.out.println("6. exit searching");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Input first name");
                    String FName = sc.next();
                    searchFirstName(FName);
                    break;
                case 2:
                    System.out.println("Input last name");
                    String LName = sc.next();
                    searchLastName(LName);
                    break;
                case 3:
                    System.out.println("Input phone");
                    String phone = sc.next();
                    searchPhone(phone);
                    break;
                case 4:
                    System.out.println("Input ID");
                    String ID = sc.next();
                    searchID(ID);
                    break;
                case 5:
                    System.out.println("Input specialization");
                    String specialization = sc.next();
                    searchSpecialization(specialization);
                    break;
                case 6:
                    System.out.println("Out searching");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (choice != 6);
    }
}
