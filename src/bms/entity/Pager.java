package bms.entity;

import java.io.Serializable;
import java.util.List;

public class Pager {
	private int currentPage;//��ǰҳ
    private int totalPage;//��ҳ��
    private int count;//һҳ����������
    private List<Book> books;//��ǰҳ��ͼ������
    private int totalCount;//����������
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
    
}
