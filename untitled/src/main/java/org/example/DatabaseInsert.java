package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatabaseInsert {

        public void insert (String jdbcUrl,String username,String password,ArrayList<String> columns)  {

            Scanner scanner = new Scanner(System.in);
            try{
                Connection connection = DriverManager.getConnection(jdbcUrl,username,password);

                //INSERT
                String  sqlInsertColumn = "(";
                for (int i = 0; i < columns.size(); i++) {
                    if (i!= columns.size()-1){
                        sqlInsertColumn+="?,";
                    }else {
                        sqlInsertColumn+="?)";
                    }
                }

                String insertSQL = "INSERT INTO CUSTOMER (name,surname,age,adress,city,country) VALUES "
                        + sqlInsertColumn;
                PreparedStatement insertStatment = connection.prepareStatement(insertSQL);
                for (int i = 1; i <= 6 ; i++) {
                    System.out.printf("Enter your %s :\n", columns.get(i - 1));
                    if (i==3){
                        int intValue = scanner.nextInt();
                        insertStatment.setInt(i, intValue);

                    }else {
                    String strValue = scanner.next();
                    insertStatment.setString(i, strValue);
                    }
                }

                insertStatment.executeUpdate();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        };

}
