package com.doubly.linked.list;


public class MyLinkedList {

	private Node backTraceNode = null;
	private Node nodeHead = null;
	private Node firstNode = null;
	private Node lastNode = null;
	private int listCount = 0;
	
	public void add(String input) {
		Node tempNode = new Node(input);
		if (backTraceNode != null){
			backTraceNode.setNextNode(tempNode);
			tempNode.setPreviousNode(backTraceNode);
			lastNode = tempNode;
			listCount++;
		}else {
			firstNode = tempNode;
			tempNode.setPreviousNode(null);
			listCount++;
			}	
		backTraceNode = tempNode;
		
	}

	public Object print() {
		StringBuffer result = new StringBuffer();
		Node tempNode = lastNode;
		while(tempNode!=null){
			result.append(tempNode.getValue() + " ");
			tempNode = tempNode.getPreviousNode();
		}
		return result.toString();
	}

}
