package home.converter.response.broker;

import home.dto.broker.MqttBrokerDto;
import home.model.broker.MqttBroker;
import home.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MqttBrokerToDto implements Converter<MqttBroker, MqttBrokerDto> {
    @Override
    public MqttBrokerDto convert(MqttBroker source) {
        return MqttBrokerDto.builder()
                .name(source.getName())
                .type(source.getType())
                .login(source.getLogin())
                .password(source.getPassword())
                .port(source.getPort())
                .url(source.getUrl())
                .protocol(source.getProtocol())
                .build();
    }
}
