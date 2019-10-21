package kz.kaznu.telegramclient.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "telegram_update_differences_date")
public class TelegramUpdateDifferencesData {

  @Id
  @Column(name = "BOT_ID")
  private Integer botId;

  @Column(name = "PTS")
  private Integer pts;

  @Column(name = "DATE")
  private Integer date;

  @Column(name = "SEQ")
  private Integer seq;
}
