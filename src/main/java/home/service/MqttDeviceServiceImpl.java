package home.service;

import home.exception.InvalidIDException;
import home.exception.InvalidIncomingData;
import home.interfaces.service.MqttBrokerService;
import home.interfaces.service.MqttDeviceService;
import home.model.device.MqttDevice;
import home.repository.MqttDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MqttDeviceServiceImpl implements MqttDeviceService {

    private final MqttDeviceRepository mqttDeviceRepository;
    private final MqttBrokerService mqttBrokerService;

    @Override
    @Transactional
    public void removeDevice(String name) {
        long id = mqttDeviceRepository.deleteByName(name);
        if(id <= 0) {
            throw new InvalidIDException("invalid device ID for deleting");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MqttDevice> getDevices() {
        return mqttDeviceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MqttDevice> getDevicesByType(String type) {
        return mqttDeviceRepository.findByType(type);
    }

    @Override
    @Transactional
    public MqttDevice createDevice(MqttDevice device) {
        device.setMqttBroker(mqttBrokerService.findBrokerInDataBase(device.getMqttBroker()));
        try {
            return mqttDeviceRepository.save(device);
        } catch (Exception e) {
            throw new InvalidIncomingData("Invalid device data field");
        }
    }
}
