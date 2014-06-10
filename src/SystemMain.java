import gwq.mybatis.aciton.TestAction;
import gwq.mybatis.dao.HotelDao;
import gwq.mybatis.model.Room;
import gwq.mybatis.service.HotelService;
import gwq.mybatis.service.RoomService;

import java.util.List;
import java.util.Scanner;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SystemMain {


	private HotelService hotelService;

	private RoomService roomService;

    public SystemMain(){
    	ApplicationContext context = new ClassPathXmlApplicationContext("gwq/mybatis/config/applicationContext.xml");
		hotelService = (HotelService) context.getBean("hotelService");
		roomService = (RoomService)context.getBean("roomService");
		//TestAction testAction = (TestAction)context.getBean("testAction");
    }
	
    public void begin(){
    	int typeNum;
    	while(true){
    	System.out.println("input TypeNum:");
    	Scanner sc = new Scanner(System.in);
    	typeNum = sc.nextInt();
    	switch(typeNum){
    	case 1:selectRoomInfo();break;
    	case 2:updateRoomInfo();break;
    	case 3:CacheNames();break;
    	case 4:insertRoomInfo();break;
    	case 5:testEhCache();break;
    	}
    	
    	}
    }
    
    private void testEhCache(){
    	
    	Room room = new Room();
		room.setRoomNo("999000");
    	
    	CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = cacheManager.getCache("cacheTest1");
		//如果想存入缓存，必须将Room类实现Serializable接口
    	Element element = new Element("eee",room);
		cache.put(element);
		Element e = cache.get("eee");
		Room r = (Room)e.getValue();
		System.out.println(r.getRoomNo());
		
		cache.remove("eee");
		
    }
   
	private void insertRoomInfo() {
		System.out.println("input roomNo:");
		Scanner sc = new Scanner(System.in);
		String numstr = sc.nextLine();
		Room room = new Room();

		room.setRoomNo(numstr);
		
		hotelService.insertRoom(room);
		System.out.println(room.getId());
		/**
		 * 注解方式或代码方式更新缓存(注解在updateHotelByID(room)方法上)
		 */
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = cacheManager.getCache("roomNameSpace");
		cache.removeAll();
		
		
	}

	private void updateRoomInfo() {
		System.out.println("input roomNo:");
		Scanner sc = new Scanner(System.in);
		String numstr = sc.nextLine();
		Room room = new Room();
		room.setId(1);
		room.setRoomNo(numstr);
		
		hotelService.updateHotelByID(room);
		/**
		 * 注解方式或代码方式更新缓存(注解在updateHotelByID(room)方法上)
		 */
		CacheManager cacheManager = CacheManager.getInstance();
		Cache cache = cacheManager.getCache("roomNameSpace");
		cache.removeAll();
		
	}

	private void selectRoomInfo() {
		List<Room> lr = roomService.selectRoom();
		/**
		 * 注解方式或代码方式更新缓存(注解在selectRoom()方法上)
		 */
		for(Room r : lr){
			System.out.println(r.getRoomNo());
		}
	}
	
	private void CacheNames(){
		for(String cn : CacheManager.getInstance().getCacheNames()){
			System.out.println(cn);
		}
	}

	public static void main(String[] args) {
		new SystemMain().begin();

	}

}
