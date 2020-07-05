package shop;

import java.sql.*;
import java.util.Vector;

public class sql extends  MyDBInfo {
    public static Vector<product> getProducts() {
        Vector<product> products = new Vector<product>();
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection( "jdbc:mysql://" + MYSQL_DATABASE_SERVER, MYSQL_USERNAME ,MYSQL_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE " +MYSQL_DATABASE_NAME);
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            rs.beforeFirst();
            while(rs.next()) {
                product cur = new product(rs.getString("productid"), rs.getString("name"),rs.getString("imagefile"), rs.getDouble("price"));
                products.add(cur);
            }
            stmt.close();
            con.close();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static product get (String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection( "jdbc:mysql://" + MYSQL_DATABASE_SERVER, MYSQL_USERNAME ,MYSQL_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE " +MYSQL_DATABASE_NAME);
            StringBuilder sb = new StringBuilder();
            sb.append("select * from products where ");
            sb.append("productid  = \""+id+"\"");
            PreparedStatement preparedStmt = con.prepareStatement(sb.toString());
            ResultSet rs = preparedStmt.executeQuery();
            rs.beforeFirst();
            rs.next();
            product cur = new product(rs.getString("productid"), rs.getString("name"),rs.getString("imagefile"), rs.getDouble("price"));
            stmt.close();
            con.close();
            return cur;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public static product getByName (String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection( "jdbc:mysql://" + MYSQL_DATABASE_SERVER, MYSQL_USERNAME ,MYSQL_PASSWORD);
            Statement stmt = con.createStatement();
            stmt.executeQuery("USE " +MYSQL_DATABASE_NAME);
            StringBuilder sb = new StringBuilder();
            sb.append("select * from products where ");
            sb.append("name  = \""+id+"\"");
            PreparedStatement preparedStmt = con.prepareStatement(sb.toString());
            ResultSet rs = preparedStmt.executeQuery();
            rs.beforeFirst();
            rs.next();
            product cur = new product(rs.getString("productid"), rs.getString("name"),rs.getString("imagefile"), rs.getDouble("price"));
            stmt.close();
            con.close();
            return cur;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
