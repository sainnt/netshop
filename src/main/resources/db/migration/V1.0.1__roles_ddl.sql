CREATE TABLE IF NOT EXISTS Role(
    id BIGINT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE
);
CREATE SEQUENCE IF NOT EXISTS ROLE_SEQ START WITH 1 INCREMENT 1;

CREATE TABLE IF NOT EXISTS user_roles(
    user_id BIGINT NOT NULL REFERENCES user_info,
    role_id BIGINT NOT NULL REFERENCES Role,
    UNIQUE (user_id, role_id)
)

