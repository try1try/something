package bms.entity;

import java.util.Iterator;
import java.util.LinkedList;

public class CollectList {
	//��Ŀ����
	private LinkedList<Book> books;
	//�ղ�����
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
	//�ղ���Ŀ
	public boolean addBooks(Book book) {
		if(books.contains(book)){
			return true;
		}
		else {
			books.add(book);
			calTotalNum();//ÿ�����Ҫ���¼�������
			return true;
		}
		
	}
	//ɾ���ղ���Ŀ
	public Boolean removeBooks(Book book) {
		books.remove(book);
		return true;
	}
	//ͳ���ղ��ܼ���
	public <E> double calTotalNum() {
		int sum = 0;
		//����������
		Iterator<Book> it =  books.iterator();
		while(it.hasNext()) {
			Book b = (Book) it.next();
			sum += 1;
		} 
		this.setTotalNum(sum);
		return this.getTotalNum();
	}
	


	
}

