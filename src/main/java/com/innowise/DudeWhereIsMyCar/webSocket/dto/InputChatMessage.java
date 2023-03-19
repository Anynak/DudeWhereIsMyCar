package com.innowise.DudeWhereIsMyCar.webSocket.dto;

import lombok.Data;

@Data
public class InputChatMessage {
    private String from;
    private String text;
}
