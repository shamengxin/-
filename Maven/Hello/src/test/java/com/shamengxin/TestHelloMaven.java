package com.shamengxin;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {

    @Test
    public void testAdd(){
		System.out.println("====maven junit tesstAss()====");
		HelloMaven hello = new HelloMaven();
		int res=hello.add(10,20);

		Assert.assertEquals(30,res);
    }
}
