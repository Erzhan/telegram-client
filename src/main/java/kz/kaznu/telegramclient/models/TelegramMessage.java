package kz.kaznu.telegramclient.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by yerzhan on 10/21/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telegram_message")
public class TelegramMessage {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "telegram_chat_id")
  private TelegramChat telegramChat;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "telegram_user_id")
  private TelegramUser telegramUser;

  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "DATE")
  private Date date = new Date();

  @Column(name = "MESSAGE_ID")
  private Long messageId;
}
