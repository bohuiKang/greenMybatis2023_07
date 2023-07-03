package aaa.model;

import lombok.Data;

@Data //롬복의 기능으로 getter,setter,toString을 자동으로 만들어준다.
public class HandPhone {
	String name = "은하수";
	int price = 80;
	public HandPhone(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public HandPhone() {	}	
}
