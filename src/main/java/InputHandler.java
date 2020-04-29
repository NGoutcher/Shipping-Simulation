import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {
    public InputHandler() {
        printCommands();

        String s = "";
        while(!s.equals("exit") && !s.equals("Exit")) {
           // System.out.print("-> ");
            Scanner input = new Scanner(System.in);
            s = input.nextLine();
            Handle(s);
        }
        System.out.println("Program closing..");
    }

    public void Handle(String input) {
        if(input.equals("help")) {
            printCommands();
        } else if(input.equals("aStorage")) {
            System.out.println("Give full address of storage plant: ");
            DatabaseHandler.addStoragePlant(subInputString());
        } else if(input.equals("rStorage")) {
            ArrayList<Integer> ids = DatabaseHandler.getAllStoragePlantsID();
            ArrayList<String> locations = DatabaseHandler.getAllStoragePlantsLocation();
            System.out.println("Stored storage plants: ");
            for(int i = 0; i < ids.size(); i++) {
                System.out.println("ID: " + ids.get(i) + " | Location: " + locations.get(i));
            }
            System.out.println("Give the ID of the storage plant you wish to remove.");
            int temp = subInputInt();
            boolean found = false;
            for(int i = 0; i < ids.size(); i++) {
                if(ids.get(i) == temp) {
                    found = true;
                    DatabaseHandler.removeStoragePlant(temp);
                    System.out.println("ID: " + ids.get(i) + " | Location: " + locations.get(i) + " has been removed. Exiting to main menu.");
                }
            }
            if(!found) {
                System.out.println("Storage plant not found. Exiting to main menu.");
            }
        } else if(input.equals("gStorage")) {
            ArrayList<Integer> ids = DatabaseHandler.getAllStoragePlantsID();
            ArrayList<String> locations = DatabaseHandler.getAllStoragePlantsLocation();
            System.out.println("Stored storage plants: ");
            for(int i = 0; i < ids.size(); i++) {
                System.out.println("ID: " + ids.get(i) + " | Location: " + locations.get(i));
            }
        } else if(input.equals("aItem")) {
            System.out.println("Give item name.");
            String name = subInputString();
            System.out.println("Give item cost.");
            double cost = subInputDouble();
            System.out.println("Give currency of cost.");
            String currency = subInputString();
            DatabaseHandler.addItem(name, cost, currency);
            System.out.println("Item added: " + name + ", " + currency + cost);
        } else if(input.equals("rItem")) {
            System.out.println("Items stored: ");
            for(int i = 0; i < DatabaseHandler.getAllItemsID().size(); i++) {
                System.out.println("ID: " + DatabaseHandler.getAllItemsID().get(i) + " | Name: " + DatabaseHandler.getAllItemNames().get(i) + " | Cost: " + DatabaseHandler.getAllItemCurrency().get(i) +
                        DatabaseHandler.getAllItemCosts().get(i));
            }
            System.out.println("Give the ID of the item you wish to remove.");
            int temp = subInputInt();
            boolean found = false;
            for(int i = 0; i < DatabaseHandler.getAllItemsID().size(); i++) {
                if(DatabaseHandler.getAllItemsID().get(i) == temp) {
                    found = true;
                    int tempId = DatabaseHandler.getAllItemsID().get(i);
                    String tempName = DatabaseHandler.getAllItemNames().get(i);
                    double tempCost = DatabaseHandler.getAllItemCosts().get(i);
                    String tempCurrency = DatabaseHandler.getAllItemCurrency().get(i);
                    if(DatabaseHandler.removeItem(temp) == 0) {
                        System.out.println("ID: " + tempId + " | Name: " + tempName + " | Cost: " + tempCurrency +
                                tempCost + " has been removed. Exiting to main menu.");
                    }
                }
            }
            if(!found) {
                System.out.println("Storage plant not found. Exiting to main menu.");
            }
        } else if(input.equals("gItems")) {
            System.out.println("Items stored: ");
            for(int i = 0; i < DatabaseHandler.getAllItemsID().size(); i++) {
                System.out.println("ID: " + DatabaseHandler.getAllItemsID().get(i) + " | Name: " + DatabaseHandler.getAllItemNames().get(i) + " | Cost: " + DatabaseHandler.getAllItemCurrency().get(i) +
                        DatabaseHandler.getAllItemCosts().get(i));
            }
        }
    }

    public String subInputString() {
        //System.out.println("-> ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }

    public int subInputInt() {
       // System.out.println("-> ");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        return i;
    }

    public double subInputDouble() {
        //System.out.println("-> ");
        Scanner input = new Scanner(System.in);
        double d = input.nextDouble();
        return d;
    }

    public void printCommands() {
        System.out.println("Commands:");
        System.out.println("aStorage - add a new storage facility.");
        System.out.println("aItem - add a new item.");
        System.out.println("aStock - add item stock to a storage facility.");
        System.out.println("--------------");
        System.out.println("rStorage - remove storage facility.");
        System.out.println("rItem - remove an item.");
        System.out.println("rStock - remove item stock from a storage facility.");
        System.out.println("--------------");
        System.out.println("gStorage - get all storage plants' information (ID and location).");
        System.out.println("gItems - get all items' information (ID, name, cost and currency).");
        System.out.println("gStock - get stock count of item at storage location.");
        System.out.println("--------------");
        System.out.println("help - get list of commands.");
        System.out.println("--------------");
    }
}
