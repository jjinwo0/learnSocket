package learn.socket.repository;

import learn.socket.entity.ChatRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    Optional<ChatRoom> findByRoomName(String roomName);

    List<ChatRoom> findAllByRoomNameContaining(@Param("roomName") String roomName);

    List<ChatRoom> findAllByRoomNameContaining(@Param("roomName") String roomName, Sort sort);
}
