package home.repository;

import home.model.broker.HttpBroker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HttpBrokerRepository extends BrokerRepository<HttpBroker> {
}