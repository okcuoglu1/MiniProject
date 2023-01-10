import java.util.Random;
import java.util.Scanner;

/*
Proje: Sayısal Loto Uygulaması
       bilet için rastgele n tane sayı üretilsin.
       loto sonucu rastgele n tane sayı ile üretilsin.
       sayısal lotoda tekrarlı sayılar olmamalı.

       n(hane sayısı), sayılar için min ve max değerler
       kullanıcıdan alınsın.

       sonuç ve bilet karşılaştırılsın, kaç eşleşme olduğu
       kullanıcıya bildirilsin.

*/
public class SayisalLoto {
    public static void main(String[] args) {
        startLoto();
    }


    public static void startLoto() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Sayısal loto için hane sayısını giriniz: ");
        int slots = inp.nextInt();
        System.out.print("Sayılar için min değer giriniz: ");
        int min = inp.nextInt();
        System.out.print("Sayılar için max değer giriniz: ");
        int max = inp.nextInt();
        //loto ve bilet için
        int[] lotoArr = new int[slots];
        int[] ticketArr = new int[slots];

        int randomNumber1 = 0;
        int randomNumber2 = 0;
        Random random = new Random();
        boolean isRepeated;
        for (int i = 0; i < slots; i++) {
            do {
                isRepeated = false;
                // 0 ile değer arasında rastgele sayı, değer dahil değil
                //   randomNumber1=random.nextInt(10+1-5)+5; // ->0,1,2,3,4,5 -> 5,6,7,8,9,10
                randomNumber1 = random.nextInt(max + 1 - min) + min;
                //random sayı dizide var mı kontrol et
                for (int j = 0; j < i; j++) {
                    if (lotoArr[j] == randomNumber1) {
                        isRepeated = true;
                        break;
                    }
                }

            } while (isRepeated);
            lotoArr[i] = randomNumber1;

            do {
                isRepeated = false;
                // 0 ile değer arasında rastgele sayı, değer dahil değil
                //   randomNumber1=random.nextInt(10+1-5)+5; // ->0,1,2,3,4,5 -> 5,6,7,8,9,10
                randomNumber2 = random.nextInt(max + 1 - min) + min;
                //random sayı dizide var mı kontrol et
                for (int j = 0; j < i; j++) {
                    if (ticketArr[j] == randomNumber2) {
                        isRepeated = true;
                        break;
                    }
                }

            } while (isRepeated);
            ticketArr[i] = randomNumber2;
        }
        System.out.println("Benim biletim: ");
        for (int i = 0; i < ticketArr.length; i++) {
            System.out.print(ticketArr[i] + " ");
        }
        System.out.println();
        System.out.println("Loto sonucu: ");
        for (int i = 0; i < lotoArr.length; i++) {
            System.out.print(lotoArr[i] + " ");

        }
        System.out.println();
        int result=compareArr(lotoArr,ticketArr);
        if (result>0) {
            System.out.println("Tebrikler! " + result + " eşleşme var.");
        }else {
            System.out.println("Malesef eşleşme yok, bir dahaki sefere:)");
        }
    }

    public static int compareArr(int[] arr, int[] brr){
        int counter=0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < brr.length; j++){
                if (arr[i]==brr[j]){
                    counter++;
                }
            }
        }
    return counter;
    }
}
