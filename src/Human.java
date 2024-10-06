import java.util.ArrayList;

public class Human {

    private String Name;
    private String Surname;
    private String Username;
    private String Password;
    private int Age;
    private int Experience;
    private String Branch;
    private ArrayList<Test> Tests = new ArrayList<Test>();





    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public ArrayList<Test> getTests() {
        return Tests;
    }

    public void setTests(ArrayList<Test> tests) {
        Tests = tests;
    }
}
