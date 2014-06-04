package gwq.mybatis.model;

import java.io.Serializable;
import java.util.List;

public class Hotel  implements Serializable{

	
	private static final long serialVersionUID = 4356014949714983559L;
	
	private int id;
	private String hotelName;
	private String address;
	private List<Room> room;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	

}
