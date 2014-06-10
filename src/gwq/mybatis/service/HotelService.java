package gwq.mybatis.service;

import gwq.mybatis.dao.HotelDao;
import gwq.mybatis.model.Hotel;
import gwq.mybatis.model.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hotelService")
public class HotelService {
	
	@Autowired
	private HotelDao hotelDao;

	public List<Hotel> selectHotelByName(String name){
		return hotelDao.selectHotelByName(name);
	 }	
		
	public List<Hotel> selectHotelById(int id){
		return hotelDao.selectHotelById(id);
	}
		
	public void updateHotelByID(Room room) {
		hotelDao.updateHotelByID(room);
	}
	    
	public void insertRoom(Room room) {
		hotelDao.insertRoom(room);
	}
}
