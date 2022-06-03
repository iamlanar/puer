package com.vskol.puer.api.singular;

import static com.vskol.puer.core.AssertionProviderFactory.getProvider;

public class Be<T> {
    private final T object;

    public Be(T object) {
        this.object = object;
    }

    public Chainable<T> a(Class<?> clazz) {
        getProvider().assertTrue(clazz.isInstance(object));
        return new And<>(object);
    }
}
