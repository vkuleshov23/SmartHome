CREATE TABLE http_broker (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   broker_name VARCHAR(255) NOT NULL,
   broker_type VARCHAR(255) NOT NULL,
   broker_url VARCHAR(255) NOT NULL,
   broker_port INTEGER NOT NULL,
   CONSTRAINT pk_http_broker PRIMARY KEY (id)
);

ALTER TABLE http_broker ADD CONSTRAINT uc_http_broker_broker_name UNIQUE (broker_name);

CREATE TABLE mqtt_broker (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   broker_name VARCHAR(255) NOT NULL,
   broker_type VARCHAR(255) NOT NULL,
   broker_url VARCHAR(255) NOT NULL,
   broker_port INTEGER NOT NULL,
   login VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   protocol VARCHAR(255) NOT NULL,
   CONSTRAINT pk_mqtt_broker PRIMARY KEY (id)
);

ALTER TABLE mqtt_broker ADD CONSTRAINT uc_mqtt_broker_broker_name UNIQUE (broker_name);

CREATE TABLE mesh_device (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   device_name VARCHAR(255) NOT NULL,
   device_type VARCHAR(255) NOT NULL,
   http_broker BIGINT NOT NULL,
   CONSTRAINT pk_mesh_device PRIMARY KEY (id)
);

ALTER TABLE mesh_device ADD CONSTRAINT uc_mesh_device_device_name UNIQUE (device_name);

ALTER TABLE mesh_device ADD CONSTRAINT FK_MESH_DEVICE_ON_HTTP_BROKER FOREIGN KEY (http_broker) REFERENCES http_broker (id);

CREATE TABLE mqtt_device (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   device_name VARCHAR(255) NOT NULL,
   device_type VARCHAR(255) NOT NULL,
   mqtt_broker BIGINT NOT NULL,
   CONSTRAINT pk_mqtt_device PRIMARY KEY (id)
);

ALTER TABLE mqtt_device ADD CONSTRAINT uc_mqtt_device_device_name UNIQUE (device_name);

ALTER TABLE mqtt_device ADD CONSTRAINT FK_MQTT_DEVICE_ON_MQTT_BROKER FOREIGN KEY (mqtt_broker) REFERENCES mqtt_broker (id);