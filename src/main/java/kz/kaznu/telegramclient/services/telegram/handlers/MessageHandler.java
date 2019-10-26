package kz.kaznu.telegramclient.services.telegram.handlers;

import java.util.List;
import java.util.Optional;
import kz.kaznu.telegramclient.models.TelegramChat;
import kz.kaznu.telegramclient.models.TelegramMessage;
import kz.kaznu.telegramclient.models.TelegramUser;
import kz.kaznu.telegramclient.repositories.TelegramChatRepository;
import kz.kaznu.telegramclient.repositories.TelegramMessageRepository;
import kz.kaznu.telegramclient.repositories.TelegramUserRepository;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.telegram.api.message.TLAbsMessage;
import org.telegram.api.message.TLMessage;
import org.telegram.api.message.TLMessageEmpty;
import org.telegram.api.message.TLMessageService;
import org.telegram.api.updates.TLUpdateShortChatMessage;

/**
 * Created by yerzhan on 10/21/19.
 */
@Service
public class MessageHandler {

  private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MessageHandler.class.getSimpleName());

  private final TelegramMessageRepository telegramMessageRepository;
  private final TelegramUserRepository telegramUserRepository;
  private final TelegramChatRepository telegramChatRepository;

  public MessageHandler(
      TelegramMessageRepository telegramMessageRepository,
      TelegramUserRepository telegramUserRepository,
      TelegramChatRepository telegramChatRepository) {
    this.telegramMessageRepository = telegramMessageRepository;
    this.telegramUserRepository = telegramUserRepository;
    this.telegramChatRepository = telegramChatRepository;
  }

  public void onMessage(TLAbsMessage message) {

    MDC.put("chat_id", String.valueOf(message.getChatId()));
    logger.info(message.toString());
    if (message instanceof TLMessage) {
      onTLMessage((TLMessage) message);
    } else if (message instanceof TLMessageEmpty) {
      onTLMessageEmpty((TLMessageEmpty) message);
    } else if (message instanceof TLMessageService) {
      onTLMessageService((TLMessageService) message);
    }
  }

  public void onMessage(TLUpdateShortChatMessage message) {

    //TODO
    MDC.put("chat_id", String.valueOf(message.getChatId()));
    logger.info(message.toString());
    List<TelegramMessage> messages = telegramMessageRepository
        .findByMessageIdAndTelegramChat(message.getId(),
                                        message.getChatId());

    if (messages.isEmpty()) {
      messages = telegramMessageRepository
          .findByMessageIdAndTelegramChat(message.getId(),
                                          message.getFromId());
    }

    if (messages.isEmpty()) {
      final TelegramMessage telegramMessage = new TelegramMessage();
      telegramMessage.setMessageId((long) message.getId());
      telegramMessage.setMessage(String.valueOf(message.getMessage()));
      telegramMessage.setTelegramChat(findTelegramChatById(message.getChatId()));
      telegramMessage.setTelegramUser(findTelegramUserById(message.getFromId()));
      telegramMessageRepository.save(telegramMessage);
    }
  }

  private void onTLMessage(TLMessage message) {
    List<TelegramMessage> messages = telegramMessageRepository
        .findByMessageIdAndTelegramChat(message.getId(), message.getChatId());

    if (messages.isEmpty()) {
      messages = telegramMessageRepository
          .findByMessageIdAndTelegramChat(message.getId(), message.getFromId());
    }

    if (messages.isEmpty()) {
      final TelegramMessage telegramMessage = new TelegramMessage();
      telegramMessage.setMessageId((long) message.getId());
      telegramMessage.setMessage(message.getMessage());
      telegramMessage.setTelegramChat(findTelegramChatById(message.getChatId()));
      telegramMessage.setTelegramUser(findTelegramUserById(message.getFromId()));
      telegramMessageRepository.save(telegramMessage);
    }
  }

  private void onTLMessageEmpty(TLMessageEmpty message) {
    final List<TelegramMessage> messages = telegramMessageRepository
        .findByMessageIdAndTelegramChat(message.getId(), message.getChatId());

    if (messages.isEmpty()) {
      final TelegramMessage telegramMessage = new TelegramMessage();
      telegramMessage.setMessageId((long) message.getId());
      telegramMessage.setTelegramChat(findTelegramChatById(message.getChatId()));
      telegramMessageRepository.save(telegramMessage);
    }
  }

  private void onTLMessageService(TLMessageService message) {
    List<TelegramMessage> messages = telegramMessageRepository
        .findByMessageIdAndTelegramChat(message.getId(), message.getChatId());

    if (messages.isEmpty()) {
      messages = telegramMessageRepository
          .findByMessageIdAndTelegramChat(message.getId(), message.getFromId());
    }

    if (messages.isEmpty()) {
      final TelegramMessage telegramMessage = new TelegramMessage();
      telegramMessage.setMessageId((long) message.getId());
      telegramMessage.setMessage(String.valueOf(message.getReplyToMessageId()));
      telegramMessage.setTelegramChat(findTelegramChatById(message.getChatId()));
      telegramMessage.setTelegramUser(findTelegramUserById(message.getFromId()));
      telegramMessageRepository.save(telegramMessage);
    }
  }

  private TelegramUser findTelegramUserById(Integer id) {
    if (id != 0) {
      final Optional<TelegramUser> telegramUser = telegramUserRepository.findById((long) id);
      return telegramUser.orElse(null);
    } else {
      return null;
    }
  }

  private TelegramChat findTelegramChatById(Integer id) {
    if (id != 0) {
      final Optional<TelegramChat> telegramChat = telegramChatRepository.findById((long) id);
      return telegramChat.orElse(null);
    } else {
      return null;
    }
  }
}
