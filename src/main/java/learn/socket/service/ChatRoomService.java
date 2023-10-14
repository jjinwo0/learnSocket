package learn.socket.service;

import learn.socket.dto.ChatRoomDTO;
import learn.socket.dto.ChatRoomResponseDTO;
import learn.socket.entity.ChatRoom;
import learn.socket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;



    /** ChatRoom 생성 */
    @Transactional
    public Long save(final ChatRoomDTO requestDto) {

        return this.chatRoomRepository.save(requestDto.toEntity()).getId();
    }

    /** ChatRoom 수정 */
    @Transactional
    public Long update(final Long id, ChatRoomDTO requestDto) {

        ChatRoom findChatRoom = this.chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. id = " + id));

        return findChatRoom.update(requestDto);
    }

    /** ChatRoom 삭제 */
    @Transactional
    public void delete(final Long id) {

        ChatRoom findChatRoom = this.chatRoomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. id = " + id));

        this.chatRoomRepository.delete(findChatRoom);
    }

    /**
     * id 조회
     */
    public ChatRoomResponseDTO findById(Long id){

        ChatRoom findChatRoom = chatRoomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return ChatRoomResponseDTO.builder()
                .entity(findChatRoom)
                .build();
    }

    /**
     * roomName 조회
     */
    public ChatRoomResponseDTO findByRoomName(String roomName){

        ChatRoom findChatRoom = chatRoomRepository.findByRoomName(roomName)
                .orElseThrow(() -> new EntityNotFoundException());

        return ChatRoomResponseDTO.builder()
                .entity(findChatRoom)
                .build();
    }

    /**
     * roomName 포함 조회
     */
    public List<ChatRoomResponseDTO> findByRoomNameContaining(String roomName){

        List<ChatRoom> findAllChatRoom = chatRoomRepository.findAllByRoomNameContaining(roomName);

        return findAllChatRoom.stream()
                .map(ChatRoomResponseDTO::from)
                .collect(Collectors.toList());
    }
}
