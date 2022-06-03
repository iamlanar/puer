package com.vskol.puer.api.singular;

public class Should<T> {
    private final T object;

    public Should(T object) {
        this.object = object;
    }

    public HaveOrBe<T> should() {
        return new HaveOrBe<>(object);
    }
}
