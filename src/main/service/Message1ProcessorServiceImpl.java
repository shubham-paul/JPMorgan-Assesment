package main.service;

import main.MessageProcessor;
import main.common.Constant;
import main.entity.Product;
import main.entity.Sale;

/**
 * Created by shubhampaul on 7/9/2017.
 */
public class Message1ProcessorServiceImpl extends MessageProcessorService {

    @Override
    public Sale processMessage(String message){

        String[] messageArray = message.trim().split(Constant.REGEX_SPACES);
        if(messageArray.length != Constant.MESSAGE_TYPE_1_LENGTH) return null;

        String productType = parseType(messageArray[0]);
        double productPrice = parsePrice(messageArray[2]);

        Product product = new Product(productType,productPrice);

        Sale sale = new Sale(product,Constant.MESSAGE_TYPE_1_QUANTITY);

        return sale;
    }


}
