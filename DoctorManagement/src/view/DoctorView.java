package view;

import java.util.Scanner;
import control.DoctorController;

public class DoctorView {
    Scanner sc = new Scanner(System.in);
    DoctorController control = new DoctorController();

    public void displayMenu() {
        int choice;
        do {
            System.out.println("--------------DOCTOR MANAGEMENT--------------");
            System.out.println("1. Add doctor");
            System.out.println("2. Update doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");
            System.out.println("5. Display doctor");
            System.out.println("6. Exit");
            System.out.print("Input your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    control.addDoctor();
                    break;
                case 2:
                    control.update();
                    break;
                case 3:
                    control.deleteDoctor();
                    break;
                case 4:
                    control.displaySearchDoctor();
                    break;
                case 5:
                    control.display();
                    break;
                case 6:
                    System.out.println("Byeeee");
                    break;
                default:
                    throw new AssertionError();
            }

        } while (choice != 6);
    }
}
