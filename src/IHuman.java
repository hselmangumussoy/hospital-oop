public interface IHuman {

    public void GetHumanData();
    public void UpdateHumanData();

    public void AddTest(Test test);

    public Boolean PasswordControl(String password);
    public Boolean UsernameControl(String username);
}
