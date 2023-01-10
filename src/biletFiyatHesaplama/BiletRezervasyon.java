package biletFiyatHesaplama;

/*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.

         Mesafe başına ücret 1 TL / km olarak alın.(Gidiş-Dönüş için *2)
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir

       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.

       2-Yaş indirimi:
        Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.

       3-Tekli Koltuk ücreti:
        Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 artırılır.

 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiletRezervasyon {

    public static void main(String[] args) {

        //Koltuk listemiz hazır
        List<String> seatNo = new ArrayList<String>();

        for (int i = 1; i < 33; i++) {

            seatNo.add(String.valueOf(i));

        }

        Bilet bilet = new Bilet();
        Bus bus = new Bus("34 IST 78", seatNo);

        start(bilet,bus);


    }

    public static void start(Bilet bilet, Bus bus) {

        Scanner input = new Scanner(System.in);

        int select = 0;

        do {

            System.out.println("Bilet Rezervasyon Sistemine Hosgeldiniz...");
            System.out.print("Lutfen gidilecek mesafeyi km olarak giriniz: ");
            bilet.distance = input.nextInt();
            System.out.println("Lutfen yolculuk tipini seçiniz: ");
            System.out.println("1) Tek Yön\n 2) Gidiş-Dönüş");
            bilet.typeNo = input.nextInt();
            System.out.println("Lutfen yaşınızı giriniz: ");
            int age = input.nextInt();
            System.out.println("Lutfen koltuk no seçiniz: ");
            System.out.println("(Tekli koltuk ücreti %20 daha fazladır.)");

            System.out.println(bus.seats);
            bilet.seatNo = input.nextInt();

            //Kullanıcının seçtiği koltuğu listeden kaldırdık.
            bus.seats.remove(String.valueOf(bilet.seatNo));

            boolean check = (bilet.typeNo == 1 || bilet.typeNo == 2) && bilet.distance > 0 && age > 0;

            if (check) {

                bilet.price = getTotal(bilet,age);
                bilet.printBilet(bus);



            } else {
                System.out.println("Hatalı Giriş Yaptınız!");
            }
            System.out.println("Yeni işlem için 1, Çıkış için 0 giriniz.");
            select = input.nextInt();


        } while (select != 0);

        System.out.println("İyi Günler Dİleriz...");


    }

    public static double getTotal(Bilet bilet, int age) {

        int dist = bilet.distance; //Her defasında uzun yazmamak icin bir variable atadık.
        int type = bilet.typeNo;
        int seatNo = bilet.seatNo;
        double total = 0;

        switch (type) {

            case 1:
                if (seatNo % 3 == 0) {
                    total = dist * 1.20; //tekli koltuk secerse %20 fazla olur.
                } else {
                    total = dist * 1;
                }
                System.out.println("Tutar : " + total);
                break;

            case 2:
                if (seatNo % 3 == 0) {
                    total = dist * 2.4; //tekli koltuk secerse %20 fazla olur.
                } else {
                    total = dist * 2;
                }
                System.out.println("Tutar : " + total);
                total = total*0.8;
                System.out.println("Gidiş-Dömüş indirimli tutar: " + total);
                break;

        }

        if(age<=12){

            total = total/2;
            System.out.println("Yaş indirimli tutar: " + total);

        }else if(age>12 && age<24){

            total = total * 0.9;
            System.out.println("Yaş indirimli tutar: " + total);

        } else if(age>65){

            total = total*0.7;
            System.out.println("Yaş indirimli tutar: " + total);

        }

        return total;
    }


    }



