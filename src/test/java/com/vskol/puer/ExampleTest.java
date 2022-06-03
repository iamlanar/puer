package com.vskol.puer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.vskol.puer.api.singular.It.it;

public class ExampleTest {
    private static ToDo toDo;

    @BeforeAll
    static void init() {
        toDo = new ToDo();
        toDo.setId(1);
        toDo.setName("QWE");
    }

    @Test
    void testInRegularStyle() {
        Assertions.assertTrue(toDo instanceof ToDo);
        Assertions.assertEquals(1, toDo.getId());
        Assertions.assertEquals("QWE", toDo.getName());
    }

    @Test
    void testInBddStyle() {
        it(toDo)
                .should().be().a(ToDo.class)
                .and()
                .should().have(ToDo::getId, 1)
                .and()
                .should().have(ToDo::getName, "QWE");
    }
}
