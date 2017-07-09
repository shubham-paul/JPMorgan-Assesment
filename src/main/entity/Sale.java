package main.entity;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: Sale
 *
 *      A Sale class contains data for each message passed to the Saes application.
 *
 */
public class Sale {

    private Product product=null;
    private int quantity=0;
    private Adjustment adjustment=null;


    public Sale(Adjustment adjustment) {
        this.adjustment = adjustment;
    }

    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Adjustment getAdjustment() {
        return adjustment;
    }


}
