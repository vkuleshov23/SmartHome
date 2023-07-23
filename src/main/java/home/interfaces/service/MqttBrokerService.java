package home.interfaces.service;

import home.model.broker.MqttBroker;
import org.springframework.stereotype.Service;

@Service
public interface MqttBrokerService {

    MqttBroker findBrokerInDataBase(MqttBroker brokerFromDto);
}
