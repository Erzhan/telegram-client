package kz.kaznu.telegramclient.services.telegram;

import java.util.HashMap;
import java.util.Optional;
import kz.kaznu.telegramclient.models.TelegramChat;
import kz.kaznu.telegramclient.models.TelegramUser;
import kz.kaznu.telegramclient.models.telegram.ChatImpl;
import kz.kaznu.telegramclient.models.telegram.User;
import kz.kaznu.telegramclient.repositories.TelegramChatRepository;
import kz.kaznu.telegramclient.repositories.TelegramUserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.telegram.bot.kernel.database.DatabaseManager;
import org.telegram.bot.structure.Chat;
import org.telegram.bot.structure.IUser;

/**
 * Created by yerzhan on 10/9/19.
 */
@Service
public class DatabaseManagerImpl implements DatabaseManager {

  private final TelegramUserRepository telegramUserRepository;
  private final TelegramChatRepository telegramChatRepository;

  public DatabaseManagerImpl(
      TelegramUserRepository telegramUserRepository,
      TelegramChatRepository telegramChatRepository) {
    this.telegramUserRepository = telegramUserRepository;
    this.telegramChatRepository = telegramChatRepository;
  }

  @Override
  public @Nullable IUser getUserById(int userId) {
    final Optional<TelegramUser> telegramUser = telegramUserRepository.findById((long) userId);
    return telegramUser.map(user -> new User(user.getId().intValue(), user.getAccessHash()))
        .orElse(null);
  }

  @Override
  public @Nullable Chat getChatById(int chatId) {
    final Optional<TelegramChat> telegramChat = telegramChatRepository.findById((long) chatId);
    return telegramChat.map(user -> new ChatImpl(Math.toIntExact(telegramChat.get().getId()),
        telegramChat.get().getAccessHash(), true)).orElse(null);
  }


  @Override
  public @NotNull HashMap<Integer, int[]> getDifferencesData() {
    return new HashMap<>();
  }

  @Override
  public boolean updateDifferencesData(int botId, int pts, int date, int seq) {
    return true;
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }
}
