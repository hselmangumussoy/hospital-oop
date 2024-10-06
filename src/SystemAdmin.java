import java.util.Iterator;
import java.util.Scanner;

public class SystemAdmin {

    //private static int doctorNum;
   // private static int psicoNum;


    public void addDoctor(Doctor doc ){
       HumanList.doktorlar.add(doc);
    }

    public Doctor doctorInfo(){
        Doctor doctor = new Doctor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Doktorun Adı: ");
        String name = scanner.nextLine();
        doctor.setName(name);

        System.out.println("Doktorun Soyadı: ");
        String surname = scanner.nextLine();
        doctor.setSurname(surname);

        System.out.println("Doktorun Yaşı: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        doctor.setAge(age);

        System.out.println("Doktorun Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        doctor.setUsername(userName);

        System.out.println("Doktorun Şifresi: ");
        String password = scanner.nextLine();
        doctor.setPassword(password);

        System.out.println("Doktorun Deneyimi: ");
        int experiance = scanner.nextInt();
        scanner.nextLine();
        doctor.setExperience(experiance);


        System.out.println("Doktorun Alanı: ");
        String branch = scanner.nextLine();
        doctor.setBranch(branch);
        return doctor;

    }
    public void addPsychologist(Psychologist psi){
        HumanList.psikologlar.add(psi);
    }
    public Psychologist psicoInfo(){
        Psychologist psico = new Psychologist();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Piskoloğun Adı: ");
        String name = scanner.nextLine();
        psico.setName(name);

        System.out.println("Piskoloğun Soyadı: ");
        String surName = scanner.nextLine();
        psico.setSurname(surName);

        System.out.println("Piskoloğun Yaşı: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        psico.setAge(age);

        System.out.println("Piskoloğun Deneyimi: ");
        int experience = scanner.nextInt();
        scanner.nextLine();
        psico.setExperience(experience);

        System.out.println("Piskoloğun Alanı: ");
        String branch = scanner.nextLine();
        psico.setBranch(branch);

        System.out.println("Piskoloğun Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        psico.setUsername(userName);

        System.out.println("Piskoloğun Şifresi: ");
        String password = scanner.nextLine();
        psico.setPassword(password);
        return psico;
    }



    public void deleteDoctor(){
        Scanner scanner = new Scanner(System.in);

        Iterator<Doctor> iterator = HumanList.doktorlar.iterator();

        System.out.println("Hangi doktoru çıkarmak istiyorsunuz?(ismin girin)");
        String removeName = scanner.nextLine();
       // boolean removed = HumanList.doktorlar.remove(removeName);
        for (Doctor item : HumanList.doktorlar){
            System.out.println(item.getUsername());
        }
        while(iterator.hasNext()){
            Doctor doctor = iterator.next();
            if (doctor.getName().equals(removeName))
            {
                iterator.remove();
                System.out.println(removeName + " isimli doktor çıkarıldı.");
            }
        }

        //kontrol amaçlı if-else kullandım çalışırsa sadece yazdırırız.
      /*  if(removed){
            System.out.println(removeName + " isimli doktor çıkarıldı.");
        }
        else{
            System.out.println("Çıkarılacak eleman ismi doğru girilmedi.");
        }*/

    }



    public  void deletePsychologist(){
        Scanner scanner =new Scanner(System.in);
        Iterator<Psychologist> iterator = HumanList.psikologlar.iterator();
        System.out.println("Hangi psikoloğu çıkarmak istiyorsunuz?(ismin girin)");
        String removeName = scanner.nextLine();

        while(iterator.hasNext()){
            Psychologist ps = iterator.next();
            if (ps.getName().equals(removeName)){
                iterator.remove();
                System.out.println(removeName + " isimli psikolog çıkarıldı.");
            }
        }

        //kontrol amaçlı if else kullandım çalışırsa sadece yazdırırız.
        /*if(removed){

        }
        else{
            System.out.println("Çıkarılacak psikolog ismi doğru girilmedi.");
        }*/
    }


}
