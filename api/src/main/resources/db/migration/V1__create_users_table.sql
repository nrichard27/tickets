CREATE TABLE users (
    id UUID,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(254) NOT NULL,
    is_email_verified BOOLEAN NOT NULL DEFAULT false,
    is_active BOOLEAN NOT NULL DEFAULT true,
    password_hash TEXT NOT NULL,
    is_mfa_enabled BOOLEAN NOT NULL DEFAULT false,
    totp_secret TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT pk_users_id
        PRIMARY KEY (id),
    CONSTRAINT uq_users_email
        UNIQUE (email)
);
