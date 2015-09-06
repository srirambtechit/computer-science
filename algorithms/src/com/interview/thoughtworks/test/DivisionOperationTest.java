package com.interview.thoughtworks.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.interview.thoughtworks.DivisionOperation;

public class DivisionOperationTest {

    DivisionOperation op;

    @Before
    public void setUp() {
	op = new DivisionOperation();
    }

    @Test
    public void testDiv() {
	assertEquals("8 / 9 = ?", 0, op.div(8, 9));
	assertEquals("8 / 1 = ?", 8, op.div(8, 1));
	assertEquals("8 / 2 = ?", 4, op.div(8, 2));
	assertEquals("8 / 3 = ?", 2, op.div(8, 3));
	assertEquals("8 / 4 = ?", 2, op.div(8, 4));
	assertEquals("8 / 8 = ?", 1, op.div(8, 8));
    }

    @Test(expected = Throwable.class)
    public void testDiv_exception() {
	op.div(8, 0);
    }

    @Test
    public void testDiv_sign() {
	assertEquals("-8 / 4 = ?", -2, op.div(-8, 4));
	assertEquals("8 / -4 = ?", -2, op.div(8, -4));
	assertEquals("-8 / -4 = ?", 2, op.div(-8, -4));
	assertEquals("8 / 4 = ?", 2, op.div(8, 4));
    }
}
