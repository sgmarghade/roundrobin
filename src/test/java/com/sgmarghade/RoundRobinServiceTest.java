package com.sgmarghade;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by swapnil on 29/05/15.
 */
public class RoundRobinServiceTest {

    private RoundRobinService<String> service;
    @BeforeMethod
    public void setup(){
        List<String> list = new ArrayList<String>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        service = new RoundRobinService<String>(list,false);
    }

    @Test
    public void testShouldGiveRightObject(){
        assertEquals(service.getNextObject(), "String1");
        service.getNextObject();
        service.getNextObject();
        assertEquals(service.getNextObject(), "String4");
        assertEquals(service.getNextObject(), "String1");

    }
}
