CREATE TABLE IF NOT EXISTS quizzes (
    id SERIAL PRIMARY KEY,
    answer_id INT REFERENCES answers(id),
    question VARCHAR(255) NOT NULL
);
