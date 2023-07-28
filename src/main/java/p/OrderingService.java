package p;

import java.util.List;

public class OrderingService {
	OrderingDAO orderingDao;
	
	public OrderingService() {
		orderingDao = new OrderingDAO();
	}
	
	public List<Ordering> get(){
		return orderingDao.select();
	}
	
	public void add(Ordering ordering) {
		orderingDao.insert(ordering);
	}
	
	boolean hasOrderingCustomer(int customerId) {
		boolean rtn = false;
		
		if(orderingDao.selectCountByCustomerId(customerId) > 0) {
			rtn = true;
		}
		
		return rtn;
	}
	
	boolean hasOrderingBook(int bookId) {
		boolean rtn = false;
		
		if(orderingDao.selectCountByBookId(bookId) > 0) {
			rtn = true;
		}
		
		return rtn;
	}
}
