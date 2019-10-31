package kz.kaznu.telegramclient.models.dummy;

import java.util.Date;
import kz.kaznu.telegramclient.models.TelegramMessage;
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
public class MessageForLogging {

  private ChatForLogging chatForLogging;
  private UserForLogging userForLogging;
  private String message;
  private Date date = new Date();
  private Long messageId;

  public MessageForLogging(TelegramMessage telegramMessage) {
    this.chatForLogging = new ChatForLogging(telegramMessage.getTelegramChat());
    this.userForLogging = new UserForLogging(telegramMessage.getTelegramUser());
    this.message = telegramMessage.getMessage();
    this.date = telegramMessage.getDate();
    this.messageId = telegramMessage.getMessageId();
  }
}
