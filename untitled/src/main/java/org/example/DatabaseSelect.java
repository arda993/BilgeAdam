package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseSelect {
    public void select(String jdbcUrl, String username, String password, ArrayList<String> columns){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            String selectSQL = "SELECT * FROM CUSTOMER";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            int intData = 0;
            FileWriter myWriter = new FileWriter("filename.txt");
            while(resultSet.next()) {
                for (int i = 1; i <= 6; i++) {
                    if (i == 3) {
                        int value = resultSet.getInt(columns.get(i - 1));
                        System.out.printf("Customer's %s is " + value+"\n",columns.get(i - 1));
                        myWriter.write("Customer's "+columns.get(i - 1)+" is " + value+"\n");
                    } else {
                        String value = resultSet.getString(columns.get(i - 1));
                        System.out.printf("Customer's %s is " + value+"\n",columns.get(i - 1));
                        myWriter.write("Customer's "+columns.get(i - 1)+" is " + value+"\n");
                    }
                }
                System.out.println("-------------------------------------");
            }
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
}
