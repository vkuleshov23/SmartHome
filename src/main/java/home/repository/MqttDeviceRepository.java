package home.repository;

import home.model.device.MqttDevice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MqttDeviceRepository extends DeviceRepository<MqttDevice>  {
}
