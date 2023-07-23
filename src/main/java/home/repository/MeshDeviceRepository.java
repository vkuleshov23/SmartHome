package home.repository;

import home.model.device.MeshDevice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface MeshDeviceRepository extends DeviceRepository<MeshDevice> {
}