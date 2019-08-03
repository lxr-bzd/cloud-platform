import com.github.wxiaoqi.security.movie.MovieBootstrap;
import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 16:14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieBootstrap.class)
public class Test {

    @Autowired
    IUserService iUserService;


    @org.junit.Test
    public void test(){

        User user = new User();

        iUserService.verifyUser(user);


    }


}
