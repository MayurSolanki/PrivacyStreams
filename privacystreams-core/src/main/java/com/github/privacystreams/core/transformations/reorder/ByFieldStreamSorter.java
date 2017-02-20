package com.github.privacystreams.core.transformations.reorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.github.privacystreams.core.Item;

/**
 * Created by yuanchun on 22/12/2016.
 * A function that sorts the items in stream by the value of a field.
 */
class ByFieldStreamSorter extends StreamReorder {
    private final String fieldToSort;

    ByFieldStreamSorter(final String fieldToSort) {
        this.fieldToSort = fieldToSort;
    }

    @Override
    protected void reorder(List<Item> items) {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                Comparable value1 = item1.getValueByField(fieldToSort);
                Comparable value2 = item2.getValueByField(fieldToSort);
                return value1.compareTo(value2);
            }
        });
    }

    @Override
    protected List<Object> getParameters() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(fieldToSort);
        return parameters;
    }
}
