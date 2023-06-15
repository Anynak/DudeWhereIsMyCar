package com.innowise.dude_where_is_my_car.web_socket;

import com.innowise.dude_where_is_my_car.configs.scurity.JWTGenerator;
import com.innowise.dude_where_is_my_car.web_socket.dto.InputChatMessage;
import com.innowise.dude_where_is_my_car.web_socket.dto.OutputChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@Controller
@RequiredArgsConstructor
public class ChatController {
    private final JWTGenerator tokenGenerator;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputChatMessage send(InputChatMessage message) {

        if (StringUtils.hasText(message.getFrom()) && tokenGenerator.validateToken(message.getFrom())) {
            String username = tokenGenerator.getUsernameFromJWT(message.getFrom());
            String time = new SimpleDateFormat("HH:mm").format(new Date());
            return new OutputChatMessage(username, message.getText(), time);
        }
        return null;

    }
}
