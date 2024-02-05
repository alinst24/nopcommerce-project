package ObjectData;

import java.util.HashMap;

public class RegisterPageObject {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String noAddressMesage;
    private String newFirstName;
    private String newLastName;
    private String newEmail;
    private String newCity;
    private String newAddress1;
    private String newZip;
    private String newPhoneNumber;
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewCity() {
        return newCity;
    }

    public void setNewCity(String newCity) {
        this.newCity = newCity;
    }

    public String getNewAddress1() {
        return newAddress1;
    }

    public void setNewAddress1(String newAddress1) {
        this.newAddress1 = newAddress1;
    }

    public String getNewZip() {
        return newZip;
    }

    public void setNewZip(String newZip) {
        this.newZip = newZip;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getNoAddressMesage() {
        return noAddressMesage;
    }

    public void setNoAddressMesage(String noAddressMesage) {
        this.noAddressMesage = noAddressMesage;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public RegisterPageObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    public void populateObject(HashMap<String, String> testData){
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "firstName":
                    setFirstName(testData.get(Key));
                    break;
                case "lastName":
                    setLastName(testData.get(Key));
                    break;
                case "email":
                    setEmail(testData.get(Key));
                    break;
                case "password":
                    setPassword(testData.get(Key));
                    break;
                case "noAddressMesage":
                    setNoAddressMesage(testData.get(Key));
                    break;
                case "newFirstName":
                    setNewFirstName(testData.get(Key));
                    break;
                case "newLastName":
                    setNewLastName(testData.get(Key));
                    break;
                case "newEmail":
                    setNewEmail(testData.get(Key));
                    break;
                case "newCity":
                    setNewCity(testData.get(Key));
                    break;
                case "newAddress1":
                    setNewAddress1(testData.get(Key));
                    break;
                case "newZip":
                    setNewZip(testData.get(Key));
                    break;
                case "newPhoneNumber":
                    setNewPhoneNumber(testData.get(Key));
                    break;
                case "newPassword":
                    setNewPassword(testData.get(Key));
                    break;
            }
        }
    }
}
