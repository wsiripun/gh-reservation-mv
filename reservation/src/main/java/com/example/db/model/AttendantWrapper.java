package com.example.db.model;



import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="attendant111")
public class AttendantWrapper {

	private List<Attendant> wslist_123;

	public AttendantWrapper() {
	}

	public List<Attendant> getList() {
		return wslist_123;
	}

	public void setList(List<Attendant> list) {
		this.wslist_123 = list;
	}
	
	
	
	
}
