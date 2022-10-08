package com.ascendcorp.eventprocessor.consumer;

import com.ascendcorp.eventprocessor.model.BaseMessage;
import com.ascendcorp.eventprocessor.model.TagMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(CustomerTagChange.class)
class CustomerTagChangeTest {

    @Autowired
    CustomerTagChange customerTagChange;

    @Test
    void processCustomerTagChangeTest() {
        BaseMessage<TagMessage> messaage = BaseMessage.<TagMessage>builder()
                .eventData(TagMessage.builder().tagName("tagName").tagValue("tagValue").build())
                .build();

        BaseMessage<TagMessage> result = customerTagChange.processCustomerTagChange().apply(messaage);
        assertEquals("SUCCESS", result.getStatus().getMessage());
    }
}