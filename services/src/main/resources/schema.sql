
CREATE TABLE IF NOT EXISTS Payment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    type_Id BIGINT NOT NULL,
    client_Name VARCHAR(255) NOT NULL,
    payment_Quantity INTEGER not null,
    payment_Amount NUMERIC(20, 2) not null
);

create table if not exists Services (
    id bigint primary key auto_increment,
    type varchar(255) not null
);



