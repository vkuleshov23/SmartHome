package home.converter.response.device;

import home.converter.response.broker.MqttBrokerToDto;
import home.dto.device.MqttDeviceDto;
import home.model.device.MqttDevice;
import home.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MqttDeviceToDto implements Converter<MqttDevice, MqttDeviceDto> {

    private final MqttBrokerToDto mqttBrokerToDto;

    @Override
    public MqttDeviceDto convert(MqttDevice source) {
        return MqttDeviceDto.builder()
                .name(source.getName())
                .type(source.getType())
                .mqttBrokerDto(
                        mqttBrokerToDto.convert(
                                source.getMqttBroker()))
                .build();
    }
}
