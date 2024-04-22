package com.sunrise.sunriseapp.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage<T> {
    @JsonProperty(value = "reason")
    T body;
    @JsonProperty(value = "time of error")
    LocalDateTime localTime;
}
