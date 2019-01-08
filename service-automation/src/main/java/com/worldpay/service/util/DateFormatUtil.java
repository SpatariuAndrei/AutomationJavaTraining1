package com.worldpay.service.util;

import com.worldpay.service.constants.TestDataConstants;
import com.worldpay.service.entities.SharedData;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

    public static final String YYYY_MM_DD = "yyyy/MM/dd";
    private SharedData share;

    public DateFormatUtil(SharedData share) {
        this.share = share;
    }
    /**
     * Get current date in the format passed on by the property: date.format
     */
    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT, YYYY_MM_DD));
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Get current date plus the number of the days received as a parameter, in format passed on by the property: date.format
     */
    public String getCurrentDatePlusDays(int days) {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT, YYYY_MM_DD));
        Date date = new Date();
        date = DateUtils.addDays(date, days);
        return dateFormat.format(date);
    }

    /**
     * Get current date plus the number of the months received as a parameter, in format passed on by the property: date.format
     */
    public String getCurrentDatePlusMonths(int months) {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT, YYYY_MM_DD));
        Date date = new Date();
        date = DateUtils.addMonths(date, months);
        return dateFormat.format(date);
    }

    /**
     * Get current date plus the number of the years received as a parameter, in format passed on by the property: date.format
     */
    public String getCurrentDatePlusYears(int years) {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT, YYYY_MM_DD));
        Date date = new Date();
        date = DateUtils.addYears(date, years);
        return dateFormat.format(date);
    }
}
