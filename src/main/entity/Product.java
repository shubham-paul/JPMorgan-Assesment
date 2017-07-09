package main.entity;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: Product
 *
 *      A Product class contains data about the product and its value passed in a sales message.
 */
public class Product {

    private String productType;
    private double productPrice;

    public Product(String productType, double productPrice) {
        this.productType = productType;
        this.productPrice = productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
