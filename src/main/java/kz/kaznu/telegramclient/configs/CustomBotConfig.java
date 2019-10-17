package kz.kaznu.telegramclient.configs;

import org.telegram.bot.structure.BotConfig;

/**
 * Created by yerzhan on 10/9/19.
 */
public class CustomBotConfig extends BotConfig {

  private String phoneNumber;

  public CustomBotConfig(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  @Override
  public String getBotToken() {
    return null;
  }

  @Override
  public boolean isBot() {
    return false;
  }
}
