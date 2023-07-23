package home.model.device;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Device {

    @Column(name = "device_name", unique = true, nullable = false)
    protected String name;

    @Column(name = "device_type", nullable = false)
    protected String type;

}
