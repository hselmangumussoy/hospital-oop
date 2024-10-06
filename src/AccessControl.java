import java.util.Objects;

public abstract class AccessControl extends Human {
    public Boolean PasswordControl(String password) {

        if(Objects.equals(password, getUsername())){
            //System.out.println("Username Doğru");
            return true;
        }
        else {
            //System.out.println("Username Yanlış");
            return false;
        }
    }

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
