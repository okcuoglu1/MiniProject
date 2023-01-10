package biletFiyatHesaplama;

public class Bilet {

    public int distance;

    public int typeNo;

    public int seatNo;

    public double price;


   public void printBilet(Bus bus){

       System.out.println("Toplam tutar: " + price);
       System.out.println("-----Bilet Detay-----");
       System.out.println("Otobüs Plakası: " + bus.numberPlate);
       System.out.println("Mesafe: " + distance);
       System.out.println("Yolculuk tipi: " +  (typeNo==1 ? "Tek Yön" : "Gidiş-Dönüş"));
       System.out.println("Koltuk no: " + seatNo);
       System.out.println("Keyifli Yolculuklar Dileriz...");

   }
}
