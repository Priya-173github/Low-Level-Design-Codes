// singletoc
package zomato.managers;
import java.util.ArrayList;
import java.util.List;
import zomato.models.Restaurant;

public class RestaurantManager {
    
    private ArrayList<Restaurant> restaurants;
    private static RestaurantManager instance;

    private RestaurantManager(){

    }

    public static RestaurantManager getInstance(){
        if(instance != null){
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }

    // business logic
    List<Restaurant> searchByLocation(String loc){
        List<Restaurant> result = new ArrayList<>();
        String searchLoc = loc.toLowerCase();
        for(Restaurant r : restaurants){
            String restaurantLoc = r.getLocation().toLowerCase();

            if(restaurantLoc.equals(searchLoc)){
                result.add(r);
            }
        }
        return result;
    }

    

    
}
