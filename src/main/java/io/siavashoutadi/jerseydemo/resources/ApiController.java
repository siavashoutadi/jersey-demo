package io.siavashoutadi.jerseydemo.resources;

import io.siavashoutadi.jerseydemo.product.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/v1.0")
public class ApiController {
  @Path("/products")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Product> getProducts() {
    Product p = new Product();
    p.setId("1");
    p.setName("pen");
    p.setPrice(10);
    p.setQuantity(5);
    p.setImage("http://www.hobbycraft.co.uk/supplyimages/614647_1000_1_800.jpg");

    List<Product> products = new ArrayList<>();
    products.add(p);

    return products;
  }

  @Path("/product/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Product getPlayer(@PathParam("id") String id) {
    Product p = new Product();
    p.setId("1");
    p.setName("pen");
    p.setPrice(10);
    p.setQuantity(5);
    p.setImage("http://www.hobbycraft.co.uk/supplyimages/614647_1000_1_800.jpg");
    return p;
  }
}
