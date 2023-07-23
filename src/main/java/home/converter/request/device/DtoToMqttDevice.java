package home.converter.request.device;

import home.converter.request.broker.DtoToMqttBroker;
import home.dto.device.MqttDeviceDto;
import home.model.device.MqttDevice;
import home.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToMqttDevice implements Converter<MqttDeviceDto, MqttDevice> {

    private final DtoToMqttBroker dtoToMqttBroker;

    @Override
    public MqttDevice convert(MqttDeviceDto source) {
        return MqttDevice.builder()
                .name(source.name())
                .type(source.type())
                .mqttBroker(
                        dtoToMqttBroker.convert(
                                source.mqttBrokerDto()))
                .build();
    }
}
