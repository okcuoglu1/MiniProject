package loginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernames=new ArrayList<>();
    List<String> emails=new ArrayList<>();
    List<String> passwords=new ArrayList<>();


    public void register(){
        Scanner inp=new Scanner(System.in);
        System.out.println("Ad-Soyad : ");
        String name=inp.nextLine();

        String username;
        boolean existsUsername;
        do {
            System.out.println(" Kullanıcı adı giriniz:");
            username=inp.nextLine();
            existsUsername=this.usernames.contains(username);
            if(existsUsername){
                System.out.println("Bu username kullanılmış, farklı bir username deneyiniz!");
            }
        }while(existsUsername);

        String email;
        boolean isValid;
        boolean existsEmail;
        do {
            System.out.println("Email giriniz: ");
            email=inp.nextLine().trim();
            isValid=validateEmail(email);
            existsEmail=this.emails.contains(email);
            if(existsEmail){
                System.out.println("Bu email zaten kayıtlı, farklı bir email deneyiniz!");
                isValid=false;
            }
        }while(!isValid);

        String password;
        boolean isValidPsw;
        do {
            System.out.println("Şifrenizi giriniz: ");
            password= inp.nextLine().trim();//next metodu yerine tüm satırı okumak için nextLine ile değiştirdik.
            isValidPsw=validatePassword(password);
        }while(!isValidPsw);

        User user=new User(name,username,email,password);
        this.usernames.add(user.username);
        this.emails.add(user.email);
        this.passwords.add(user.password);
        System.out.println("Tebrikler işleminiz başarıyla gerçekleştirildi.");
        System.out.println("Kullanıcı adı veya email ile sisteme giriş yapabilirsiniz.");

    }

    public void login(){
        Scanner inp=new Scanner(System.in);
        System.out.println("Kullanıcı adı veya email giriniz:");
        String usernameOrEmail=inp.nextLine();//sparrow

        //kullanıcının girdiği değer email mi username mi?
        boolean isMail=this.emails.contains(usernameOrEmail);
        boolean isUsername=this.usernames.contains(usernameOrEmail); //sparrow kayıtlı ise true
        if(isUsername || isMail){
            boolean isWrong=true;
            while(isWrong){
                System.out.println("Şifrenizi giriniz: ");
                String password=inp.next();
                //username/email ile şifre aynı indexte olmalı
                int index;
                if(isUsername){
                    index=this.usernames.indexOf(usernameOrEmail);
                }else{
                    index=this.emails.indexOf(usernameOrEmail);
                }
                if(this.passwords.get(index).equals(password)){
                    System.out.println("Sisteme giriş yaptınız.");
                    isWrong=false;
                }else {
                    System.out.println("Şifreniz yanlış, tekrar deneyiniz!");
                }
            }
        }else{
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz lütfen üye olunuz.");
        }


    }

    public static boolean validateEmail(String email){
        boolean isValid;
        boolean space=email.contains(" ");
        boolean isContainAt=email.contains("@");
        if(space){
            System.out.println("Email boşluk içeremez!");
            isValid=false;
        }else if(!isContainAt){
            System.out.println("Email @ içermelidir!");
            isValid=false;
        }else{//asd123-._@gmail.com split->[asd123-._,gmail.com]
            String firstPart=email.split("@")[0];
            String secondPart=email.split("@")[1];

            int notValid=firstPart.replaceAll("[a-zA-Z0-9_.-]","").length(); //Asd12-._*=>*
            boolean checkStart=notValid==0;

            boolean checkEnd=secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if(!checkStart){
                System.out.println("email küçük harf, büyük harf, rakam ve -._ dışında karakter içeremez!");
            } else if (!checkEnd) {
                System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");
            }
            isValid=checkStart && checkEnd;

        }
        if(!isValid){
            System.out.println("Geçersiz email, tekrar deneyiniz.");
        }
        return isValid;
    }

    public static boolean validatePassword(String password){
        boolean isValid;
        String upperLetter=password.replaceAll("[^A-Z]","");//asDF123->DF
        String lowerLetter=password.replaceAll("[^a-z]","");
        String digit=password.replaceAll("[\\D]","");
        String symbol=password.replaceAll("[\\P{Punct}]","");
        boolean space=password.contains(" ");
        boolean lengthGt6=password.length()>=6;
        boolean existsUpper=upperLetter.length()>0;
        boolean existsLower=lowerLetter.length()>0;
        boolean existsDigit=digit.length()>0;
        boolean existsSymbol=symbol.length()>0;

        if(space){
            System.out.println("Şifre boşluk içeremez!");
        }else if(!lengthGt6){
            System.out.println("Şifre en az 6 karakter olmalıdır!");
        } else if (!existsUpper) {
            System.out.println("Şifre en az bir tane büyük harf içermelidir!");
        } else if (!existsLower) {
            System.out.println("Şifre en az bir tane küçük harf içermelidir!");
        } else if (!existsDigit) {
            System.out.println("Şifre en az bir tane rakam içermelidir!");
        } else if (!existsSymbol) {
            System.out.println("Şifre en az bir tane sembol içermelidir!");
        }
        isValid=!space && lengthGt6 && existsUpper && existsLower && existsDigit && existsSymbol;
        if(!isValid){
            System.out.println("Tekrar deneyiniz!");
        }
        return isValid;
    }


}
