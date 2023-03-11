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
ALTER TABLE orders ADD INDEX order_date_idx(order_date);

CREATE TABLE best_menu (
    dates DATE NOT NULL PRIMARY KEY,
    menu_id BIGINT NOT NULL,
    name VARCHAR(20) NOT NULL,
    price INT NOT NULL,
    order_count INT NOT NULL
);

CREATE TABLE shedlock (
    name varchar(64) NOT NULL COMMENT '스케줄잠금이름',
    lock_until timestamp(3) NULL DEFAULT NULL COMMENT '잠금기간',
    locked_at timestamp(3) NULL DEFAULT NULL COMMENT '잠금일시',
    locked_by varchar(255) DEFAULT NULL COMMENT '잠금신청자',
    PRIMARY KEY (name)
);

