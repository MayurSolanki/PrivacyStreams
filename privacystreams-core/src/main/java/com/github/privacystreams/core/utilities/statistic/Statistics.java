package com.github.privacystreams.core.utilities.statistic;

import java.util.List;

import com.github.privacystreams.core.Function;
import com.github.privacystreams.core.Item;

/**
 * Created by yuanchun on 29/12/2016.
 * A helper class to access statistic-related functions
 */

public class Statistics {
    /**
     * A function that counts the items in the stream and returns the count.
     * @return the function.
     */
    public static Function<List<Item>, Integer> count() {
        return new StreamCounter();
    }

    /**
     * A function that calculate the range of the values of a field in the stream.
     * The field values must be in Number type, such as Integer, Double, Long, ...
     * If calculation fails (e.g. there is no item in the stream), the "range" result will be null
     * @param field the name of the field to calculate range, the field value must be a number.
     * @return the function
     */
    public static Function<List<Item>, Double> range(String field) {
        return new FieldRangeStatistic(field);
    }

    /**
     * A function that calculate the sum of the values of a field in the stream.
     * The field values must be in Number type, such as Integer, Double, Long, ...
     * If there is no valid field value in the stream, the "sum" result will be 0.0
     * @param field the name of the field to calculate sum, the field value must be a number.
     * @return the function
     */
    public static Function<List<Item>, Double> sum(String field) {
        return new FieldSumStatistic(field);
    }

    /**
     * A function that calculate the average of the values of a field in the stream.
     * The field values must be in Number type, such as Integer, Double, Long, ...
     * If calculation fails (e.g. there is no item in the stream), the "average" result will be null
     * @param field the name of the field to calculate average, the field value must be a number.
     * @return the function
     */
    public static Function<List<Item>, Double> average(String field) {
        return new FieldAverageStatistic(field);
    }
}
