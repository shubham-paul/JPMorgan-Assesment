package main.service;

import main.common.Constant;
import main.entity.Product;
import main.entity.Sale;

/**
 * Created by shubhampaul on 7/9/2017.
 */
public class Message2ProcessorServiceImpl extends MessageProcessorService {

    @Override
    public Sale processMessage(String message){

        String[] messageArray = message.trim().split(Constant.REGEX_SPACES);
        if(messageArray.length != Constant.MESSAGE_TYPE_2_LENGTH) return null;

        String productType = parseType(messageArray[3]);
        double productPrice = parsePrice(messageArray[5]);

        Product product = new Product(productType,productPrice);
        int productQuantity = Integer.parseInt(messageArray[0]);
        Sale sale = new Sale(product,productQuantity);

        return sale;
    }

}
