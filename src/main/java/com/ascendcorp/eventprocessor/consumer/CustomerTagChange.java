package com.ascendcorp.eventprocessor.consumer;

import com.ascendcorp.eventprocessor.model.BaseMessage;
import com.ascendcorp.eventprocessor.model.Status;
import com.ascendcorp.eventprocessor.model.TagMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.util.function.Function;

@Configuration
@Slf4j
public class CustomerTagChange {

    @Bean
    public Function<BaseMessage<TagMessage>, BaseMessage<TagMessage>> processCustomerTagChange() {
        return tagMessage -> {
            log.info("Received: " + tagMessage );

            tagMessage.getEventData().setDatetime(LocalDateTime.now());
            tagMessage.setStatus(Status.builder().message("SUCCESS").code("0000").build());

            return tagMessage;
        };
    }
}