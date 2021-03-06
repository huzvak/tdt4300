package com.ntnu.tdt4215.document;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;

public class NLHChapter implements IndexableDocument {
	// The Lucene document that is created.
	protected Document document;
	
	public NLHChapter() {
		document = new Document();
	}
	
	public NLHChapter(String chapterId, String title, String content) {
		document = new Document();
		setId(chapterId);
		setTitle(title);
		setContent(content);
	}

	protected void setId(String chapterId) {
		FieldType ft = new FieldType();
		ft.setIndexed(false);
		ft.setStored(true);
		ft.setTokenized(false);
		document.add(new Field("id", chapterId, ft));
	}
	
	protected void setTitle(String title) {
		FieldType ft = new FieldType();
		ft.setStored(true);
		ft.setTokenized(true);
		ft.setIndexed(true);
		document.add(new Field("title", title, ft));
	}
	
	protected void setContent(String content) {
		FieldType ft = new FieldType();
		ft.setStored(false);
		ft.setTokenized(true);
		ft.setIndexed(true);
		document.add(new Field("content", content, ft));
	}
	
	public Document getDocument() {
		return document;
	}
}
