package io.siavashoutadi.jerseydemo.product;

public class Product{
  private String id;
  private String name;
  private int quantity;
  private float price;

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  private String image;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}

