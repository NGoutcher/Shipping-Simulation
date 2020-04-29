import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Driver {

    public static void main(String[] args) throws InterruptedException, ApiException, IOException {
        InputHandler input = new InputHandler();
        System.exit(0);

        /*ArrayList<Integer> storage_ids = DatabaseHandler.getAllStoragePlantsID();
        ArrayList<String> storage_locations = DatabaseHandler.getAllStoragePlantsLocation();
        ArrayList<Integer> item_ids = DatabaseHandler.getAllItemsID();

        ArrayList<String> inStock = new ArrayList<String>();

        int purchaseItemID = item_ids.get(0);

        System.out.println("You want to buy item: " + purchaseItemID);

        for(int i = 0; i < storage_locations.size(); i++) {
            if(DatabaseHandler.getStockCount(storage_ids.get(i), purchaseItemID) > 0) {
                inStock.add(storage_locations.get(i));
                System.out.println("Your item is in stock at Storage ID: " + storage_ids.get(i) + ", Location: " + storage_locations.get(i));
            }
        }

        String address = "22 Mackenzie Gardens, East Kilbride, Glasgow, G74 4SA";
        ArrayList<Long> distances = new ArrayList<Long>();

        for(int i = 0; i < inStock.size(); i++) {
            long distance = MapsHandler.calculateDistance(address, inStock.get(i));
            distances.add(distance);
            System.out.println("The distance between: " + address + " and " + inStock.get(i) + " is " + distance + " metres.");
        }

        long lowest = distances.get(0);
        String lowestLocation = inStock.get(0);
        for(int i = 0; i < distances.size(); i++) {
            if(lowest > distances.get(i)) {
                lowest = distances.get(i);
                lowestLocation = inStock.get(i);
            }
        }

        System.out.println("Your item will be shipped from " + lowestLocation + " as it has the lowest distance from your address.");

        /*System.out.println("The distance between " + storage_locations.get(1) + " and " + storage_locations.get(2) + " is: " +
                MapsHandler.calculateDistance(storage_locations.get(1), storage_locations.get(2)) + " meters.");

        System.exit(0);*/
    }
}
