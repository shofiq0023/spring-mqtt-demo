# MQTT Integration with Spring-boot
This is a demo project with mqtt integration using **mosquitto broker** and **Spring-boot**

### For Mosquitto Server
- `mosquitto_passwd -U passFile` to encrypt the password given in a password file.
- `mosquitto -v -c test-broker.conf` to start the mosquitto broker with given config file.
- `mosquitto_sub -t my_topic -u admin -P 123456` subscribe to a `topic` with `username` and `password`.
- `mosquitto_pub -t my_topic -m "message" -u admin -P 123456` publish `message` to a `topic` using `username` and `password`

**Note:** The configuration file and password files are all location in the Mosquitto installation directory.