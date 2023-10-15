package learn.socket.repository;

import learn.socket.entity.MemberChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberChatRoomRepository extends JpaRepository<MemberChatRoom, Long> {
}
