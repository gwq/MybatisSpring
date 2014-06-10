package gwq.mybatis.service;

import gwq.mybatis.dao.RoomDao;
import gwq.mybatis.model.Room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roomService")
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	public List<Room> selectRoom(){
		return roomDao.selectRoom();
	   }

}
