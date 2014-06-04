package gwq.mybatis.dao;

import gwq.mybatis.model.Hotel;
import gwq.mybatis.model.Room;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("hotelDaoService")
@Transactional
public class HotelDao extends SqlSessionDaoSupport{

	//@Cacheable(value="cacheTest1")
	public List<Hotel> selectHotelByName(String name){
	List<Hotel> list = this.getSqlSession().selectList("selectHotelByName", name);
	return list;
   }	
	
	//@Cacheable(value="cacheTest1")
	public List<Hotel> selectHotelById(int id){
		List<Hotel> list = this.getSqlSession().selectList("selectHotelById", id);
		return list;
	}
	
	//@CacheEvict(value="cacheTest1",allEntries=true,beforeInvocation=true)
	public void updateHotelByID(Room room) {
		   this.getSqlSession().update("updateRoomById",room);
	}
    
	//@CacheEvict(value="cacheTest1",allEntries=true,beforeInvocation=true)
	public void insertRoom(Room room) {
		this.getSqlSession().insert("insertRoom",room);
	}

}
