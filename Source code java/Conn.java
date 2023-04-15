
package hotel.management.system;
import java.sql.*;
/**
 *
 * @author Ashutosh
 */
public class Conn {
    Connection c;//sql pack
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");//1-Register the driver class by Jar file forname static method   
        c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","@Ashu2808");//2-Creating the connection
        s=c.createStatement();//3-creating a statement helps in executing mysql queries
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
}
