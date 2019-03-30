package io.siavashoutadi.jerseydemo.product;

import java.util.List;

public interface ProductDao {

  public List<Product> getProducts();

  public Product getProduct(String id);
}
