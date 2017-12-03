package bms.service;

import bms.entity.*;

public interface BookService {
	public Pager findPage(int page,int count) throws Exception;
}
