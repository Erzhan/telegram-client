package kz.kaznu.telegramclient.services.telegram.handlers;

import java.util.List;
import java.util.Optional;
import kz.kaznu.telegramclient.models.TelegramUser;
import kz.kaznu.telegramclient.repositories.TelegramUserRepository;
import org.springframework.stereotype.Service;
import org.telegram.api.user.TLAbsUser;
import org.telegram.api.user.TLUser;
import org.telegram.api.user.TLUserEmpty;
import org.telegram.bot.handlers.interfaces.IUsersHandler;

/**
 * Created by yerzhan on 10/8/19.
 */
@Service
public class UsersHandlerImpl implements IUsersHandler {

  private final TelegramUserRepository telegramUserRepository;

  public UsersHandlerImpl(
      TelegramUserRepository telegramUserRepository) {
    this.telegramUserRepository = telegramUserRepository;
  }

  @Override
  public void onUsers(List<TLAbsUser> users) {
    for (TLAbsUser user : users) {
      onUser(user);
    }
  }

  private void onUser(TLAbsUser user) {
    final Optional<TelegramUser> telegramUser = telegramUserRepository
        .findById((long) user.getId());

    if (user instanceof TLUser) {
      if (telegramUser.isPresent()) {
        telegramUser.get().update((TLUser) user);
        telegramUserRepository.save(telegramUser.get());
      } else {
        telegramUserRepository.save(new TelegramUser((TLUser) user));
      }
    } else if (user instanceof TLUserEmpty) {
      if (!telegramUser.isPresent()) {
        telegramUserRepository.save(new TelegramUser((TLUserEmpty) user));
      }
    } else {
      throw new IllegalArgumentException("user is not instanceof TLUser or TLUserEmpty");
    }
  }
}
