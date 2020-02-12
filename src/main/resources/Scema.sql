CREATE TABLE role
(
    id int PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX role_id_uindex ON role (id);
CREATE UNIQUE INDEX role_role_uindex ON role (role);

CREATE TABLE user
(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id int DEFAULT 1 NOT NULL,
    active_status int DEFAULT 1 NOT NULL
);
CREATE UNIQUE INDEX user_id_uindex ON user (id);
CREATE UNIQUE INDEX user_login_uindex ON user (login);

CREATE TABLE user_info
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    date_of_birthday DATE,
    date_of_registration DATE,
    driver_licence VARCHAR(50)
);
CREATE UNIQUE INDEX user_info_id_uindex ON user_info (id);
CREATE UNIQUE INDEX user_info_user_id_uindex ON user_info (user_id);
CREATE UNIQUE INDEX user_info_email_uindex ON user_info (email);

CREATE TABLE car
(
    id int PRIMARY KEY AUTO_INCREMENT,
    mark_id int NOT NULL,
    model_id int NOT NULL,
    millage int NOT NULL,
    price FLOAT NOT NULL,
    car_status_id int NOT NULL
);
CREATE UNIQUE INDEX car_id_uindex ON car (id);


CREATE TABLE country_of_manufacture
(
    id int PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX country_of_manufacture_id_uindex ON country_of_manufacture (id);
CREATE UNIQUE INDEX country_of_manufacture_country_uindex ON country_of_manufacture (country);

CREATE TABLE car_mark
(
    id int PRIMARY KEY AUTO_INCREMENT,
    mark VARCHAR(50) NOT NULL,
    country_of_manufacture_id INT NOT NULL
);
CREATE UNIQUE INDEX car_mark_id_uindex ON car_mark (id);

CREATE TABLE car_model
(
    id int PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX car_model_id_uindex ON car_model (id);
CREATE UNIQUE INDEX car_model_model_uindex ON car_model (model);

CREATE TABLE car_status
(
    id int PRIMARY KEY AUTO_INCREMENT,
    car_status varchar(50) NOT NULL
);
CREATE UNIQUE INDEX car_status_id_uindex ON car_status (id);
CREATE UNIQUE INDEX car_status_car_status_uindex ON car_status (car_status);

CREATE TABLE `order`
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    car_id int NOT NULL,
    rent_hours int NOT NULL,
    total_price DOUBLE NOT NULL,
    payment_status BOOLEAN DEFAULT false  NOT NULL,
    confirm_status BOOLEAN DEFAULT false  NOT NULL,
    date_of_reg_order DATETIME NOT NULL,
    order_status BOOLEAN DEFAULT true  NOT NULL,
    notes VARCHAR(255)
);
CREATE UNIQUE INDEX order_id_uindex ON `order` (id);

ALTER TABLE user MODIFY active_status BOOLEAN NOT NULL DEFAULT TRUE ;

ALTER TABLE user
ADD CONSTRAINT user_role_id_fk
FOREIGN KEY (role_id) REFERENCES role (id)

ALTER TABLE car
ADD CONSTRAINT car_car_mark_id_fk
FOREIGN KEY (mark_id) REFERENCES car_mark (id);
ALTER TABLE car
ADD CONSTRAINT car_car_model_id_fk
FOREIGN KEY (model_id) REFERENCES car_model (id);
ALTER TABLE car
ADD CONSTRAINT car_car_status_id_fk
FOREIGN KEY (car_status_id) REFERENCES car_status (id);

ALTER TABLE car_mark
ADD CONSTRAINT car_mark_country_of_manufacture_id_fk
FOREIGN KEY (country_of_manufacture_id) REFERENCES country_of_manufacture (id);

ALTER TABLE user_info
ADD CONSTRAINT user_info_user_id_fk
FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE `order`
ADD CONSTRAINT order_user_id_fk
FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE `order`
ADD CONSTRAINT order_car_id_fk
FOREIGN KEY (car_id) REFERENCES car (id);


