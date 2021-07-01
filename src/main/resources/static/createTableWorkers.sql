DROP TABLE IF EXISTS Worker;

CREATE TABLE Worker
(
    id             BIGINT(20)  NOT NULL AUTO_INCREMENT,
    salary    INT(255)     NULL,
    name           VARCHAR(12) NULL,
    completedTasks          VARCHAR(1000) NULL,
    outstandingTasks          VARCHAR(1000) NULL,
        workProjects     VARCHAR(20) NULL,
    online         BIT(1)      NULL,
    PRIMARY KEY (id)
);