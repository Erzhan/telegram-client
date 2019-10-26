CREATE TABLE telegram_chat
(
    id bigint NOT NULL,
    access_hash bigint,
    date integer,
    flag integer,
    participants_count integer,
    restriction_reason character varying(255),
    title character varying(255),
    type character varying(255),
    username character varying(255),
    version integer,
    CONSTRAINT telegram_chat_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE telegram_message_id_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE telegram_user
(
    id bigint NOT NULL,
    access_hash bigint,
    bot_info_version integer,
    bot_inline_placeholder character varying(255),
    first_name character varying(255),
    flag integer,
    lang_code character varying(255),
    last_name character varying(255),
    phone character varying(255),
    restriction_reason character varying(255),
    user_name character varying(255),
    CONSTRAINT telegram_user_pkey PRIMARY KEY (id)
);

CREATE TABLE telegram_message
(
    id bigint NOT NULL DEFAULT nextval('telegram_message_id_seq'::regclass),
    date timestamp without time zone,
    message character varying(255),
    message_id bigint,
    telegram_chat_id bigint,
    telegram_user_id bigint,
    CONSTRAINT telegram_message_pkey PRIMARY KEY (id),
    CONSTRAINT fk1c1qdglacb3ytruom4147q59r FOREIGN KEY (telegram_chat_id)
        REFERENCES telegram_chat (id),
    CONSTRAINT fkmvywmp07f8r2gru8c5lg51cy4 FOREIGN KEY (telegram_user_id)
        REFERENCES telegram_user (id)
);