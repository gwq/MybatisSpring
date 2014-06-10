import gwq.mybatis.model.Room;
import gwq.mybatis.service.HotelService;
import gwq.mybatis.service.RoomService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class updateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("gwq/mybatis/config/applicationContext.xml");
		HotelService hd = (HotelService) context.getBean("hotelService");
		RoomService rd = (RoomService)context.getBean("roomService");
		
		List<Room> lr = rd.selectRoom();
		for(Room r : lr){
			System.out.println(r.getRoomNo());
		}
		
//		Room room = new Room();
//		room.setId(1);
//		room.setRoomNo("555555");
//		hd.updateHotelByID(room);
//		
//		List<Hotel> ll = hd.selectHotelById(2);
//        for(Hotel h : ll){
//        	System.out.println(h.getHotelName());
//        	for(Room r : h.getRoom()){
//        		System.out.println(r.getRoomNo());
//        	}
//        }
	}

}
