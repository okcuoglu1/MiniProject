package companyManagementSystem.entities.concretes;

import RestaurantBillGenerator.Dish;
import companyManagementSystem.entities.abstracts.Order;

public class RestaurantOrder extends Order {


    public RestaurantOrder(Dish dish, int numOfDish) {
        super(dish, numOfDish);
    }
}
