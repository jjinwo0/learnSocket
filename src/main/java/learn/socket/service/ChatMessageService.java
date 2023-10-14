package learn.socket.service;

import learn.socket.dto.ChatMessageDTO;
import learn.socket.dto.ChatMessageResponseDTO;
import learn.socket.entity.ChatMessage;
import learn.socket.entity.ChatRoom;
import learn.socket.repository.ChatMessageRepository;
import learn.socket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChatMessageService {


    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    /**
     * ChatMessage 조회
     */
    @Transactional
    public ChatMessageResponseDTO findById(Long chatMessageId) {
        ChatMessage findChatMessage = this.chatMessageRepository.findById(chatMessageId).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatMessage가 존재하지 않습니다. chatMessageId = " + chatMessageId));

        return ChatMessageResponseDTO.builder()
                .entity(findChatMessage)
                .build();
    }

    /**
     * message 내용으로 ChatMessage 조회
     */
    @Transactional
    public List<ChatMessageResponseDTO> findByMessage(String message) {
        List<ChatMessage> allByMessageContaining = chatMessageRepository.findAllByMessageContaining(message);

        return allByMessageContaining.stream()
                .map(ChatMessageResponseDTO::from)
                .collect(Collectors.toList());
    }

    /**
     *  ChatMessage 생성
     */
    @Transactional
    public Long save(final Long chatRoomId, final ChatMessageDTO requestDto) {

        ChatRoom findChatMessage = this.chatRoomRepository.findById(chatRoomId).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatRoom이 존재하지 않습니다. chatRoomId = " + chatRoomId));

        requestDto.setChatRoom(findChatMessage);

        return chatMessageRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * ChatMessage 삭제
     */
    @Transactional
    public void delete(final Long chatMessageId) {

        ChatMessage findChatMessage = this.chatMessageRepository.findById(chatMessageId).orElseThrow(
                () -> new IllegalArgumentException("해당 ChatMessage가 존재하지 않습니다. chatMessageId = " + chatMessageId));

        this.chatMessageRepository.delete(findChatMessage);
    }
}
