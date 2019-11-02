package kz.kaznu.telegramclient.models.dummy;

import kz.kaznu.telegramclient.models.TelegramChat;
import kz.kaznu.telegramclient.models.enums.Action;
import kz.kaznu.telegramclient.models.enums.ChatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by yerzhan on 10/28/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatForLogging {

  private int flags;
  private long accessHash;
  private String title;
  private String username;
  private int date;
  private int version;
  private String restrictionReason;
  private int participantsCount;
  private ChatType type;
  private Action action = Action.NEW_CHAT;

  public ChatForLogging(TelegramChat telegramChat) {
    this.flags = telegramChat.getFlags();
    this.accessHash = telegramChat.getAccessHash();
    this.title = telegramChat.getTitle();
    this.username = telegramChat.getUsername();
    this.date = telegramChat.getDate();
    this.version = telegramChat.getVersion();
    this.restrictionReason = telegramChat.getRestrictionReason();
    this.participantsCount = telegramChat.getParticipantsCount();
    this.type = telegramChat.getType();
  }
}