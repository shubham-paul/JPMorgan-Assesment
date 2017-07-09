package main.service;

import main.MessageProcessor;
import main.common.Constant;
import main.entity.Adjustment;
import main.entity.Sale;

/**
 * Created by shubhampaul on 7/9/2017.
 */
public class Message3ProcessorServiceImpl extends MessageProcessorService {
    @Override
    public Sale processMessage(String message){

        String[] messageArray = message.trim().split(Constant.REGEX_SPACES);
        if(messageArray.length != Constant.MESSAGE_TYPE_3_LENGTH) return null;

        String adjustmentOperator = messageArray[0];
        String productType = parseType(messageArray[2]);
        double adjustmentPrice = parsePrice(messageArray[1]);

        Adjustment adjustment = new Adjustment(adjustmentPrice,adjustmentOperator,productType);
        int adjustmentQuantity = processAdjustment(adjustment);
        adjustment.setAdjustmentQuantity(adjustmentQuantity);
        Sale sale = new Sale(adjustment);
        return sale;
    }

    /**
     *  Processed the price adjustment and returns the number of products for which the prices are adjusted.
     * @param adjustment
     * @return Number of products for which price is adjusted
     */
    public int processAdjustment (Adjustment adjustment){

        int adjustmentQuantity=0;
        for(Sale sale : MessageProcessor.salesList){

            if(sale.getProduct()!= null && sale.getProduct().getProductType().equals(adjustment.getAdjustmentProduct())){
                adjustmentQuantity=adjustmentQuantity+sale.getQuantity();
                double newProductPrice;
                switch (adjustment.getAdjustmentOperator()){
                    case Constant.ADJUSTMENT_OPERATOR_ADD:
                         newProductPrice = sale.getProduct().getProductPrice()+adjustment.getAdjustedPrice();
                        sale.getProduct().setProductPrice(newProductPrice);
                        break;
                    case Constant.ADJUSTMENT_OPERATOR_SUBTRACT:
                         newProductPrice = sale.getProduct().getProductPrice()-adjustment.getAdjustedPrice();
                         sale.getProduct().setProductPrice(newProductPrice);
                        break;
                    case Constant.ADJUSTMENT_OPERATOR_MULTIPLY:
                        newProductPrice = sale.getProduct().getProductPrice()*adjustment.getAdjustedPrice();
                        sale.getProduct().setProductPrice(newProductPrice);
                        break;
                    default:
                        break;

                }
            }
        }

        return adjustmentQuantity;

    }


}
