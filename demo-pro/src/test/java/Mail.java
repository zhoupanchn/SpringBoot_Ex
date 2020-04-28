import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Import(value = {RestTemplateConfig.class})
public class Mail {
    @Autowired
    public static RestTemplate restTemplate;

    public static void main(String[] args) {
        String token     = "camRvhWpevZJ2dt";
        String serverUrl = "http://172.20.31.23/sys/mail";
        String origin    = "marketing";

        String title    = "测试邮件";
        String content  = "就是测试邮件";
        String userName = "fjal \n";

        Object[] param = new Object[]{token, userName, origin, title, content};


        ResponseEntity<String> resp           = null;
        String                 responseResult = null;
        resp = restTemplate.postForEntity(serverUrl, param, String.class);
        responseResult = resp.getBody();
        System.out.println(responseResult);

    }
}
