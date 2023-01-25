package RestaurantBillGenerator;

public class CafeDishService extends DishService{

    @Override
    public void fillDishList() {
        Dish dish1=new Dish(401,"Tiramisu",35.0);
        Dish dish2=new Dish(402,"Dondurma",25.0);
        Dish dish3=new Dish(403,"Profiterol",25.0);
        Dish dish4=new Dish(404,"Kahve",17.5);
        Dish dish5=new Dish(405,"Çay",7.5);
        Dish dish6=new Dish(406,"Portakal Suyu",25.5);
        super.dishList.add(dish1);
        super.dishList.add(dish2);
        super.dishList.add(dish3);
        super.dishList.add(dish4);
        super.dishList.add(dish5);
        super.dishList.add(dish6);
    }
}
