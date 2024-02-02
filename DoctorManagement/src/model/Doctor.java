package model;

public class Doctor {

    private String ID, firstName, lastName, phone, specialization;

    public Doctor(String ID, String firstName, String lastName, String phone, String specialization) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.specialization = specialization;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return ID + "    |    " + firstName + " " + lastName + "    |    " + phone + "    |    " + specialization;
    }

    public void updateFirstName(String oFName, String newFName) {
        if (firstName.equals(oFName)) {
            firstName = newFName;
        }
    }

    public void updateLastName(String oLName, String newLName) {
        if (lastName.equals(oLName)) {
            lastName = newLName;
        }
    }

    public void updatePhone(String oPhone, String newPhone) {
        if (phone.equals(oPhone)) {
            phone = newPhone;
        }
    }

    public void updateSpecialization(String oSpecialization, String newSpecialization) {
        if (specialization.equals(oSpecialization)) {
            specialization = newSpecialization;
        }
    }

}
