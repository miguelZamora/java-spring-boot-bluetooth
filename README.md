# java-spring-boot-bluetooth


Para las Pruebas se deben tener disposivos Bluetooth y el pc debe tener mismo dispositivo.

Obtener dispositivos (que esten dentro del rango y esten activos)

GET http://localhost:8080/api/bluetooth/dispositivos


POST http://localhost:8080/api/bluetooth/conectar 

json 

{
    "direccion": "CCC50A7CDBC3",
    "nombreDispositivo": "HP BT Mini"
}


en donde direccion es el UID "direccion": "CCC50A7CDBC3" algo asi

curl --location 'http://localhost:8080/api/bluetooth/conectar' \
--header 'Content-Type: application/json' \
--data '{
    "direccion": "CCC50A7DABC3",
    "nombreDispositivo": "HP BT Mini"
}'


Saludos.
