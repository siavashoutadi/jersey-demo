package io.siavashoutadi.jerseydemo.product;

public interface ProductProvider {

  boolean canHandle(String connectionString);

  ProductDao getProductDao(String connectionString, String user, String pass);
}
