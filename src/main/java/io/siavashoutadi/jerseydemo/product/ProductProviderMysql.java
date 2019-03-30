package io.siavashoutadi.jerseydemo.product;

public class ProductProviderMysql implements ProductProvider {

  @Override
  public boolean canHandle(String connectionString) {
    return connectionString.startsWith("jdbc:mysql");
  }

  @Override
  public ProductDao getProductDao(String connectionString, String user, String pass) {
    if (canHandle(connectionString)) {
      return new ProductMysqlImpl(connectionString, user, pass);
    }
    throw new RuntimeException("Could not get CSV Data Access Object Interface");

  }
}
