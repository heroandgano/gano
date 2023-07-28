package p;

import java.util.List;

public class BookService {
	BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}
	
	public List<Book> get(){
		return bookDao.select();
	}
	
	
	public Book getOrBlank(int id) {
		Book rtn = null;

		rtn = bookDao.selectById(id);

		if (rtn == null) {
			rtn = new Book();
			rtn.setId(-1);
			rtn.setTitle("");
			rtn.setPublisher("");
			rtn.setPrice(0);
		}

		return rtn;
	}
	
	public void add(Book book) {
		bookDao.insert(book);
	}
	
	public void set(Book book) {
		bookDao.update(book);
	}
	
	public void remove(int id) {
		bookDao.delete(id);
	}
}
