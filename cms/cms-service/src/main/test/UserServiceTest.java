import com.hou.cms.model.User;
import com.hou.cms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author : houlk
 * @description : 测试service
 * @date : 2017/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:applicationContext.xml",
		"classpath:applicationContext-jdbc.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void index(){
		//自定义接口调用
		//UserVO userVO = userService.selectUserWithBook(1);
		//System.out.println(userVO.getBooks().size());
		//自定义生成接口调用
		//User user = userService.getMapper().selectByPrimaryKey(1);
		//System.out.println(user.getNickname());
		User user = new User();
		user.setContent("黑");
		user.setNickname("1111");
		user.setCtime(1233L);
		user.setSex(2);
		user.setUsername("1111");
		user.setPassword("123456");
		//user.setId(2);
		this.userService.insertAutoKey(user);
	}
	
}
