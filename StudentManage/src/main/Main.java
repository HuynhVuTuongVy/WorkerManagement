package main;

import control.StudentManageController;
import java.util.Scanner;
import view.StudentManageView;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentManageController control = new StudentManageController();
        StudentManageView view = new StudentManageView();
        Main main = new Main();
        
        int choice;
        
        do{
            choice = view.Menu();
            
            switch (choice) {
                case 1:
                    main.createStudents(control);
                    break;
                case 2:
                    System.out.println("Input ID");
                    int ID = sc.nextInt();
                    control.searchID(ID);
                    break;
                case 3:
                    int d;
                    do{
                        System.out.println("1. update");
                        System.out.println("2. delete");
                        System.out.println("choose your option: ");
                        d = sc.nextInt();
                        switch (d) {
                            case 1:
                                control.updateStudentID();
                                break;
                            case 2:
                                control.deleteStudentbyID();
                                break;
                        }
                    }while(d != 2);
                    break;
                case 4:
                    control.generateReport();
                    break;
                case 5:
                    System.out.println("Bye");
            }
        }while(choice != 5);
    }
    
    
    private void createStudents(StudentManageController control) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Creating students");
            control.addStudent();

            if (control.getStudentList().size() > 10) {
                System.out.print("Do you want to continue creating students? (Y/N): ");
                String continueChoice = sc.next();

                if (!continueChoice.equalsIgnoreCase("Y")) {
                    break;  
                }
            }
        } while (true);
    }
    
}
