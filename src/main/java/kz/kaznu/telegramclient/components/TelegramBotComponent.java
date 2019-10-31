package kz.kaznu.telegramclient.components;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import kz.kaznu.telegramclient.configs.CustomBotConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.bot.ChatUpdatesBuilder;
import org.telegram.bot.kernel.TelegramBot;
import org.telegram.bot.structure.BotConfig;
import org.telegram.bot.structure.LoginStatus;

/**
 * Created by yerzhan on 10/17/19.
 */
@Component
public class TelegramBotComponent {

  @Value("${telegram.phone.number}")
  private String phoneNumber;

  @Value("${telegram.api.key}")
  private Integer apiKey;

  @Value("${telegram.api.hash}")
  private String apiHash;

  private final ChatUpdatesBuilder chatUpdatesBuilder;

  private Logger logger = java.util.logging.Logger
      .getLogger(TelegramBotComponent.class.getSimpleName());

  public TelegramBotComponent(ChatUpdatesBuilder chatUpdatesBuilder) {
    this.chatUpdatesBuilder = chatUpdatesBuilder;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void start() {
    final BotConfig botConfig = new CustomBotConfig(phoneNumber);
    botConfig.setAuthfile("auth");
    try {
      final TelegramBot kernel = new TelegramBot(botConfig, chatUpdatesBuilder, apiKey, apiHash);
      LoginStatus status = kernel.init();

      logger.info("Status after init = " + status.name());

      /*if (status == LoginStatus.CODESENT) {
        Scanner in = new Scanner(System.in);
        boolean success = kernel.getKernelAuth().setAuthCode(in.nextLine().trim());
        if (success) {
          status = LoginStatus.ALREADYLOGGED;
        }
      }*/

      if (status == LoginStatus.ALREADYLOGGED) {
        kernel.startBot();
        logger.info("Bot started");
      } else {
        logger.info("Failed to log in: " + status);
      }
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
      logger.severe(e.getMessage());
    }
  }
}
