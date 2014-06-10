package gwq.mybatis.aciton;

import gwq.mybatis.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("testAction")
public class TestAction {
   
	@Autowired
	private RoomService roomService;
}
