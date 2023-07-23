package home.dto.broker;

import lombok.Builder;

@Builder
public record MqttBrokerDto (

    String name,
    String type,
    String login,
    String password,
    Integer port,
    String protocol,
    String url
) {}
