CREATE TABLE refresh_tokens (
    jti UUID,
    root_jti UUID,
    replaced_by UUID,
    user_id UUID NOT NULL,
    issued_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    expires_at TIMESTAMPTZ NOT NULL,
    rotated_at TIMESTAMPTZ,
    revoked_at TIMESTAMPTZ,
    ip INET,
    user_agent TEXT,

    CONSTRAINT pk_refresh_tokens_jti
        PRIMARY KEY (jti),
    CONSTRAINT fk_refresh_tokens_root_jti
        FOREIGN KEY (root_jti) REFERENCES refresh_tokens(jti),
    CONSTRAINT fk_refresh_tokens_replaced_by
        FOREIGN KEY (replaced_by) REFERENCES refresh_tokens(jti),
    CONSTRAINT fk_refresh_tokens_user_id
        FOREIGN KEY (user_id) REFERENCES users(id)
);
