import java.util.ArrayList;
import java.util.Objects;

public class Doctor extends Human implements IHuman {

  /*  public Doctor(int DoctorID, String DoctorName,String DoctorSurname,int DoctorAge,int DoctorExperience,String DoctorBranch){

    }
*/

    //constructor
    public Doctor() {
    }

     public void AddTest(Test test){
        ArrayList<Test> tests = getTests();
        tests.add(test);
        setTests(tests);
     }
    @Override
    public void GetHumanData() {

    }

    @Override
    public void UpdateHumanData() {

    }

    @Override
    public Boolean PasswordControl(String password) {
        if(Objects.equals(password,getPassword())){
            System.out.println("Şifre Doğru");
          return true;
        }
        else{
            System.out.println("Şifre Yanlış");
            return false;
        }
    }

    @Override
    public Boolean UsernameControl(String username) {


        if(Objects.equals(username, getUsername())){
            //System.out.println("Username Doğru");
            return true;
        }
        else {
            //System.out.println("Username Yanlış");
            return false;
        }
    }



}
