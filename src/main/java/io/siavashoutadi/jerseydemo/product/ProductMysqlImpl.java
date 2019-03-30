package io.siavashoutadi.jerseydemo.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMysqlImpl implements ProductDao {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

  private String connectionString;
  private String user;
  private String pass;

  public ProductMysqlImpl(String connectionString, String user, String pass) {
    this.connectionString = connectionString;
    this.user = user;
    this.pass = pass;
  }

  @Override
  public List<Product> getProducts() {
    Statement statement = getStatement();

    String selectTableSQL = "SELECT productID, name, price, quantity, image FROM products";
    List<Product> products = new ArrayList<>();
    try {
      ResultSet rs = statement.executeQuery(selectTableSQL);
      while (rs.next()) {
        Product p = new Product();
        p.setId(rs.getString("productID"));
        p.setName(rs.getString("name"));
        p.setImage(rs.getString("image"));
        p.setPrice(rs.getFloat("price"));
        p.setQuantity(rs.getInt("quantity"));
        products.add(p);
      }
    } catch (
        Exception e) {
      throw new RuntimeException(e);
    }
    return products;
  }

  @Override
  public Product getProduct(String id) {
    List<Product> products = getProducts();
    for(Product p: products){
      if(p.getId().equalsIgnoreCase(id)){
        return p;
      }
    }
    return null;
  }

  private Statement getStatement() {

    try {
      Class.forName(JDBC_DRIVER);
      Connection connection = DriverManager.getConnection(connectionString, user, pass);
      return connection.createStatement();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
