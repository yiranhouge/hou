import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class UserServiceTest {
}
