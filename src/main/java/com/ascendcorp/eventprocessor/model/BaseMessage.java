package com.ascendcorp.eventprocessor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseMessage<T> {
    String version;
    String eventPublisher;
    String eventType;
    Long eventTimestamp;
    String tmnId;
    String correlationId;
    String channel;
    T eventData;
    Status status;
}
