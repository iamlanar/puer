package com.vskol.puer.core;

public class AssertionProviderAdapter {
    private final Class<?> assertionProvider;

    public AssertionProviderAdapter(Class<?> assertionProvider) {
        this.assertionProvider = assertionProvider;
    }

    public void assertEquals(Object expected, Object actual) {
        InvocationHandler.invoke(assertionProvider, "assertEquals", expected, actual);
    }

    public void assertTrue(boolean value) {
        InvocationHandler.invoke(assertionProvider, "assertTrue", value);
    }
}
