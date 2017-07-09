package test;

import main.entity.Sale;
import main.service.Message1ProcessorServiceImpl;
import main.service.MessageProcessorService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: MessageProcessorServiceTest
 *
 *      Used to test the methods of MessageProcessorService.
 *
 */
public class MessageProcessorServiceTest {

    @Test
    public void parseProductTypeTest1(){
        MessageProcessorService messageProcessorService = new Message1ProcessorServiceImpl();
        Assert.assertEquals("apple should give apples","apples",messageProcessorService.parseType("apple"));
    }

    @Test
    public void parseProductTypeTest2(){
        MessageProcessorService messageProcessorService = new Message1ProcessorServiceImpl();
        Assert.assertEquals("mango should give mangoes","mangoes",messageProcessorService.parseType("mango"));
    }

    @Test
    public void parsePriceTest (){
        MessageProcessorService messageProcessorService = new Message1ProcessorServiceImpl();
        Assert.assertEquals("20p should give 0.2",0.2,messageProcessorService.parsePrice("20p"));
    }

}
