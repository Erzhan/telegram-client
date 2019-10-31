package kz.kaznu.telegramclient.services.telegram.handlers;

import com.google.gson.Gson;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import kz.kaznu.telegramclient.models.TelegramUser;
import kz.kaznu.telegramclient.models.dummy.UserForLogging;
import kz.kaznu.telegramclient.repositories.TelegramUserRepository;
import org.slf4j.MDC;
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

  private Logger logger = java.util.logging.Logger
      .getLogger(UsersHandlerImpl.class.getSimpleName());

  private static final Gson gson = new Gson();
  private final TelegramUserRepository telegramUserRepository;

  public UsersHandlerImpl(TelegramUserRepository telegramUserRepository) {
    this.telegramUserRepository = telegramUserRepository;
  }

  @Override
  public void onUsers(List<TLAbsUser> users) {
    for (TLAbsUser user : users) {
      onUser(user);
    }
  }

  private void onUser(TLAbsUser user) {
    MDC.put("user_id", String.valueOf(user.getId()));
    final Optional<TelegramUser> telegramUser = telegramUserRepository
        .findById((long) user.getId());

    if (user instanceof TLUser) {
      if (telegramUser.isPresent()) {
        telegramUser.get().update((TLUser) user);
        telegramUserRepository.save(telegramUser.get());
      } else {
        final TelegramUser newTelegramUser = new TelegramUser((TLUser) user);
        telegramUserRepository.save(newTelegramUser);
        logger.info(gson.toJson(new UserForLogging(newTelegramUser)));
      }
    } else if (user instanceof TLUserEmpty) {
      if (!telegramUser.isPresent()) {
        final TelegramUser newTelegramUser = new TelegramUser((TLUserEmpty) user);
        telegramUserRepository.save(newTelegramUser);
        logger.info(gson.toJson(new UserForLogging(newTelegramUser)));
      }
    } else {
      throw new IllegalArgumentException("user is not instanceof TLUser or TLUserEmpty");
    }
  }
}
