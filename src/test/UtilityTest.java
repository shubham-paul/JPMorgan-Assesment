package test;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: UtilityTest
 *
 *      Used to test the methods of Utility class.
 */

import main.common.Utility;
import org.junit.Assert;
import org.junit.Test;


public class UtilityTest {

    @Test
    public  void MessageType2Test(){
        Assert.assertEquals("Testing for MessageType 2",2,Utility.parseMessage("20 sales of apples at 10p each"));
    }

    @Test
    public  void MessageType1Test(){
        Assert.assertEquals("Testing for MessageType 1",1,Utility.parseMessage("apple at 10p"));
    }

    @Test
    public  void MessageType3Test(){
        Assert.assertEquals("Testing for MessageType 3",3,Utility.parseMessage("Add 20p apples"));
    }




}
