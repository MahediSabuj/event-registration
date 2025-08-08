INSERT INTO user_roles (user_role_name) VALUES ('USER') ON CONFLICT DO NOTHING;
INSERT INTO user_roles (user_role_name) VALUES ('ADMIN') ON CONFLICT DO NOTHING;
