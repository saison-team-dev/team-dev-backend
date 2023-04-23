CREATE TABLE IF NOT EXISTS scores (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    total_score INT NOT NULL,
    correct_rate INT NOT NULL
)