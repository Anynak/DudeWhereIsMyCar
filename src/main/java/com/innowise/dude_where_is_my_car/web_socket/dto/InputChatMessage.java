package com.innowise.dude_where_is_my_car.web_socket.dto;

import lombok.Data;

@Data
public class InputChatMessage {
    private String from;
    private String text;
}
