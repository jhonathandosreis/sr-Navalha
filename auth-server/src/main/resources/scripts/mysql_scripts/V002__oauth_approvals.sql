CREATE TABLE oauth_approvals (
    userid varchar(256) NULL,
    clientid varchar(256) NULL,
    `scope` varchar(256) NULL,
    `status` varchar(10) NULL,
    expiresat timestamp NULL,
    lastmodifiedat timestamp NULL
);