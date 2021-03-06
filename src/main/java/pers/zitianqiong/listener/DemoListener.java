package pers.zitianqiong.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * <p>demo</p>
 *
 * @author 丛吉钰
 */
@Component
@Slf4j
@KafkaListener(groupId = "demo", topics = "topic.quick.demo")
public class DemoListener {
    /**
     * @param msgData 声明consumerID为demo，监听topicName为topic.quick.demo的Topic
     **/

    @KafkaHandler
    public void listen(String msgData) {

        log.info("demo 接收 : " + msgData);
    }
}
