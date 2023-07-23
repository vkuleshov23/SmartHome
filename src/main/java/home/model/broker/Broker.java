package home.model.broker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Broker {

    @Column(name = "broker_name", unique = true, nullable = false)
    protected String name;

    @Column(name = "broker_type", nullable = false)
    protected String type;

    @Column(name = "broker_url", nullable = false)
    protected String url;

    @Column(name = "broker_port", nullable = false)
    protected Integer port;

}
