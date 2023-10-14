package learn.socket.dto;

import learn.socket.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatRoomDTO {

    private String roomName;

    @Builder
    public ChatRoomDTO(String roomName) {
        this.roomName = roomName;
    }

    public ChatRoom toEntity(){

        return ChatRoom.builder()
                .roomName(this.roomName)
                .build();
    }
}
