package learn.socket.dto;

import learn.socket.entity.ChatRoom;
import lombok.Builder;
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

    @Builder
    public ChatRoomResponseDTO(ChatRoom entity) {
        this.id = entity.getId();
        this.roomName = entity.getRoomName();
        this.createdDate = entity.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedDate = entity.getUpdatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }

    public static ChatRoomResponseDTO from(ChatRoom entity){

        return ChatRoomResponseDTO.builder()
                .entity(entity)
                .build();
    }
}
