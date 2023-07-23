package home.dto.device;

import home.dto.broker.MqttBrokerDto;
import lombok.Builder;

@Builder
public record MqttDeviceDto(
                        String name,
                        String type,
                        MqttBrokerDto mqttBrokerDto
                        ) {}
