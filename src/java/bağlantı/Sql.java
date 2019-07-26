package bağlantı;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {
  private Connection DBConnector;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Başarılı bağlantı");
                    
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("failed"+cnfe);
        }
        
        try{
            DBConnector =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/davatakipveritabani", "root","root1234");
            System.out.println("Db connected\n");
        }
        catch(SQLException sle){
            System.out.println("No db\n"+sle);
        }
        return  DBConnector;
    }
    public static void main(String args[]){
        new Sql().connect();
    }

}