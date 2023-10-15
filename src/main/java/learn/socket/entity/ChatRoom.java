package learn.socket.entity;

import learn.socket.dto.ChatRoomDTO;
import learn.socket.util.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoom extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;
    private String roomName;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<MemberChatRoom> memberChatRoomList = new ArrayList<>();

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE)
    private List<ChatMessage> chatMessages = new ArrayList<>();

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }

    public Long update(ChatRoomDTO dto) {
        this.roomName = dto.getRoomName();
        return this.id;
    }
}
