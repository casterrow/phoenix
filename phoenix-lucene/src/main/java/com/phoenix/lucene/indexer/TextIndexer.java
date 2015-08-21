package com.phoenix.lucene.indexer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @date Aug 21, 2015
 * @version 1.0
 *
 */
public class TextIndexer {

	
	/**
	 * 创建索引
	 * @author casterrow@163.com, Stephen Lau
	 * @date Aug 21, 2015
	 * @param dataPath 索引文件目录
	 * @param indexPath 存储索引的目录
	 * @throws IOException
	 */
	public void index(File dataPath, File indexPath) throws IOException {
		
		//创建目录，创建在磁盘上，存储索引文件
		Directory directory = null;
		IndexWriter writer = null;
		try {
			directory = FSDirectory.open(indexPath);
			
			//分析器
			Analyzer analyzer = new StandardAnalyzer();
			
			//IndexWriterConfig
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
			
			//IndexWriter
			writer = new IndexWriter(directory, conf);
			
			File[] files = dataPath.listFiles();
			
			for (File file : files) {
				//构造文档信息
				Document doc = new Document();
				doc.add(new StringField("filename", file.getName(), Store.YES));
				doc.add(new StringField("filepath", file.getPath(), Store.YES));
				doc.add(new TextField("content", new FileReader(file)));
				writer.addDocument(doc);  //将文档添加到索引中
			}
		} finally {
			IOUtils.closeQuietly(writer); //关闭IndexWriter
		}
	}
	
	
}
