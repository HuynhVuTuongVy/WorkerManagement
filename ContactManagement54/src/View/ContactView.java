/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.ContactModel;
import java.util.List;

/**
 *
 * @author plmin
 */
public class ContactView {

    public void displayMenu() {
        System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
    }

    public void displayAll(List<ContactModel> contacts) {
        System.out.printf("%-5s %-13s %-13s %-13s %-8s %-10s %-15s%n",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (ContactModel contact : contacts) {
            System.out.printf("%-5d %-13s %-13s %-13s %-8s %-10s %-15s%n",
                    contact.getID(), contact.getFullName(), contact.getFirstName(),
                    contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    public void displayMsg(String msg) {
        System.out.println(msg);
    }
}
