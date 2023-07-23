package home.interfaces.service;

import home.model.device.MeshDevice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MeshDeviceService {

    MeshDevice createMeshDevice(MeshDevice device);
    List<MeshDevice> getMeshDevices();
    List<MeshDevice> getDevicesByType(String type);
}
