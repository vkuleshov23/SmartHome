package home.repository;

import home.model.broker.MqttBroker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MqttBrokerRepository extends BrokerRepository<MqttBroker> {
}