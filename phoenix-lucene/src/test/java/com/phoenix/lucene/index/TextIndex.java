package com.phoenix.lucene.index;

import java.io.File;

import org.junit.Test;

import com.phoenix.lucene.indexer.TextIndexer;
import com.phoenix.lucene.searcher.TextSearcher;

public class TextIndex {

	private File dataPath = new File("E:/lucene/data");
	private File indexPath = new File("E:/lucene/index");
	
	@Test
	public void testIndexer() throws Exception {
		TextIndexer text = new TextIndexer();
		text.index(dataPath, indexPath);
	}
	
	@Test
	public void testSearcher() throws Exception {
		TextSearcher searcher = new TextSearcher();
		searcher.search(indexPath);
	}
}
