package kz.kaznu.telegramclient.models.telegram;

import org.telegram.bot.structure.IUser;

/**
 * Created by yerzhan on 10/18/19.
 */
public class User implements IUser {

  private int userId;
  private Long userHash;

  public User(int userId, Long userHash) {
    this.userId = userId;
    this.userHash = userHash;
  }

  @Override
  public int getUserId() {
    return this.userId;
  }

  @Override
  public Long getUserHash() {
    return this.userHash;
  }
}
