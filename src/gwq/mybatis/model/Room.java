package gwq.mybatis.model;

import java.io.Serializable;


public class Room implements Serializable{

	
	private static final long serialVersionUID = -8200818767860259357L;
	
	private int id;
	private String roomNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	

}
