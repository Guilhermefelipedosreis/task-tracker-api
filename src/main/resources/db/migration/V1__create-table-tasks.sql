create table tasks (
    
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `status` VARCHAR(6) NOT NULL,

    PRIMARY KEY(id)
)