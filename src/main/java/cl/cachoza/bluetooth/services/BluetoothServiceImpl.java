package cl.cachoza.bluetooth.services;

import java.util.List;
import java.util.Optional;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.cachoza.bluetooth.entity.*;
import cl.cachoza.bluetooth.listener.BluetoothDiscoveryListener;
import cl.cachoza.bluetooth.repository.BluetoothRepository;


@Service
public class BluetoothServiceImpl implements IBluetoothService  {

	@Autowired
	private BluetoothRepository repository;

	public List<Bluetooth> findAll() {

		return repository.findAll();
	}

	public Optional<Bluetooth> findById(Long id) {
		return repository.findById(id);
	}



	

}