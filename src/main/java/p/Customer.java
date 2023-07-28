/*
CREATE TABLE customer(
		id IDENTITY,
		name VARCAHR(64),
		address VARCHAR(64),
		phone CHAR(13)
)
*/

package p;

import java.util.List;

public class Customer {
    int id;
    String name;
    String address;
    String phone;
    List<Ordering> orderings;
    
	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Ordering> getOrderings() {
		return orderings;
	}

	public void setOrderings(List<Ordering> orderings) {
		this.orderings = orderings;
	}
}

