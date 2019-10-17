package kz.kaznu.telegramclient.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.api.user.TLUser;
import org.telegram.api.user.TLUserEmpty;

/**
 * Created by yerzhan on 10/8/19.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telegram_user")
public class TelegramUser {

  @Id
  @Column(name = "ID")
  private Long id;

  @Column(name = "FLAG")
  private int flags;

  @Column(name = "ACCESS_HASH")
  private long accessHash;

  @Column(name = "FIRST_NAME")
  private String firstName = "";

  @Column(name = "LAST_NAME")
  private String lastName = "";

  @Column(name = "USER_NAME")
  private String userName = "";

  @Column(name = "PHONE")
  private String phone = "";

  @Column(name = "BOT_INFO_VERSION")
  private int botInfoVersion;

  @Column(name = "RESTRICTION_REASON")
  private String restrictionReason;

  @Column(name = "BOT_INLINE_PLACEHOLDER")
  private String botInlinePlaceholder;

  @Column(name = "LANG_CODE")
  private String langCode;

  public TelegramUser(TLUser tlUser) {
    this.id = (long) tlUser.getId();
    this.flags = tlUser.getFlags();
    this.accessHash = tlUser.getAccessHash();
    this.firstName = tlUser.getFirstName();
    this.lastName = tlUser.getLastName();
    this.userName = tlUser.getUserName();
    this.phone = tlUser.getPhone();
    this.botInfoVersion = tlUser.getBotInfoVersion();
    this.restrictionReason = tlUser.getRestrictionReason();
    this.botInlinePlaceholder = tlUser.getBotInlinePlaceholder();
    this.langCode = tlUser.getLangCode();
  }


  public TelegramUser(TLUserEmpty tlUserEmpty) {
    this.id = (long) tlUserEmpty.getId();
  }

  public void update(TLUser tlUser) {
    this.flags = tlUser.getFlags();
    this.accessHash = tlUser.getAccessHash();
    this.firstName = tlUser.getFirstName();
    this.lastName = tlUser.getLastName();
    this.userName = tlUser.getUserName();
    this.phone = tlUser.getPhone();
    this.botInfoVersion = tlUser.getBotInfoVersion();
    this.restrictionReason = tlUser.getRestrictionReason();
    this.botInlinePlaceholder = tlUser.getBotInlinePlaceholder();
    this.langCode = tlUser.getLangCode();
  }
}
