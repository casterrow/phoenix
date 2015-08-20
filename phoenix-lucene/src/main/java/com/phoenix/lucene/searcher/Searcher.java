package com.phoenix.lucene.searcher;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 
 * 描述
 * @author casterrow@163.com, Stephen Lau
 * @date Aug 20, 2015
 * @version 1.0
 */
public class Searcher {

	
	private File indexDir; //索引文件目录
	private String fieldName; //索引段名称
	
	public Searcher(String indexDir, String fieldName){
		this.indexDir = new File(indexDir); 
		this.fieldName = fieldName;
	}

	
	/**
	 * 查询
	 * @author casterrow@163.com, Stephen Lau
	 * @date Aug 20, 2015
	 * @version 1.0
	 * @param keywords
	 * @throws IOException 
	 */
	public void search(String keywords) throws IOException {
		Directory fsDir = FSDirectory.open(indexDir);
        IndexReader reader = IndexReader.open(fsDir);
        IndexSearcher is = new IndexSearcher(reader);

	}

}
