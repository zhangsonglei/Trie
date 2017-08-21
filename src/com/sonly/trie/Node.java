package com.sonly.trie;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	char ch;
	
	boolean isEnd;
	
	List<Node> childs;
	
	int count;
	
	public Node(char ch) {
		super();
		this.ch = ch;
		this.childs = new LinkedList<Node>();
	}
	
	public Node() {
		super();
		this.childs = new LinkedList<Node>();
	}
	
	public Node find(char ch) {
		 for(Node node : childs)
             if(node.ch == ch)
                 return node;
     
         return null;
	}
	
	public String toString() {
		return String.valueOf(ch);
	}
}
