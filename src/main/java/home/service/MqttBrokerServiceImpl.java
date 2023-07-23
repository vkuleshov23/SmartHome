package home.service;

import home.exception.InvalidIncomingData;
import home.interfaces.service.MqttBrokerService;
import home.model.broker.MqttBroker;
import home.repository.MqttBrokerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MqttBrokerServiceImpl implements MqttBrokerService {

    private final MqttBrokerRepository mqttBrokerRepository;

    @Override
    @Transactional(readOnly = true)
    public MqttBroker findBrokerInDataBase(MqttBroker brokerFromDto) {
        return mqttBrokerRepository.findOne(Example.of(brokerFromDto))
                .orElseThrow(() -> new InvalidIncomingData("No such mqtt broker exist"));
    }
}
