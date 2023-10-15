package learn.socket.controller;

import learn.socket.dto.ChatMessageDTO;
import learn.socket.dto.ChatMessageResponseDTO;
import learn.socket.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService messageService;

    @MessageMapping("/chat/{memberId}/{roomId}")
    public ResponseEntity<ChatMessageResponseDTO> enter(@PathVariable("memberId") Long memberId,
                                                       @PathVariable("roomId") Long roomId,
                                                       @RequestBody ChatMessageDTO message){

        Long save = messageService.save(memberId, roomId, message);

        return ResponseEntity.ok(messageService.findById(save));
    }
}
