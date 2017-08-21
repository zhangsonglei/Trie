package com.sonly.trie;

import java.util.List;

public class Trie {
	
	Node root = new Node();
	
	/**
	 * 向词典树中插入一个词
	 * @param word	待插入的词
	 */
	public void insert(String word) {
		Node current = root;
		char[] chs = word.toCharArray();
		for(char ch : chs) {
			Node node = current.find(ch);
			if(node != null)
				current = node;
			else {
				Node n = new Node(ch);
				current.childs.add(n);
				current = n;
			}
		}
		current.isEnd = true;
		current.count++;
	}

	/**
	 * 向词典树中插入一个词
	 * @param word	待插入的词
	 */
	public void insert(String word, int count) {
		Node current = root;
		char[] chs = word.toCharArray();
		for(char ch : chs) {
			Node node = current.find(ch);
			if(node != null)
				current = node;
			else {
				Node n = new Node(ch);
				current.childs.add(n);
				current = n;
			}
		}
		current.isEnd = true;
		current.count += count;
	}
	
	/**
	 * /**
	 * 从词典树中删除一个词
	 * @param word	待删除的词
	 * @return 删除成功->true, 不存在或者删除失败->false
	 */
	public boolean remove(String word) {
		if(this.contains(word)) {
			Node current = root;
			char[] chs = word.toCharArray();
			for(int i = 0; i < chs.length; i++) {
				Node node = current.find(chs[i]);
				current = node;
			}
			
			current.isEnd = false;
			current.count = 0;
			
			if(this.contains(word))
				return false;
			else
				return true;
		}
		
		return false;
	}
	
	/**
	 * 词典是否包含给定词
	 * @param words	待查询的词
	 * @return	包含->true/不包含->false
	 */
	public boolean contains(String word) {
		Node current = root;
		char[] chs = word.toCharArray();
		for(char ch : chs) {
			Node node = current.find(ch);
			if(node == null)
				return false;
			else
				current = node;
		}
		
		if(current.isEnd)
			return true;
		
		return false;
	}
	
	/**
	 * 返回给定词的数量
	 * @param word	待求数量的词
	 * @return		给定词的数量
	 */
	public int count(String word) {		
		Node current = root;
		char[] chs = word.toCharArray();
		for(char ch : chs) {
			Node node = current.find(ch);
			if(node == null)
				return 0;	
			else
				current = node;
		}
		
		return current.count;
	}
	
	/**
	 * 返回给定词的所有后缀
	 * @param word
	 * @return
	 */
	public char[] searchChilds(String word) {
		Node current = root;
		char[] chs = word.toCharArray();
		for(char ch : chs) {
			Node node = current.find(ch);
			if(node == null)
				return null;
			else
				current = node;
		}
		
		List<Node> childs = current.childs;
		char[] suffix = null;
		
		if(childs.size() > 0) {
			int i = 0;
			suffix = new char[childs.size()];
			for(Node node : childs)
				suffix[i++] = node.ch;
		}
		return suffix;
	}
}
