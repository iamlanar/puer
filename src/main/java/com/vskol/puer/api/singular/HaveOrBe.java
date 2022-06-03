package com.vskol.puer.api.singular;

import java.util.function.Function;

import static com.vskol.puer.core.AssertionProviderFactory.getProvider;

public class HaveOrBe<T> {
    private final T object;

    public HaveOrBe(T object) {
        this.object = object;
    }

    public Chainable<T> have(Function<T, ?> action, Object value) {
        getProvider().assertEquals(action.apply(object), value);
        return new And<>(object);
    }

    public Be<T> be() {
        return new Be<>(object);
    }
}
