import gwq.mybatis.dao.HotelDao;
import gwq.mybatis.model.Hotel;
import gwq.mybatis.model.Room;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Spring和Mybatis/Hibernate整合时，可能会会报org/objectweb/asm/Type异常
 * 原因是Spring中的cglib-nodep-2.x.x.jar与Hibernate中的cglib-2.2.jar相冲突! 
 * 两种框架整合时Spring中的cglib-nodep-2.x.x.jar是必须的,
 * 取消Mybatis/Hibernate中的cglib-2.2.jar即可
 * 
 * 
 * 要使延迟加载生效必须配置下面两个属性：
    <settings>
        <setting name="lazyLoadingEnabled" value="true"/>
        <setting name="aggressiveLazyLoading" value="false"/>
    </settings>
          如果你只配了lazyLoadingEnabled属性，那就不行了。
 * @author Administrator
 *
 */
public class test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("gwq/mybatis/config/applicationContext.xml");
		HotelDao hd = (HotelDao) context.getBean("hotelDaoService");
		while(true){
			Thread.sleep(1000);
			
		List<Hotel> hl = hd.selectHotelByName("MBA");
        for(Hotel h : hl){
        	System.out.println(h.getHotelName());
        }

        List<Hotel> ll = hd.selectHotelById(2);
        for(Hotel h : ll){
        	System.out.println(h.getHotelName());
        	for(Room r : h.getRoom()){
        		System.out.println(r.getRoomNo());
        	}
        }
        

	}
	}
}
