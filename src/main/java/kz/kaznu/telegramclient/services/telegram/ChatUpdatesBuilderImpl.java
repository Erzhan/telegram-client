package kz.kaznu.telegramclient.services.telegram;

import kz.kaznu.telegramclient.services.telegram.handlers.ChatsHandlerImpl;
import kz.kaznu.telegramclient.services.telegram.handlers.CustomUpdatesHandler;
import kz.kaznu.telegramclient.services.telegram.handlers.MessageHandler;
import kz.kaznu.telegramclient.services.telegram.handlers.UsersHandlerImpl;
import org.springframework.stereotype.Service;
import org.telegram.bot.ChatUpdatesBuilder;
import org.telegram.bot.handlers.UpdatesHandlerBase;
import org.telegram.bot.kernel.IKernelComm;
import org.telegram.bot.kernel.database.DatabaseManager;
import org.telegram.bot.kernel.differenceparameters.IDifferenceParametersService;

/**
 * Created by yerzhan on 10/8/19.
 */
@Service
public class ChatUpdatesBuilderImpl implements ChatUpdatesBuilder {

  private IKernelComm kernelComm;
  private IDifferenceParametersService differenceParametersService;

  private final DatabaseManagerImpl databaseManager;
  private final ChatsHandlerImpl chatsHandler;
  private final UsersHandlerImpl usersHandler;
  private final MessageHandler messageHandler;

  public ChatUpdatesBuilderImpl(ChatsHandlerImpl chatsHandler,
      UsersHandlerImpl usersHandler, DatabaseManagerImpl databaseManager,
      MessageHandler messageHandler) {
    this.chatsHandler = chatsHandler;
    this.usersHandler = usersHandler;
    this.databaseManager = databaseManager;
    this.messageHandler = messageHandler;
  }


  @Override
  public UpdatesHandlerBase build() {

    if (kernelComm == null) {
      throw new NullPointerException("Can't build the handler without a KernelComm");
    }

    if (differenceParametersService == null) {
      throw new NullPointerException(
          "Can't build the handler without a differenceParamtersService");
    }

    CustomUpdatesHandler customUpdatesHandler = new CustomUpdatesHandler(kernelComm,
        differenceParametersService, databaseManager);
    customUpdatesHandler.setUsersHandler(usersHandler);
    customUpdatesHandler.setChatsHandler(chatsHandler);
    customUpdatesHandler.setMessageHandler(messageHandler);
    return customUpdatesHandler;

  }

  @Override
  public void setKernelComm(IKernelComm kernelComm) {
    this.kernelComm = kernelComm;
  }

  @Override
  public void setDifferenceParametersService(
      IDifferenceParametersService differenceParametersService) {
    this.differenceParametersService = differenceParametersService;
  }

  @Override
  public DatabaseManager getDatabaseManager() {
    return this.databaseManager;
  }
}
