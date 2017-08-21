package com.sonly.trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		String path = "corpus.txt";
		Trie dict = createDict(path);

		String word1 = "我们";
		String word2 = "张松磊";
		String str = "我";
		System.out.println(word1 + ":" + dict.contains(word1));
		System.out.println(word2 + ":" + dict.contains(word2));
		System.out.println(word1 + ":" + dict.count(word1));
		dict.insert(word1);
		System.out.println(word1 + ":" + dict.count(word1));
		
		char[] suffix = dict.searchChilds(str);
		System.out.print(str + ":");
		for(int i = 0; i < suffix.length; i++)
			System.out.print(suffix[i] + " ");
		
	
		dict.remove(word1);
		System.out.println(word1 + ":" + dict.contains(word1));
		suffix = dict.searchChilds(str);
		System.out.print(str + ":");
		for(int i = 0; i < suffix.length; i++)
			System.out.print(suffix[i] + " ");
	}	
	
	private static Trie createDict(String path) throws NumberFormatException, IOException {
		File file = new File(path);
		Trie tree = new Trie();
		
		if(file.isFile() && file.exists()) {
			System.out.println("创建词典树...");
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(inputStreamReader);
			
			String line = "";
			while((line = reader.readLine()) != null) {
				line = line.trim();
				if(!line.equals("")) {
					String[] strings = line.split("\\s+");
					tree.insert(strings[0], Integer.valueOf(strings[1]));
				}
			}
			reader.close();
		}else {
			System.err.println("File:\"" + path + "\" read failed!");
		}
		
		System.out.println("词典树创建成功");
	
		return tree;
	}
}
