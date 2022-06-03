package com.vskol.puer.api.singular;

public interface Chainable<T> {
    Should<T> and();
}
