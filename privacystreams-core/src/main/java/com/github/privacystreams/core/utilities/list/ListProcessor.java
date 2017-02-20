package com.github.privacystreams.core.utilities.list;

import java.util.ArrayList;
import java.util.List;

import com.github.privacystreams.core.UQI;
import com.github.privacystreams.core.utilities.ItemFunction;
import com.github.privacystreams.core.utils.Assertions;
import com.github.privacystreams.core.Item;

/**
 * Created by yuanchun on 28/12/2016.
 * Process the list field in an item.
 */
abstract class ListProcessor<Tout> extends ItemFunction<Tout> {

    private final String listField;

    ListProcessor(String listField) {
        this.listField = Assertions.notNull("listField", listField);
    }

    @Override
    public final Tout apply(UQI uqi, Item input) {
        List<Object> list = input.getValueByField(this.listField);
        return this.processList(list);
    }

    protected abstract Tout processList(List<Object> list);

    @Override
    protected List<Object> getParameters() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(this.listField);
        return parameters;
    }
}
