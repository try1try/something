package bms.entity;

import java.util.Iterator;
import java.util.LinkedList;

public class CollectList {
	//书目集合
	private LinkedList<Book> books;
	//收藏总数
	private int totalNum;
	
	public CollectList() {
		books = new LinkedList<Book>();
		totalNum = 0;
	}
	
	
	public LinkedList<Book> getBooks() {
		return books;
	}


	public void setBooks(LinkedList<Book> books) {
		this.books = books;
	}


	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	//收藏书目
	public boolean addBooks(Book book) {
		if(books.contains(book)){
			return true;
		}
		else {
			books.add(book);
			calTotalNum();//每次添加要重新计算总数
			return true;
		}
		
	}
	//删除收藏书目
	public Boolean removeBooks(Book book) {
		books.remove(book);
		return true;
	}
	//统计收藏总件数
	public <E> double calTotalNum() {
		int sum = 0;
		//迭代器遍历
		Iterator<Book> it =  books.iterator();
		while(it.hasNext()) {
			Book b = (Book) it.next();
			sum += 1;
		} 
		this.setTotalNum(sum);
		return this.getTotalNum();
	}
	


	
}

