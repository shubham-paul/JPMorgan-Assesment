package main.entity;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: Adjustment
 *
 *      An adjustment class contains the data related to any price adjustment that happens in the application.
 */
public class Adjustment {

    private double adjustedPrice;
    private String adjustmentOperator;
    private String adjustmentProduct;
    private int adjustmentQuantity;

    public Adjustment(double adjustedPrice, String adjustmentOperator, String adjustmentProduct) {
        this.adjustedPrice = adjustedPrice;
        this.adjustmentOperator = adjustmentOperator;
        this.adjustmentProduct = adjustmentProduct;
    }

    public double getAdjustedPrice() {
        return adjustedPrice;
    }

    public String getAdjustmentOperator() {
        return adjustmentOperator;
    }

    public String getAdjustmentProduct() {
        return adjustmentProduct;
    }

    public int getAdjustmentQuantity() {
        return adjustmentQuantity;
    }

    public void setAdjustmentQuantity(int adjustmentQuantity) {
        this.adjustmentQuantity = adjustmentQuantity;
    }
}
