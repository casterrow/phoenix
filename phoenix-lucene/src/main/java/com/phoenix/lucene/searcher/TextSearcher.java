package com.phoenix.lucene.searcher;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @date Aug 21, 2015
 * @version 1.0
 *
 */
public class TextSearcher {

	/**
	 * 搜索功能
	 * @author casterrow@163.com, Stephen Lau
	 * @date Aug 21, 2015
	 * @param indexPath 索引文件
	 * @throws IOException
	 * @throws ParseException 
	 */
	public void search(File indexPath) throws IOException, ParseException {
		
		Directory directory = null;
		IndexReader reader = null;
		try {
			directory = FSDirectory.open(indexPath);
			reader = DirectoryReader.open(directory);
			
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser parser = new QueryParser("content", analyzer);
			
			//搜索域中包含apache
			Query query = parser.parse("apache");
			
			
			//根据IndexSearcher搜索并返回结果，返回TopDocs，返回top前2个
			TopDocs tdocs = searcher.search(query, 2);
			
			ScoreDoc[] sdocs = tdocs.scoreDocs;
			for (ScoreDoc sdoc : sdocs) {
				
				//获取document对象
				Document doc = searcher.doc(sdoc.doc);
				System.out.println(doc.get("filename") + "||" + doc.get("filepath"));
			}
		} finally {
			IOUtils.closeQuietly(reader); //关闭IndexReader
		}
	}
	
}
