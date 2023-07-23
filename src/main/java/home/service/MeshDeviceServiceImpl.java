package home.service;

import home.interfaces.service.MeshDeviceService;
import home.model.device.MeshDevice;
import home.repository.MeshDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeshDeviceServiceImpl implements MeshDeviceService {

    private final MeshDeviceRepository meshDeviceRepository;

    @Override
    @Transactional
    public MeshDevice createMeshDevice(MeshDevice device) {
        return meshDeviceRepository.save(device);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MeshDevice> getMeshDevices() {
        return meshDeviceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MeshDevice> getDevicesByType(String type) {
        return null;
    }
}
