package gwq.mybatis.dao;


import gwq.mybatis.model.Room;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("roomDaoService")
public class RoomDao extends SqlSessionDaoSupport{

	//@Cacheable(value="cacheTest1",key="'selectRoomInfo'")
	public List<Room> selectRoom(){
		List<Room> list = this.getSqlSession().selectList("selectRoom");
		return list;
	   }	

}
