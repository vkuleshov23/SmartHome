package home.converter.request.broker;

import home.dto.broker.MqttBrokerDto;
import home.model.broker.MqttBroker;
import home.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToMqttBroker implements Converter<MqttBrokerDto, MqttBroker> {

    @Override
    public MqttBroker convert(MqttBrokerDto source) {
        return MqttBroker.builder()
                .name(source.name())
                .type(source.type())
                .login(source.login())
                .password(source.password())
                .url(source.url())
                .port(source.port())
                .protocol(source.protocol())
                .build();
    }
}
