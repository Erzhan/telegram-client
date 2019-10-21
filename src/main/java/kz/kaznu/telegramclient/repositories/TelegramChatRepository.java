package kz.kaznu.telegramclient.repositories;

import kz.kaznu.telegramclient.models.TelegramChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yerzhan on 10/19/19.
 */
@Repository
public interface TelegramChatRepository extends JpaRepository<TelegramChat, Long> {

}
