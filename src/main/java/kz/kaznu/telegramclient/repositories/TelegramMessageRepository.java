package kz.kaznu.telegramclient.repositories;

import java.util.List;
import kz.kaznu.telegramclient.models.TelegramMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by yerzhan on 10/21/19.
 */
@Repository
public interface TelegramMessageRepository extends JpaRepository<TelegramMessage, Long> {

  @Query(value = "select * from telegram_message tm where message_id = ?1 and telegram_chat_id = ?2", nativeQuery = true)
  List<TelegramMessage> findByMessageIdAndTelegramChat(Integer messageId, Integer telegramChatId);
}
