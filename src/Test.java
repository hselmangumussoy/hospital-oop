import java.util.ArrayList;
public class Test implements ITest {
    private String TestName;
    private String TestDesc;
    private ArrayList<Question> Questions = new ArrayList<Question>();
    private int TestScore = 0;

    @Override
    public void GetTest() {

    }

    @Override
    public void UpdateTest() {

    }

    @Override
    public void DeleteTest() {

    }

    @Override
    public void AddTest() {

    }

    public String getTestName() {
        return TestName;
    }

    public void setTestName(String testName) {
        TestName = testName;
    }

    public String getTestDesc() {
        return TestDesc;
    }

    public void setTestDesc(String testDesc) {
        TestDesc = testDesc;
    }

    public ArrayList<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        Questions = questions;
    }
    public void AddQuestionInArrayList(Question question){
         Questions.add(question);
    }

    public int getTestScore() {
        return TestScore;
    }

    public void setTestScore(int testScore) {
        TestScore = testScore;
    }
}
