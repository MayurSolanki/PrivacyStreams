package com.github.privacystreams.core.utilities.arithmetic;

import java.util.ArrayList;
import java.util.List;

import com.github.privacystreams.core.Item;
import com.github.privacystreams.core.UQI;
import com.github.privacystreams.core.utilities.ItemFunction;
import com.github.privacystreams.core.utils.Assertions;

/**
 * Created by yuanchun on 28/12/2016.
 * Process the number field in an item.
 */
abstract class ArithmeticFunction<Tout> extends ItemFunction<Tout> {

    private final String numField;

    ArithmeticFunction(String numField) {
        this.numField = Assertions.notNull("numField", numField);
    }

    @Override
    public final Tout apply(UQI uqi, Item input) {
        Number number = input.getValueByField(this.numField);
        return this.processNum(number);
    }

    protected abstract Tout processNum(Number number);

    @Override
    protected List<Object> getParameters() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(this.numField);
        return parameters;
    }
}
