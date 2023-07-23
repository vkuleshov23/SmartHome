package home.repository;

import home.model.broker.Broker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BrokerRepository<T extends Broker> extends JpaRepository<T, Long> {

}
