package com.example.server;
 
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

// THE OUTPUT:
// 	<itemABC>			<-- XML ROOT ELEMENT
//		<description123>computer222</description123>	<-- XML ELEMENT
//		<price234>2500</price234>						<-- XML ELEMENT
//	</itemABC>
 
@XmlRootElement(name="itemABC")		// ROOT ELEMENT
public class Item {
	String desc;	
	int	price;
	
	public Item() {
		
	}
	public Item(String desc, int price) {
		this.desc = desc;
		this.price = price;
	}
	
	public String getDesc() {
		return desc;
	}
	@XmlElement(name="description123")
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getPrice() {
		return price;
	}
	@XmlElement(name="price234")
	public void setPrice(int price) {
		this.price = price;
	}
	
	
 

}