package com.doubly.linked.list;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		String names2Evaluate = "wes kim justin leanne ";
		MyLinkedList list = new MyLinkedList();
		list.add("leanne");
		list.add("justin");
		list.add("kim");
		list.add("wes");
		
		Assert.assertEquals(names2Evaluate, list.print());
	}

}
