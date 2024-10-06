import java.util.ArrayList;
import java.util.Objects;

public class Psychologist extends Human implements IHuman{



    @Override
    public void GetHumanData() {

    }

    @Override
    public void UpdateHumanData() {

    }

    @Override
    public void AddTest(Test test) {
        ArrayList<Test> tests = getTests();
        tests.add(test);
        setTests(tests);
    }

    @Override
    public Boolean PasswordControl(String password) {
        if (Objects.equals(password, getPassword())){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean UsernameControl(String username) {
        if (Objects.equals(username, getUsername())){
            //System.out.println("username doğru");
            return true;
        }
        else{
            return false;
        }
    }

}
