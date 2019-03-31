package io.siavashoutadi.jerseydemo.resources;

import io.siavashoutadi.jerseydemo.product.Product;
import io.siavashoutadi.jerseydemo.product.ProductFactory;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/v1.0")
public class ApiController {
  @Path("/health")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHealth() {
    String hostname =  System.getenv("HOSTNAME");
    return "Running OK on " + hostname;
  }

  @Path("/products")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Product> getProducts() {
   return ProductFactory.getProductImpl().getProducts();
  }

  @Path("/product/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Product getPlayer(@PathParam("id") String id) {
    return ProductFactory.getProductImpl().getProduct(id);
  }
}
