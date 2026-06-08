CREATE TABLE verification_codes (
    id BIGSERIAL,
    user_id UUID NOT NULL,
    channel VARCHAR(10) NOT NULL,
    type VARCHAR(50) NOT NULL,
    code VARCHAR(10) NOT NULL,
    consumed_at TIMESTAMPTZ,
    expires_at TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT pk_verification_codes_id
        PRIMARY KEY (id),
    CONSTRAINT fk_verification_codes_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
);
