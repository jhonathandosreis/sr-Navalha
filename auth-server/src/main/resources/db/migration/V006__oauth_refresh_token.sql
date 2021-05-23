CREATE TABLE oauth_refresh_token (
    token_id varchar(256) NULL,
    token BLOB NULL,
    authentication BLOB NULL
);