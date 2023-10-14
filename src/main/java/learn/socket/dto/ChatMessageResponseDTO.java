package learn.socket.dto;

import learn.socket.entity.ChatMessage;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Data
public class ChatMessageResponseDTO {

    private Long id;
    private String sender;
    private String message;
    private String createdTime;
    private String updatedTime;

    @Builder
    public ChatMessageResponseDTO(ChatMessage entity) {
        this.id = entity.getId();
        this.sender = entity.getSender();
        this.message = entity.getMessage();
        this.createdTime = entity.getCreatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        this.updatedTime = entity.getUpdatedTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }

    public static ChatMessageResponseDTO from(ChatMessage entity){

        return ChatMessageResponseDTO.builder()
                .entity(entity)
                .build();
    }
}
