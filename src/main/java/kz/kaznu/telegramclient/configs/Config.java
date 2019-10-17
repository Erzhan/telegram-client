package kz.kaznu.telegramclient.configs;

import kz.kaznu.telegramclient.services.telegram.DatabaseManagerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.bot.kernel.KernelComm;
import org.telegram.bot.kernel.database.DatabaseManager;
import org.telegram.bot.kernel.differenceparameters.DifferenceParametersService;

/**
 * Created by yerzhan on 10/10/19.
 */
@Configuration
public class Config {

  @Value("${telegram.phone.number}")
  private String phoneNumber;

  @Value("${telegram.api.key}")
  private Integer apiKey;


  @Bean
  public DifferenceParametersService differenceParametersService() {
    return new DifferenceParametersService(databaseManager());
  }

  @Bean
  public KernelComm kernelComm() {
    return new KernelComm(apiKey, null);
  }

  @Bean
  public DatabaseManager databaseManager() {
    return new DatabaseManagerImpl();
  }
}
