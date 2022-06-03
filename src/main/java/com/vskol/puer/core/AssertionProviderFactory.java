package com.vskol.puer.core;

public class AssertionProviderFactory {

    private static final class ProviderHolder {
        private static Class<?> providerClass;

        static {
            String jUnit5 = "org.junit.jupiter.api.Assertions";

            try {
                providerClass = loadAssertions(jUnit5);
            } catch (ClassNotFoundException e) {
                System.out.println("Failed to initialize assertion provider");
                assert false;
            }
        }

        private static final AssertionProviderAdapter provider = new AssertionProviderAdapter(providerClass);
    }

    private static Class<?> loadAssertions(String className) throws ClassNotFoundException {
        return ProviderHolder.class.getClassLoader().loadClass(className);
    }

    public static AssertionProviderAdapter getProvider() {
        return ProviderHolder.provider;
    }
}
