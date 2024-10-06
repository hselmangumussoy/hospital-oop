import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    //Main Menu
    public static void ShowMainMenu(){
        System.out.println("--------------------------");
        System.out.println("-----RUH-FİZİK ANALİZ SİSTEMİ PRO-----");
        System.out.println("--------------------------");
        System.out.println("Doktor/Psikolog Girişi ==> D or P");
        System.out.println("Hasta Girişi ==> H");
        System.out.println("Sistem Yöneticisi Girişi ==> S");
        System.out.println("--------------------------");
    }

    public static void ShowTests(String username, String type){
        System.out.println("------------------------------");
        System.out.println("-----------Testlerin : " + username + "------------");
        System.out.println("------------------------------");

        if (type.equals("P")){
            System.out.println("Type Control P");
            for (Psychologist psy : HumanList.psikologlar){
                if (psy.getUsername().equals(username)){
                    for (Test test : psy.getTests()) {
                        System.out.println(test.getTestName());
                    }
                }
            }
        }
        else{
            System.out.println("is not doctor");
        }
        if (type.equals("D")){
            System.out.println("Type Control D");
        }
        else{
            System.out.println("is Not psychologist");
        }


    }
    public static void UpdateTest(String username, String type){
        
    }
    public static  void adding(){
        SystemAdmin systemAdmin = new SystemAdmin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------");
        String condition = "1. Doktor eklemek için : D\n" +
                "2. Piskolog eklemek için : P\n" +
                "3. Çıkış yapmak için : Q";
        while(true){
            System.out.println(condition);
            System.out.println("Ne eklemek isiyorsunuz? (Doktor veya Piskolog)");
            String istek = scanner.nextLine();
            if(istek.equals("D")){
                Doctor doc = systemAdmin.doctorInfo();
                System.out.println(doc.getUsername()+ doc.getName());

                systemAdmin.addDoctor(doc);
            }
            else if (istek.equals("P")) {
                Psychologist psi = systemAdmin.psicoInfo();
                systemAdmin.addPsychologist(psi);
            }
            else if(istek.equals("Q")){
                System.out.println("Ekleme işleminden çıkılıyor...");
                break;
            }
            else {
                System.out.println("Hatalı değer girildi...");
            }
        }
    }

    public static  void deleting(){
        SystemAdmin systemAdmin = new SystemAdmin();

        Human human = new Human();

        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------");
        String condition = "1. Doktor çıkarmak için : D\n" +
                "2. Psikolog çıkarmak için : P\n" +
                "3. Çıkış yapmak için : Q";


        while(true){
            System.out.println(condition);
            System.out.println("Ne Çıkarmak isiyorsunuz? (Doktor veya Psikolog)");
            String istek = scanner.nextLine();
            if(HumanList.doktorlar.isEmpty() && istek.equals("D") ){
                System.out.println("Doktor girişi yapılmamıştır.Lütfen doktor girişi yapıp tekrar deneyin.");
                break;
            }
            if(HumanList.psikologlar.isEmpty() && istek.equals("P"))
            {
                System.out.println("Psikolog girişi yapılmamıştır.Lütfen psikolog girişi yapıp tekrar deneyin.");
                break;
            }

            if(istek.equals("D")){
                systemAdmin.deleteDoctor();
            }
            else if (istek.equals("P")) {
                systemAdmin.deletePsychologist();
            }
            else if(istek.equals("Q")){
                System.out.println("Çıkarma işleminden çıkılıyor...");
                break;
            }
            else {
                System.out.println("Hatalı değer girildi...");
            }
        }
    }






    //Soru oluşturma
    public static Question CreateQuestion(){

        Scanner sc = new Scanner(System.in);
        Question tempQuestion = new Question();

        System.out.println("-------------------------------");
        System.out.println("------Soru Oluşturma Ekranı------");
        System.out.println("Soru Açıklaması Giriniz : ");
        String desc = sc.nextLine();
        tempQuestion.setQuestionDescription(desc);

        System.out.println("A Şıkkını Giriniz : ");
        String Option_A = sc.nextLine();
        System.out.println("A Şıkkının Skorunu Giriniz : ");
        int OA_Score = sc.nextInt();
        sc.nextLine();
        tempQuestion.setOption_A(Option_A);
        tempQuestion.setOA_Score(OA_Score);

        System.out.println("B Şıkkını Giriniz : ");
        String Option_B = sc.nextLine();
        System.out.println("B Şıkkının Skorunu Giriniz : ");
        int OB_Score = sc.nextInt();
        sc.nextLine();
        tempQuestion.setOption_B(Option_B);
        tempQuestion.setOB_Score(OB_Score);

        System.out.println("C Şıkkını Giriniz : ");
        String Option_C = sc.nextLine();
        System.out.println("C Şıkkının Skorunu Giriniz : ");
        int OC_Score = sc.nextInt();
        sc.nextLine();
        tempQuestion.setOption_C(Option_C);
        tempQuestion.setOC_Score(OC_Score);
        return tempQuestion;
    }

    //Test oluşturma
    public static void CreateTest(String username, String type){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Test İsmi Giriniz : ");
        String TestName = sc.nextLine();
        System.out.println("Test Açıklaması Giriniz");
        String  TestDesc = sc.nextLine();

        Test test = new Test();
        test.setTestName(TestName);
        test.setTestDesc(TestDesc);

        Boolean WhileCondition = true;
        do {
            System.out.println("----------------------------");
            System.out.println("-----Soru Oluşturma İşlemi-----");

            CreateQuestion();

            System.out.println("----------------------------");
            System.out.println("Yeni Soru Oluşturmak İstiyor Musun E/H");
            String continues = sc.nextLine();
            switch (continues)
            {
                case "E":
                {
                 break;
                }
                case "H":{
                    WhileCondition = false;
                    break;
                }
            }

        }while(WhileCondition);

        if (type.equals("D")){
            for (Doctor d :HumanList.doktorlar){
                if (d.getUsername().equals(username)){
                    d.AddTest(test);
                }
            }
        }
        if (type.equals("P")){
            for (Psychologist psy :HumanList.psikologlar){
                if (psy.getUsername().equals(username)){
                    psy.AddTest(test);
                }
            }
        }




    }

    public static void UpdateProcess(String username, String type){

        System.out.println("Update Processing Function");
        if (type.equals("P"))
        {
           for (Psychologist psychologist : HumanList.psikologlar){
               if (psychologist.getUsername().equals(username)) {

                   //güncelleme işlemleri
               }
               else{

               }

           }


        }
        if (type.equals("D"))
        {
             for (Doctor doctor : HumanList.doktorlar){
                 if (doctor.getUsername().equals(username)){
                     System.out.println(username+"doğrulandı");
                     doctor.setUsername("Fahri Gedik");
                 }

             }
             for (Doctor doctor : HumanList.doktorlar)
             {
                 System.out.println(doctor.getUsername());
             }
        }



    }



    //Doktor Menüsü
    public static void ShowDoctorMenu(String doctorusername, String type) {
        Scanner sc = new Scanner(System.in);
        Boolean DoctorWhileCondition = true;
        do {
            System.out.println("------------------------------");
            System.out.println("-----Doktor İşlemleri-----");
            System.out.println("------------------------------");
            System.out.println("Hastalık Testi Oluştur ==> (1)");

            System.out.println("Bilgilerimi Güncelle ==> (2)");
            System.out.println("Testlerimi Görüntüle ==> (3)");

            System.out.println("Çıkış yap ==> (0)");
            System.out.println("------------------------------");
            String doctorInput = sc.nextLine();
            switch (doctorInput) {
                case "1": {
                    System.out.println("Hastalık Testi Oluşturma İşlemleri");
                   CreateTest(doctorusername,type);

                }
                case "0": {
                    System.out.println("Çıkış Yapılıyor");
                    DoctorWhileCondition = false;
                }
                default: {
                    System.out.println("Hatalı İşlem Girişi Yapıldı. Konsol Temizleniyor.");
                }
            }
        }while(DoctorWhileCondition);
    }
    //Psikolog Menüsü
    public static void ShowPsycholgistMenu(String psicousername, String type){
        Scanner sc = new Scanner(System.in);
        Boolean PsicoWhileCondition = true;
        do {
            System.out.println("------------------------------");
            System.out.println("-----Psikolog İşlemleri-----");
            System.out.println("------------------------------");
            System.out.println("Hastalık Testi Oluştur ==> (1)");
            System.out.println("Çıkış yap ==> (0)");
            System.out.println("------------------------------");
            String psicoInput = sc.nextLine();
            switch (psicoInput)
            {
                case "1" : {
                    System.out.println("Hastalık Testi Oluşturma İşlemleri");
                    CreateTest(psicousername,type);
                }
                case "0" :{
                    System.out.println("Çıkış Yapılıyor");
                    PsicoWhileCondition=false;
                }
                default:{
                    System.out.println("Hatalı İşlem Girişi Yapıldı. Konsol Temizleniyor.");
                }
            }
        }while(PsicoWhileCondition);


    }
    //Admin Menüsü
    public static void showSystemAdminMenu(){
        System.out.println("Sistem Yöneticisine Hoşgeldiniz.");
        System.out.println("--------------------------------");

        System.out.println("1- Ekleme için: E\n" +
                "2- Çıkarmak için: C\n" +
                "3- Çıkış yapmak için: Q");
        System.out.println("--------------------------------");
    }


    public static void main(String[] args)
    {

        Doctor doctor1 = new Doctor();
        doctor1.setUsername("TestUsername");
        doctor1.setName("test");
        doctor1.setPassword("TestPassword");
        Doctor doctor2 = new Doctor();
        doctor2.setUsername("TestUsername2");
        doctor2.setName("test2");

        HumanList.doktorlar.add(doctor1);
        HumanList.doktorlar.add(doctor2);

        Scanner sc = new Scanner(System.in);

        Boolean WhileCondition = true;
        do {
           ShowMainMenu();
            String userInput = sc.nextLine();

            switch (userInput)
            {
                case "D" : {
                    System.out.println("Doktor Girişi Ekranı");
                    WhileCondition = false;
                    System.out.println("Doktor Kullanıcı Adı Giriniz ");
                    String username = sc.nextLine();
                    System.out.println("Şifre Giriniz ");
                    String password = sc.nextLine();

                    int ControlCounter = 0;
                    for (Doctor _doctor : HumanList.doktorlar){
                        if (_doctor.UsernameControl(username)){
                            //System.out.println("username kontrolü başarılı");

                            if (_doctor.PasswordControl(password))
                            {
                                System.out.println("Giriş Yapıldı.");
                                ShowDoctorMenu(username,"Doctor");
                            }
                            else{
                                System.out.println("Hatalı Şifre Lütfen Tekrar Deneyiniz");
                            }
                            ControlCounter = 0;

                            break;
                        }
                        else{
                            ControlCounter++;
                            /*System.out.println(humanList.doktorlar.size());
                            System.out.println(ControlCounter);*/
                            if (ControlCounter==HumanList.doktorlar.size()){
                                System.out.println(  username + " Adlı Doktor Bulunamamıştır Lütfen Tekrar Deneyiniz ");
                                WhileCondition=true;
                            }
                        }
                    }
                    break;
                }
               /* case "d" : {
                    System.out.println("Doktor Girişi Ekranı 2");
                    WhileCondition = false;
                    break;
                }*/

                case "P" : {
                    System.out.println("Psikolog Girişi Ekranı");
                    WhileCondition = false;
                    System.out.println("Psikolog Kullanıcı Adı Giriniz ");
                    String userName = sc.nextLine();
                    System.out.println("Şifre Giriniz ");
                    String password = sc.nextLine();

                    int ControlCounter = 0;
                    for (Psychologist _psico : HumanList.psikologlar){
                        if (_psico.UsernameControl(userName)){
                            //System.out.println("username kontrolü başarılı");

                            if (_psico.PasswordControl(password))
                            {
                                System.out.println("Giriş Yapıldı.");
                                ShowPsycholgistMenu(userName,"Psikolog");
                            }
                            else{
                                System.out.println("Hatalı Şifre Lütfen Tekrar Deneyiniz");
                            }
                            ControlCounter = 0;

                            break;
                        }
                        else{
                            ControlCounter++;
                            /*System.out.println(humanList.doktorlar.size());
                            System.out.println(ControlCounter);*/
                            if (ControlCounter==HumanList.psikologlar.size()){
                                System.out.println(  userName + " Adlı Psikolog Bulunamamıştır Lütfen Tekrar Deneyiniz ");
                                WhileCondition=true;
                            }
                        }
                    }
                    break;
                }
               /* case "d" : {
                    System.out.println("Doktor Girişi Ekranı 2");
                    WhileCondition = false;
                    break;
                }*/

                case "H" : {
                    System.out.println("Hasta Girişi Ekranı");
                    WhileCondition = false;
                    break;
                }
               /* case "h" : {
                    System.out.println("Hasta Girişi Ekranı 2");
                    WhileCondition = false;
                    break;
                }*/

                case "S" : {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Sistem Yöneticisi Girişi Ekranı");
                    showSystemAdminMenu();
                    String istek = scanner.nextLine();

                    if(istek.equals("E")){
                        adding();
                    }
                    else if (istek.equals("C")) {
                        deleting();
                    }
                    else {
                        System.out.println("Hatalı giriş yaptınız.");
                    }

                   /* for (Doctor item : HumanList.doktorlar)
                    {
                        System.out.println(item.getUsername());
                    }*/
                    WhileCondition = false;
                    break;
                }
               /* case "s" : {
                    System.out.println("Sistem Yöneticisi Girişi Ekranı 2");
                    WhileCondition = false;
                    break;
                }*/
                default: {
                    System.out.println("Hatalı Giriş Yapıldı Konsol Temizleniyor");
                    System.out.flush();
                }
            }


        }while(WhileCondition);







    }
}