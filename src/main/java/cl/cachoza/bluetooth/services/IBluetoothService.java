package cl.cachoza.bluetooth.services;

import java.util.List;

import cl.cachoza.bluetooth.entity.Bluetooth;

public interface IBluetoothService {

		List<Bluetooth> findAll();

}