package learn.socket.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    @OneToMany(mappedBy = "member", orphanRemoval = true, cascade = CascadeType.REMOVE)
    List<MemberChatRoom> memberChatRoomList = new ArrayList<>();
}
