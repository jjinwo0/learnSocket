package learn.socket.dto;

import learn.socket.entity.ChatRoom;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ChatRoomResponseDTO {

    private Long id;
    private String roomName;
    private String createdDate;
    private String updatedDate;

    public ChatRoomResponseDTO(ChatRoom room) {
        this.id = room.getId();
        this.roomName = room.getRoomName();
        this.createdDate = room.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = room.getUpdatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }
}
