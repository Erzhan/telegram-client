package kz.kaznu.telegramclient.repositories;

import kz.kaznu.telegramclient.models.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yerzhan on 10/10/19.
 */
@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, Long> {

}
