package companyManagementSystem.entities.concretes;

import companyManagementSystem.entities.abstracts.Company;

import java.util.Scanner;

public class Restaurant extends Company {


    public void selectedRestaurantMenu(){

        int select = -1;

        Scanner inp = new Scanner(System.in);

        do {



            System.out.println("----------------------------------------------------");
            System.out.println("*** Lezzet Restaurant/Cafe Sipariş Uygulaması ***");
            System.out.println("1-Menü");
            System.out.println("2-Sipariş girme");
            System.out.println("3-Sipariş iptal etme");
            System.out.println("4-Hesap oluştur");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz: ");
            select = inp.nextInt();
            System.out.println("----------------------------------------------------");
            switch (select) {
                case 1:
                   // dishService.showDishMenu();
                    break;
                case 2:
                   // orderService.createOrder(dishService);
                    break;
                case 3:
                   // orderService.deleteOrder();
                    break;
                case 4:
                   // orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    break;
            }

        }while (select!=0);
            System.out.println("İyi günler...");







    }
}



