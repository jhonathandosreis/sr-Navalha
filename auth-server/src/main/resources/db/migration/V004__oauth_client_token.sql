CREATE TABLE oauth_client_token (
    token_id varchar(256) NULL,
    token BLOB NULL,
    authentication_id varchar(256) NULL,
    user_name varchar(256) NULL,
    client_id varchar(256) NULL
);