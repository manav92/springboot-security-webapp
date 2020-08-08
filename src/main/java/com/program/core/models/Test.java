package com.program.core.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        System.out.println(getSubtractedDateFromCurrent(0));
    }

    public static Date getSubtractedDateFromCurrent(int numberOfDays) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime( new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DATE, -numberOfDays);
        return calendar.getTime();
    }
}
