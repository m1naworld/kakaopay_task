CREATE TABLE menu (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    price INT NOT NULL
);

CREATE TABLE members (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE points (
    member_id BIGINT NOT NULL PRIMARY KEY,
    point INT NOT NULL DEFAULT 0
);

CREATE TABLE point_credit(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    member_id BIGINT NOT NULL,
    point INT NOT NULL,
    credit_date DATETIME NOT NULL
);

CREATE TABLE orders (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    member_id BIGINT NOT NULL,
    order_date DATETIME NOT NULL,
    menu_id BIGINT NOT NULL,
    price INT NOT NULL
);

CREATE TABLE best_menu (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dates DATE NOT NULL,
    menu_id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    order_count INT NOT NULL
);
