package main;

import main.common.Constant;
import main.common.Utility;
import main.entity.Adjustment;
import main.entity.Sale;
import main.service.Message1ProcessorServiceImpl;
import main.service.Message2ProcessorServiceImpl;
import main.service.Message3ProcessorServiceImpl;
import main.service.MessageProcessorService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by shubhampaul on 7/9/2017.
 */
public class MessageProcessor {

    public static int MESSAGE_COUNT;
    public static List<Sale> salesList = new ArrayList<>();
    public static Map<String,List<Sale>> productSalesMap = new HashMap<>();

    public static void main (String[] args){

        MESSAGE_COUNT = 0; //Initial value of messages

        try{

            String line;
            BufferedReader inputFile = new BufferedReader(new FileReader("input/input.txt"));
            while((line = inputFile.readLine()) != null) {
                MESSAGE_COUNT++;
                processMessage(line);
            }

        }

        catch (IOException e){
            e.printStackTrace();
        }


    }

    /**
     * Processes the message to determine the type of message
     * @param message
     */
    public static void processMessage(String message){
        Sale sale=null;
        int messageType = Utility.parseMessage(message);
        switch (messageType){
            case Constant.MESSAGE_TYPE_1:
                MessageProcessorService m1 = new Message1ProcessorServiceImpl();
                sale = m1.processMessage(message);
                break;
            case Constant.MESSAGE_TYPE_2:
                MessageProcessorService m2 = new Message2ProcessorServiceImpl();
                sale = m2.processMessage(message);
                break;
            case Constant.MESSAGE_TYPE_3:
                MessageProcessorService m3 = new Message3ProcessorServiceImpl();
                sale = m3.processMessage(message);
                break;
            default:
                System.out.println("Invalid Sales notification: "+message);
                break;

        }

        if(sale != null){
            salesList.add(sale);
            // Filters out Message of Type 1 and Type 2
            if(sale.getProduct() != null){
                String productType = sale.getProduct().getProductType();
                if(productSalesMap.containsKey(productType)){

                    List<Sale> productSalesList = productSalesMap.get(productType);
                    productSalesList.add(sale);
                    productSalesMap.put(productType,productSalesList);
                }
                else{
                    List<Sale> productSalesList = new ArrayList<>();
                    productSalesList.add(sale);
                    productSalesMap.put(sale.getProduct().getProductType(), productSalesList);

                }
            }

        }
        //For Sales Report
        if(MESSAGE_COUNT % 10 == 0){
              generateSalesReport();
        }
        //For Price Adjustment Report
        if (MESSAGE_COUNT % 50 ==0) {
            generatePriceAdjustmentReport();
        }

    }


    /**
     * Used to display the sales report after every 10 messages.
     */
    public static void generateSalesReport(){

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %30s %20s", "Product", "Quantity", "Total Value");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");

        Iterator it = productSalesMap.entrySet().iterator();
        double totalSalesValue = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
           // System.out.println(pair.getKey() + " = " + pair.getValue());

            List<Sale> productSalesList = (List<Sale>) pair.getValue();
            int quantity = 0;
            double totalValue = 0;
            for(Sale sale : productSalesList){
                quantity = quantity+sale.getQuantity();
                double productPrice = sale.getProduct().getProductPrice();
                double valueOfSale = productPrice * sale.getQuantity();
                totalValue = totalValue + valueOfSale;
            }
            totalSalesValue = totalSalesValue + totalValue;
            System.out.println();
            System.out.format("%10s %30s %20s", pair.getKey(), quantity, totalValue);

        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("%10s %50s", "Total Sales Value", totalSalesValue);
        System.out.println();

    }

    /**
     * Used to print the Price Adjustment Report for every 50 records.
     */
    public static void generatePriceAdjustmentReport(){

        try {
            System.out.println("Pausing Execution for adjustments");
            //Pause for price adjustment and before starting further processing.
            Thread.sleep(4000);
            for (Sale sale : salesList){
                Adjustment adjustment = sale.getAdjustment();
                if(adjustment != null){
                    System.out.println("Performed "+adjustment.getAdjustmentOperator()+" " + adjustment.getAdjustedPrice()+" to " + adjustment.getAdjustmentQuantity()+" "+ adjustment.getAdjustmentProduct());
                }
            }
        }
        catch (InterruptedException e){

        }

    }


}
