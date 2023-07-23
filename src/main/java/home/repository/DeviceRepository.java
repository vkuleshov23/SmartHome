package home.repository;

import home.model.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface DeviceRepository<T extends Device> extends JpaRepository<T, Long> {

    long deleteByName(String name);
    Optional<T> findByName(String name);
    List<T> findByType(String type);

}