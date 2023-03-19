package com.innowise.DudeWhereIsMyCar.webSocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutputChatMessage {
    private String from;
    private String text;
    private String time;
}
