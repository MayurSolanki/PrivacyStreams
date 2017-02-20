package com.github.privacystreams.core.utilities.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.privacystreams.core.Function;
import com.github.privacystreams.core.Item;
import com.github.privacystreams.core.UQI;

import static com.github.privacystreams.core.utils.Assertions.notNull;

/**
 * Created by yuanchun on 28/12/2016.
 * Project the fields in an item.
 * either include some fields or exclude some fields.
 */
class ItemProjector extends Function<Item, Item> {
    final static String OPERATOR_INCLUDE = "$include_fields";
    final static String OPERATOR_EXCLUDE = "$exclude_fields";

    private final String operator;
    private final String[] fields;

    ItemProjector(String operator, String... fields) {
        this.operator = notNull("operator", operator);
        this.fields = notNull("fields", fields);
    }

    @Override
    public Item apply(UQI uqi, Item input) {
        switch (this.operator) {
            case OPERATOR_INCLUDE:
                input.includeFields(this.fields);
                return input;
            case OPERATOR_EXCLUDE:
                input.excludeFields(this.fields);
                return input;
            default:
                throw new IllegalArgumentException("illegal operator: " + this.operator);
        }
    }

    @Override
    protected List<Object> getParameters() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(this.operator);
        parameters.add(this.fields);
        return parameters;
    }
}
