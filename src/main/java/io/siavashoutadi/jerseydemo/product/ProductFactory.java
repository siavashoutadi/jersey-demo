package io.siavashoutadi.jerseydemo.product;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ProductFactory {

  private static List<ProductProvider> providers = getProviders();

  private static List<ProductProvider> getProviders() {
    List<ProductProvider> providers = new ArrayList<>();
    ServiceLoader<ProductProvider> serviceProviders = ServiceLoader.load(ProductProvider.class);
    for (ProductProvider provider : serviceProviders) {
      providers.add(provider);
    }
    return providers;
  }

  public static ProductDao getProductImpl() {
    String connectionString = System.getenv("JERSEY_DEMO_DB_CONNECTION_STRING");
    String user = System.getenv("JERSEY_DEMO_DB_USER");
    String pass = System.getenv("JERSEY_DEMO_DB_PASSWORD");

    if (connectionString == null) {
      throw new RuntimeException("No database connection string provided!");
    }

    if (user == null) {
      throw new RuntimeException("No database user provided!");
    }

    if (pass == null) {
      throw new RuntimeException("No database password provided!");
    }

    for (ProductProvider provider : providers) {
      if (provider.canHandle(connectionString)) {
        return provider.getProductDao(connectionString, user, pass);
      }
    }

    throw new RuntimeException("Can not support " + connectionString);
  }
}
