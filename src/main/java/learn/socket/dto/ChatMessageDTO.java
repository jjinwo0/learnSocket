package learn.socket.dto;

import learn.socket.entity.ChatMessage;
import learn.socket.entity.ChatRoom;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageDTO {

    private String sender;
    private String message;
    private ChatRoom chatRoom;

    @Builder
    public ChatMessageDTO(String sender, String message, ChatRoom chatRoom) {
        this.sender = sender;
        this.message = message;
        this.chatRoom = chatRoom;
    }

    public ChatMessage toEntity(){

        return ChatMessage.builder()
                .sender(this.sender)
                .message(this.message)
                .chatRoom(this.chatRoom)
                .build();
    }
}
