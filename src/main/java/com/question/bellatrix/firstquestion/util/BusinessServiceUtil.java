package com.question.bellatrix.firstquestion.util;

/**
 * Created on 27/01/2018.
 *
 * @author Hans H. Bravo
 */
public class BusinessServiceUtil {

    public static String getMessageWithLevel(final Integer level) {
        String message = null;
        switch (level) {
            case 1:
                message = "message";
            case 2:
                message ="warning";
            case 3:
                message ="error";
        }
        return message;
    }

}
