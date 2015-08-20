package com.phoenix.lucene.indexer;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @date Aug 20, 2015
 * @version 1.0
 *
 */
public class Indexer {

	
	private String fieldName; //索引段名称
	private String endStr; //文件后缀名称
	
	
	public Indexer(String fieldName, String endStr){
		this.fieldName = fieldName;
		this.endStr = endStr;
	}

	
	/**
	 * 创建索引
	 * @author Stephen Lau
	 * @date Aug 20, 2015
	 * @param indexDir
	 * @param dataDir
	 * @return
	 * @throws IOException
	 */
	public int index(File indexDir, File dataDir) throws IOException {
		
		if (!dataDir.exists() || !dataDir.isDirectory()) {
			throw new IOException(dataDir + " does not exist or is not a directory");
		}
		
		//创建分析器
		Analyzer analyzer = new SmartChineseAnalyzer();
		
		//
		IndexWriterConfig indexCfg = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
		
		//Lucene中的文件操作都是通过这Directory来实现的。Directory的实现类可以分为文件目录，内存目录和目录的代理类及工具类。
		Directory directory = FSDirectory.open(indexDir);
		if (IndexWriter.isLocked(directory)) {
			throw new IOException(directory + " is locked!");
		}
		
		//创建索引器
		IndexWriter writer = new IndexWriter(directory, indexCfg);
		writer.deleteAll();
		indexDirectory(writer, dataDir);
		int numIndexed = writer.numDocs();
		writer.close();
		return numIndexed;
	}
	
	
	/**
	 * 递归查找符合条件的文件
	 * @author Stephen Lau
	 * @date Aug 20, 2015
	 * @param writer
	 * @param dir
	 * @throws IOException
	 */
	private void indexDirectory(IndexWriter writer, File dir) throws IOException {
		
	}

}
