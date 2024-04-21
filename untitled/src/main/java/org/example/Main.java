package org.example;
import java.util.ArrayList;
import java.util.Arrays;

/*
CREATE TABLE CUSTOMER (
    NAME VARCHAR,
    SURNAME VARCHAR,
    AGE  INT,
	ADRESS VARCHAR,
	CITY VARCHAR,
	COUNTRY VARCHAR
)
*/
public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/firstdb";
        String username = "postgres";
        String password = "123456";

        ArrayList<String> columns = new ArrayList<String>(
        Arrays.asList("name","surname","age","adress","city","country"));

        DatabaseInsert databaseInsert = new DatabaseInsert();
        //.insert(jdbcUrl,username,password,columns);

        DatabaseSelect databaseSelect = new DatabaseSelect();
        databaseSelect.select(jdbcUrl,username,password,columns);

        }


    }
