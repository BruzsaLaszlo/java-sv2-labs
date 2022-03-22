package zarovizsgapotvizsga2021.message;

import java.util.Optional;

public class MessageService {

    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public MessageService(UserRepository userRepository, MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public void registerUser(String username) {
        if (userRepository.findUserByName(username).isPresent()) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }
        userRepository.insertUser(username);
    }

    public void sendMessage(User senderUser, User receiverUser, String message) {
        Optional<User> senderId = userRepository.findUserByName(senderUser.getUsername());
        Optional<User> receiverId = userRepository.findUserByName(receiverUser.getUsername());

        if (senderId.isPresent() && receiverId.isPresent()) {
            messageRepository.saveMessage(senderId.get().getId(), receiverId.get().getId(), message);
        }
    }
}
