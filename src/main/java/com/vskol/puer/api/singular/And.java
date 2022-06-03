package com.vskol.puer.api.singular;

public class And<T> implements Chainable<T> {
    private final T object;

    public And(T object) {
        this.object = object;
    }

    @Override
    public Should<T> and() {
        return new Should<>(object);
    }
}
