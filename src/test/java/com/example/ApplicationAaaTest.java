package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationAaaTest {
    @Test
    void test(){
        var l = new ArrayList<>();
        l.add("a");
        l.add(1);
        l.add(new HashSet<>());

        System.out.println(l);

    }

}