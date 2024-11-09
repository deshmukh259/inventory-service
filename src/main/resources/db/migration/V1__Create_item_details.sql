CREATE TABLE item_details
(
    item_id       INTEGER PRIMARY KEY,
    item_name     varchar UNIQUE NOT NULL,
    total_qty     INTEGER        not null,
    sold_qty      INTEGER        not null,
    supplier_desc varchar,
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    status        varchar(20)

);