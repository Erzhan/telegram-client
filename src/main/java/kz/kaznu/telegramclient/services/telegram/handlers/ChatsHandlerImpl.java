package kz.kaznu.telegramclient.services.telegram.handlers;

import com.google.gson.Gson;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import kz.kaznu.telegramclient.models.TelegramChat;
import kz.kaznu.telegramclient.models.dummy.ChatForLogging;
import kz.kaznu.telegramclient.repositories.TelegramChatRepository;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.telegram.api.chat.TLAbsChat;
import org.telegram.api.chat.TLChat;
import org.telegram.api.chat.TLChatForbidden;
import org.telegram.api.chat.channel.TLChannel;
import org.telegram.api.chat.channel.TLChannelForbidden;
import org.telegram.bot.handlers.interfaces.IChatsHandler;

/**
 * Created by yerzhan on 10/9/19.
 */
@Service
public class ChatsHandlerImpl implements IChatsHandler {

  private Logger logger = java.util.logging.Logger
      .getLogger(ChatsHandlerImpl.class.getSimpleName());

  private final TelegramChatRepository telegramChatRepository;
  private static final Gson gson = new Gson();

  public ChatsHandlerImpl(TelegramChatRepository telegramChatRepository) {
    this.telegramChatRepository = telegramChatRepository;
  }

  @Override
  public void onChats(List<TLAbsChat> chats) {
    for (TLAbsChat chat : chats) {
      onChat(chat);
    }
  }

  private void onChat(TLAbsChat chat) {
    MDC.put("chat_id", String.valueOf(chat.getId()));
    final Optional<TelegramChat> telegramChat = telegramChatRepository
        .findById((long) chat.getId());

    if (chat instanceof TLChannel) {
      if (telegramChat.isPresent()) {
        telegramChat.get().update((TLChannel) chat);
        telegramChatRepository.save(telegramChat.get());
      } else {
        final TelegramChat newTelegramChat = new TelegramChat((TLChannel) chat);
        telegramChatRepository.save(newTelegramChat);
        logger.info(gson.toJson(new ChatForLogging(newTelegramChat)));
      }
    } else if (chat instanceof TLChannelForbidden) {
      TLChannelForbidden tlChannelForbidden = (TLChannelForbidden) chat;

      if (telegramChat.isPresent()) {
        telegramChat.get().setTitle(tlChannelForbidden.getTitle());
        telegramChat.get().setAccessHash(tlChannelForbidden.getAccessHash());
        telegramChatRepository.save(telegramChat.get());
      } else {
        final TelegramChat channelForbidden = new TelegramChat();
        channelForbidden.setId((long) tlChannelForbidden.getId());
        channelForbidden.setTitle(tlChannelForbidden.getTitle());
        channelForbidden.setAccessHash(tlChannelForbidden.getAccessHash());
        telegramChatRepository.save(channelForbidden);
        logger.info(gson.toJson(new ChatForLogging(channelForbidden)));
      }
    } else if (chat instanceof TLChat) {
      if (telegramChat.isPresent()) {
        telegramChat.get().update((TLChat) chat);
        telegramChatRepository.save(telegramChat.get());
      } else {
        final TelegramChat newTelegramChat = new TelegramChat((TLChat) chat);
        telegramChatRepository.save(newTelegramChat);
        logger.info(gson.toJson(new ChatForLogging(newTelegramChat)));
      }
    } else if (chat instanceof TLChatForbidden) {
      TLChatForbidden tlChatForbidden = (TLChatForbidden) chat;

      if (telegramChat.isPresent()) {
        telegramChat.get().setTitle(tlChatForbidden.getTitle());
        telegramChatRepository.save(telegramChat.get());
      } else {
        final TelegramChat channelForbidden = new TelegramChat();
        channelForbidden.setId((long) tlChatForbidden.getId());
        channelForbidden.setTitle(tlChatForbidden.getTitle());
        telegramChatRepository.save(channelForbidden);
        logger.info(gson.toJson(new ChatForLogging(channelForbidden)));
      }
    } else {
      throw new IllegalArgumentException(
          "user is not instanceof [TLChannel, TLChannelForbidden, TLChat, TLChatForbidden]");
    }
  }
}
