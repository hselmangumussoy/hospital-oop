public class Question implements IQuestion {

    //private int QuestionNum;
    private String QuestionDescription;
    private String Option_A;
    private String Option_B;
    private String Option_C;
    private int OA_Score; //Option A Score
    private int OB_Score; //Option B Score;
    private int OC_Score; //Option C Score;

    @Override
    public void GetQuestion() {

    }

    @Override
    public void UpdateQuestion() {

    }

    @Override
    public void DeleteQuestion() {

    }

    @Override
    public void AddQuestion() {

    }

    public String getQuestionDescription() {
        return QuestionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        QuestionDescription = questionDescription;
    }

    public String getOption_A() {
        return Option_A;
    }

    public void setOption_A(String option_A) {
        Option_A = option_A;
    }

    public String getOption_B() {
        return Option_B;
    }

    public void setOption_B(String option_B) {
        Option_B = option_B;
    }

    public String getOption_C() {
        return Option_C;
    }

    public void setOption_C(String option_C) {
        Option_C = option_C;
    }

    public int getOA_Score() {
        return OA_Score;
    }

    public void setOA_Score(int OA_Score) {
        this.OA_Score = OA_Score;
    }

    public int getOB_Score() {
        return OB_Score;
    }

    public void setOB_Score(int OB_Score) {
        this.OB_Score = OB_Score;
    }

    public int getOC_Score() {
        return OC_Score;
    }

    public void setOC_Score(int OC_Score) {
        this.OC_Score = OC_Score;
    }
}
