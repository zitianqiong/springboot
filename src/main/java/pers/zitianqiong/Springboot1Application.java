package pers.zitianqiong;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author zitianqiong
 */
@SpringBootApplication
@EnableCaching
@Slf4j
public class Springboot1Application {

    /**
     * @param args .
     * @throws UnknownHostException UnknownHostException
     **/
    public static void main(String[] args) throws UnknownHostException, InterruptedException {
        ConfigurableApplicationContext application = SpringApplication.run(Springboot1Application.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = "";

        log.info("\n----------------------------------------------------------\n\t"
                + "系统应用正在运行! 请访问URLs:\n\t"
                + "Local: \t\thttp://localhost:" + port + path + "/\n\t"
                + "External: \thttp://" + ip + ":" + port + path + "/\n\t"
                + "----------------------------------------------------------");
        new CountDownLatch(1).await();
    }

}
