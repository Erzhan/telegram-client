package kz.kaznu.telegramclient.services.telegram.handlers;

import java.util.List;
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

  @Override
  public void onChats(List<TLAbsChat> chats) {
    for (TLAbsChat chat : chats) {
      onChat(chat);
    }
  }

  private void onChat(TLAbsChat chat) {
    if (chat instanceof TLChannel) {
      System.out.println(((TLChannel) chat).getUsername());
    } else if (chat instanceof TLChannelForbidden) {
      System.out.println(chat.getId());
    } else if (chat instanceof TLChat) {
      System.out.println(((TLChat) chat).getTitle());
    } else if (chat instanceof TLChatForbidden) {
      System.out.println(((TLChatForbidden) chat).getTitle());
    } else {
      throw new IllegalArgumentException(
          "user is not instanceof [TLChannel, TLChat, TLChatForbidden]");
    }
  }
}
