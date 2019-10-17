package kz.kaznu.telegramclient.models.telegram;

import org.telegram.bot.structure.Chat;

/**
 * Created by yerzhan on 10/18/19.
 */
public class ChatImpl implements Chat {

  private int id;
  private Long accessHash;
  private boolean isChannel;

  public ChatImpl(int id, Long accessHash, boolean isChannel) {
    this.id = id;
    this.accessHash = accessHash;
    this.isChannel = isChannel;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public Long getAccessHash() {
    return this.accessHash;
  }

  @Override
  public boolean isChannel() {
    return this.isChannel;
  }
}
