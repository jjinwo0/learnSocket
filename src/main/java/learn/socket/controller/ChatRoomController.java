package learn.socket.controller;

import learn.socket.dto.ChatRoomDTO;
import learn.socket.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/create")
    public ResponseEntity<Long> createChatRoom(@RequestBody ChatRoomDTO dto){

        Long save = chatRoomService.save(dto);

        return ResponseEntity.ok(save);
    }
}
