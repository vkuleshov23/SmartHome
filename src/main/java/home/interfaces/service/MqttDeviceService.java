package home.interfaces.service;

import home.model.device.Device;
import home.model.device.MqttDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MqttDeviceService {
    MqttDevice createDevice(MqttDevice device);

    void removeDevice(String name);

    List<MqttDevice> getDevices();

    List<MqttDevice> getDevicesByType(String type);
}
