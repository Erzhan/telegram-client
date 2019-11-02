package kz.kaznu.telegramclient.models.dummy;

import kz.kaznu.telegramclient.models.TelegramUser;
import kz.kaznu.telegramclient.models.enums.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by yerzhan on 10/28/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForLogging {

  private int flags;
  private long accessHash;
  private String firstName;
  private String lastName;
  private String userName;
  private String phone;
  private int botInfoVersion;
  private String restrictionReason;
  private String botInlinePlaceholder;
  private String langCode;
  private Action action = Action.NEW_USER;

  public UserForLogging(TelegramUser telegramUser) {
    this.flags = telegramUser.getFlags();
    this.accessHash = telegramUser.getAccessHash();
    this.firstName = telegramUser.getFirstName();
    this.lastName = telegramUser.getLastName();
    this.userName = telegramUser.getUserName();
    this.phone = telegramUser.getPhone();
    this.botInfoVersion = telegramUser.getBotInfoVersion();
    this.restrictionReason = telegramUser.getRestrictionReason();
    this.botInlinePlaceholder = telegramUser.getBotInlinePlaceholder();
    this.langCode = telegramUser.getLangCode();
  }
}
