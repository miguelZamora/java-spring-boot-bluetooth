package cl.cachoza.bluetooth.repository;

import cl.cachoza.bluetooth.entity.Bluetooth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BluetoothRepository extends JpaRepository<Bluetooth, Long> {

}
