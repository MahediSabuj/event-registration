CREATE TABLE IF NOT EXISTS user_roles (
  id SERIAL PRIMARY KEY,
  user_role_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100),
  email_address VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL,
  profile_image VARCHAR(100),
  terms_accepted boolean NOT NULL,
  user_role_id INT NOT NULL REFERENCES user_roles(id)
);

CREATE TABLE IF NOT EXISTS events (
  id SERIAL PRIMARY KEY,
  event_name VARCHAR(100) NOT NULL,
  event_description VARCHAR(500),
  event_location VARCHAR(100) NOT NULL,
  event_start_datetime TIMESTAMP NOT NULL,
  event_end_datetime TIMESTAMP NOT NULL,
  registration_start_datetime TIMESTAMP NOT NULL,
  registration_end_datetime TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS event_participants (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES users(id),
  event_id INT NOT NULL REFERENCES events(id),
  registration_datetime TIMESTAMP NOT NULL,
  UNIQUE (user_id, event_id)
);
