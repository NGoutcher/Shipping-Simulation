import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {

    public static void addStoragePlant(String location) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "insert into storage (location) values (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location);

            System.out.println(preparedStatement);
            preparedStatement.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeStoragePlant(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "delete from storage where storage_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement);
            preparedStatement.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> getAllStoragePlantsID() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from storage";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("storage_id");
                list.add(id);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> getAllStoragePlantsLocation() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from storage";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String location = resultSet.getString("location");
                list.add(location);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addItem(String name, double cost, String currency) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "insert into items (name, cost, currency) values (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, cost);
            preparedStatement.setString(3, currency);

            System.out.println(preparedStatement);
            preparedStatement.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int removeItem(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "delete from items where item_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement);
            preparedStatement.execute();

            connection.close();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("This item is used in the stock table, please remove from stock table first.");
            return 2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static ArrayList<Integer> getAllItemsID() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from items";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("item_id");
                list.add(id);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> getAllItemNames() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from items";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                list.add(name);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Double> getAllItemCosts() {
        ArrayList<Double> list = new ArrayList<Double>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from items";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                double cost = resultSet.getDouble("cost");
                list.add(cost);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<String> getAllItemCurrency() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from items";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String currency = resultSet.getString("currency");
                list.add(currency);
            }
            statement.close();

            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void addStock(int storageId, int itemId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "insert into stock (storage_id, item_id) values (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, storageId);
            preparedStatement.setInt(2, itemId);

            System.out.println(preparedStatement);
            preparedStatement.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getStockCount(int storage_id, int item_id) {
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ordering_system?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    ,"root","SQLpasswordTest1234");

            String query = "select * from stock";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int stor_id = resultSet.getInt("storage_id");
                int itm_id = resultSet.getInt("item_id");

                if(stor_id == storage_id && item_id == itm_id) {
                    count++;
                }
            }
            statement.close();

            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
