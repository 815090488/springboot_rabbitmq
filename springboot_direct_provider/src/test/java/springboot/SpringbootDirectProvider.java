package springboot;


import com.springboot.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDirectProvider.class)
public class SpringbootDirectProvider {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() throws Exception {
        while (true) {
            Thread.sleep(1000);
            this.sender.send("hello");
        }
    }
}
