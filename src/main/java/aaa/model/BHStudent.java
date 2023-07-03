package aaa.model;

import lombok.Data;

@Data
public class BHStudent {
	String name, grade;
	int [] jum;
	int tot, avg;
	public BHStudent(String name, int...jum) {
		super();
		this.name = name;
		this.jum = jum;
		tot = 0;
		for (int i = 0; i < jum.length; i++) {
			tot += jum[i];
		}
		avg = tot/jum.length;
	}
	public BHStudent() {	}
}
