package com.vskol.puer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class InvocationHandler {
    private InvocationHandler() {
    }

    public static void invoke(Class<?> assertionProvider, String method, Object... args) {
        try {
            Method assertionMethod = assertionProvider.getMethod(method, getTypes(args));
            assertionMethod.invoke(null, args);
        } catch (InvocationTargetException ite) {
            throw new java.lang.AssertionError(ite.getCause());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            assert false;
        }
    }

    private static Class<?>[] getTypes(Object[] args) {
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            Class<?> clazz = args[i].getClass();
            if (clazz.isAssignableFrom(Boolean.class)) {
                types[i] = boolean.class;
            } else if (!isPrimitiveWrapper(clazz)) {
                types[i] = Object.class;
            } else {
                types[i] = clazz;
            }
        }
        return types;
    }

    private static boolean isPrimitiveWrapper(Class<?> clazz) {
        return clazz.isAssignableFrom(Short.class)
            || clazz.isAssignableFrom(Byte.class)
            || clazz.isAssignableFrom(Integer.class)
            || clazz.isAssignableFrom(Long.class)
            || clazz.isAssignableFrom(Float.class)
            || clazz.isAssignableFrom(Double.class)
            || clazz.isAssignableFrom(Character.class);
    }
}
