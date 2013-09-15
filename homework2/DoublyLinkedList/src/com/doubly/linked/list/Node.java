package com.doubly.linked.list;

public class Node {
	
	private String value = "";
	private Node nextNodePointer = null;
	private Node previousNodePointer = null;
	
	public Node(String input) {
		this.value = input;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNextNode() {
		return nextNodePointer;
	}
	public void setNextNode(Node nextNode) {
		this.nextNodePointer = nextNode;
	}
	public Node getPreviousNode() {
		return previousNodePointer;
	}
	public void setPreviousNode(Node previousNode) {
		this.previousNodePointer = previousNode;
	}
	

}
