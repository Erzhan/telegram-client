package kz.kaznu.telegramclient.repositories;

import kz.kaznu.telegramclient.models.TelegramUpdateDifferencesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yerzhan on 10/21/19.
 */
@Repository
public interface TelegramUpdateDifferencesDataRepository extends
    JpaRepository<TelegramUpdateDifferencesData, Integer> {

}
