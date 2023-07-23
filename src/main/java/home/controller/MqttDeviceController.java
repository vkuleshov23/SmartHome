package home.controller;

import home.converter.request.device.DtoToMqttDevice;
import home.converter.response.device.MqttDeviceToDto;
import home.dto.device.MqttDeviceDto;
import home.interfaces.service.MqttDeviceService;
import home.model.device.MqttDevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mqtt_devices")
public class MqttDeviceController {

    private final String TYPES = "/types";

    private final DtoToMqttDevice dtoToMqttDevice;

    private final MqttDeviceToDto mqttDeviceToDto;

    private final MqttDeviceService mqttDeviceService;

    @GetMapping(TYPES)
    public ResponseEntity<List<MqttDeviceDto>> getDevicesByType(@RequestParam String type) {
        return ResponseEntity.ok(mqttDeviceToDto.convert(mqttDeviceService.getDevicesByType(type)));
    }

    @GetMapping
    public ResponseEntity<List<MqttDeviceDto>> getDevices() {
        return ResponseEntity.ok(mqttDeviceToDto.convert(mqttDeviceService.getDevices()));
    }

    @PostMapping
    public ResponseEntity<String> registerNewDevice(@RequestBody MqttDeviceDto dto) {
        MqttDevice device = dtoToMqttDevice.convert(dto);
        mqttDeviceService.createDevice(device);
        return ResponseEntity.ok("registered");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDevice (@RequestParam String name) {
        mqttDeviceService.removeDevice(name);
        return ResponseEntity.ok("deleted");
    }

}
