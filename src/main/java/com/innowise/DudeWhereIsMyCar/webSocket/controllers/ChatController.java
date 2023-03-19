package com.innowise.DudeWhereIsMyCar.webSocket.controllers;

import com.innowise.DudeWhereIsMyCar.configs.scurity.JWTGenerator;
import com.innowise.DudeWhereIsMyCar.webSocket.dto.InputChatMessage;
import com.innowise.DudeWhereIsMyCar.webSocket.dto.OutputChatMessage;
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
    public OutputChatMessage send(InputChatMessage message) throws Exception {

        if (StringUtils.hasText(message.getFrom()) && tokenGenerator.validateToken(message.getFrom())) {
            String username = tokenGenerator.getUsernameFromJWT(message.getFrom());
            String time = new SimpleDateFormat("HH:mm").format(new Date());
            return new OutputChatMessage(username, message.getText(), time);
        }
        return null;

    }
}
