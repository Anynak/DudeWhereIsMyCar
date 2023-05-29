package com.innowise.dude_where_is_my_car.web_socket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutputChatMessage {
    private String from;
    private String text;
    private String time;
}
