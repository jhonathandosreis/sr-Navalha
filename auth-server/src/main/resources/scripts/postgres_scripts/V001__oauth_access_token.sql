CREATE TABLE public.oauth_access_token (
	token_id varchar(256) NULL,
	token bytea NULL,
	authentication_id varchar(256) NOT NULL,
	user_name varchar(256) NULL,
	client_id varchar(256) NULL,
	authentication bytea NULL,
	refresh_token varchar(256) NULL,
	CONSTRAINT oauth_access_token_pk PRIMARY KEY (authentication_id)
);