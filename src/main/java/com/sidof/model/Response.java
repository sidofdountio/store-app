package com.sidof.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author sidof
 * @Since 06/10/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected  String status;
    protected String reason;
    protected  String message;
    protected  String developerMessage;
    protected Map<?,?>data;
}
