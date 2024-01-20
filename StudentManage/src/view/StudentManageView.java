package view;

import java.util.Scanner;
import model.Student;
import control.StudentManageController;

public class StudentManageView {
    
    public int Menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose an option: ");
        return sc.nextInt();
    }
    
    
    
}
