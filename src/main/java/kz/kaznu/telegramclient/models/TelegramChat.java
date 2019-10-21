package kz.kaznu.telegramclient.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import kz.kaznu.telegramclient.models.enums.ChatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.api.chat.TLChat;
import org.telegram.api.chat.channel.TLChannel;

/**
 * Created by yerzhan on 10/19/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telegram_chat")
public class TelegramChat {

  @Id
  @Column(name = "ID")
  private Long id;

  @Column(name = "FLAG")
  private int flags;

  @Column(name = "ACCESS_HASH")
  private long accessHash;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "DATE")
  private int date;

  @Column(name = "VERSION")
  private int version;

  @Column(name = "RESTRICTION_REASON")
  private String restrictionReason;

  @Column(name = "PARTICIPANTS_COUNT")
  private int participantsCount;

  @Enumerated(EnumType.STRING)
  @Column(name = "TYPE")
  private ChatType type;

  public TelegramChat(TLChat tlChat) {
    this.id = (long) tlChat.getId();
    this.flags = tlChat.getFlags();
    this.title = tlChat.getTitle();
    this.date = tlChat.getDate();
    this.version = tlChat.getVersion();
    this.participantsCount = tlChat.getParticipantsCount();
    this.type = ChatType.CHAT;
  }

  public TelegramChat(TLChannel tlChannel) {
    this.id = (long) tlChannel.getId();
    this.flags = tlChannel.getFlags();
    this.accessHash = tlChannel.getAccessHash();
    this.title = tlChannel.getTitle();
    this.username = tlChannel.getUsername();
    this.date = tlChannel.getDate();
    this.version = tlChannel.getVersion();
    this.restrictionReason = tlChannel.getRestrictionReason();
    this.type = ChatType.CHANNEL;
  }

  public void update(TLChat tlChat) {
    this.flags = tlChat.getFlags();
    this.title = tlChat.getTitle();
    this.date = tlChat.getDate();
    this.version = tlChat.getVersion();
    this.participantsCount = tlChat.getParticipantsCount();
    this.type = ChatType.CHAT;
  }

  public void update(TLChannel tlChannel) {
    this.flags = tlChannel.getFlags();
    this.accessHash = tlChannel.getAccessHash();
    this.title = tlChannel.getTitle();
    this.username = tlChannel.getUsername();
    this.date = tlChannel.getDate();
    this.version = tlChannel.getVersion();
    this.restrictionReason = tlChannel.getRestrictionReason();
    this.type = ChatType.CHANNEL;
  }
}
