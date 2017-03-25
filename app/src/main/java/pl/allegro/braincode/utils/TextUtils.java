package pl.allegro.braincode.utils;

public class TextUtils {
    public static String prettyPrintDuration(int days) {
        StringBuffer stringBuffer = new StringBuffer();
        int restDays = days;
        if (restDays > 365) {
            int years = restDays / 365;
            restDays = restDays % 365;
            stringBuffer.append(years).append(" lat, ");
        }
        if (restDays > 30) {
            int months = restDays / 30;
            restDays = restDays % 30;
            stringBuffer.append(months).append(" miesięcy, ");
        }
        if (restDays > 7) {
            int weeks = restDays / 7;
            restDays = restDays % 7;
            stringBuffer.append(weeks).append(" tygodni, ");
        }
        if (restDays > 0) {
            stringBuffer.append(restDays).append(" dni");
        }
        return stringBuffer.toString();
    }
}
