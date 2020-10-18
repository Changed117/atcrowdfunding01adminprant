package com.Changed.crowd.util;

import org.junit.Test;

public class StringTest {
    @Test
    public void test(){
        String text = "123123";
        String md5 = CrowdUitl.md5(text);
        System.out.println(md5);
    }

}
