package main.common;

/**
 * Created by shubhampaul on 7/9/2017.
 *
 * ClassName: Utility
 *
 *      Contains all the stateless utility methods used throughout the application.
 *
 */
public class Utility {

    /**
     * Used to determine the type of the sales message passed.
     * @param message
     * @return MessageTypeNumber
     */
    public static  int parseMessage(String message){

        if (message == null || message.isEmpty()) {
            return Constant.MESSAGE_TYPE_INVALID;
        }
        String[] messageArray = message.trim().split(Constant.REGEX_SPACES);
        String firstWord = messageArray[0];
        if (firstWord.matches(Constant.REGEX_MESSAGE_TYPE_3)) {
            return Constant.MESSAGE_TYPE_3;
        } else if (firstWord.matches(Constant.REGEX_INTEGER)) {
            return Constant.MESSAGE_TYPE_2;
        } else if (messageArray.length == 3 && messageArray[1].contains(Constant.PATTERN_AT)) {
            return Constant.MESSAGE_TYPE_1;
        } else {
            return Constant.MESSAGE_TYPE_INVALID;
        }

    }

}
