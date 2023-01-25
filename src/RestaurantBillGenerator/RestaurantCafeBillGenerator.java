package RestaurantBillGenerator;

import java.util.Scanner;

public class RestaurantCafeBillGenerator {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner inp=new Scanner(System.in);
        OrderService orderService=new OrderService();
        System.out.println("Merhaba");
        System.out.println("1-Restaurant");
        System.out.println("2-Kafeterya");
        int option=inp.nextInt();
        if(option==1){
            DishService dishService=new DishService();
            dishService.fillDishList();//dishservice
            getSelectionMenu(dishService,orderService);
        }else{
            DishService dishService=new CafeDishService();
            dishService.fillDishList();//cafedish service
            getSelectionMenu(dishService,orderService);
        }

    }
    public static void getSelectionMenu(DishService dishService, OrderService orderService){
        Scanner inp=new Scanner(System.in);
        int select=-1;
        while(select!=0) {
            System.out.println("----------------------------------------------------");
            System.out.println(" *** Lezzet Restaurant/Cafe Sipariş Uygulaması ***");
            System.out.println("1-Menü");
            System.out.println("2-Sipariş girme");
            System.out.println("3-Sipariş iptal etme");
            System.out.println("4-Hesap oluşturma");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz:");
            select=inp.nextInt();
            System.out.println("----------------------------------------------------");
            switch (select){
                case 1:
                    dishService.showDishMenu();//1:dish service 2:dish service
                    break;
                case 2:
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    orderService.deleteOrder();
                    break;
                case 4:
                    orderService.printBill();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }

        }
        System.out.println("İyi günler dileriz...");


    }

}


