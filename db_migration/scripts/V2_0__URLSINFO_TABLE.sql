CREATE TABLE IF NOT EXISTS shorturl.urls_info
(
    short_url text CONSTRAINT id_pk PRIMARY KEY,
    full_url text NOT NULL,
    created_date timestamp with time zone NOT NULL,
    last_used_date timestamp with time zone NOT NULL,
    life_time bigint,
    click_count bigint
);

comment on column shorturl.urls_info.life_time is 'life time in millis';

ALTER TABLE shorturl.urls_info
    OWNER to root;
