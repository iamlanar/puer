package com.vskol.puer.api.singular;

public class It {
    public static <T> Should<T> it(T object) {
        return new Should<>(object);
    }
}
