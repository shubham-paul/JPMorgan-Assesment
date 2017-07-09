package main.service;

import main.entity.Sale;

/**
 * Created by shubhampaul on 7/9/2017.
 */
public abstract class MessageProcessorService {

    /**
     * Used to process different messages passed to the Sales Application.
     * @param message
     * @return
     */
    public abstract Sale processMessage(String message);

    /**
     * Converts the singular products to plural
     * @param productTypeRaw
     * @return productType
     */
    public String parseType(String productTypeRaw) {
        String processedProductType = "";
        String truncatedWord = productTypeRaw.substring(0, productTypeRaw.length() - 1);
        if (productTypeRaw.endsWith("o")) {
            processedProductType = String.format("%soes", truncatedWord);
        } else if (productTypeRaw.endsWith("y")) {
            processedProductType = String.format("%sies", truncatedWord);
        } else if (productTypeRaw.endsWith("h")) {
            processedProductType = String.format("%shes", truncatedWord);
        } else if (!productTypeRaw.endsWith("s")) {
            processedProductType = String.format("%ss", productTypeRaw);
        } else {
            processedProductType = String.format("%s", productTypeRaw);
        }
        return processedProductType.toLowerCase();
    }

    /**
     * Gets the double value of the price string.
     * @param rawPrice
     * @return price
     */
    public double parsePrice(String rawPrice) {
        double price = Double.parseDouble(rawPrice.replaceAll("£|p", ""));
        if (!rawPrice.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }

}
