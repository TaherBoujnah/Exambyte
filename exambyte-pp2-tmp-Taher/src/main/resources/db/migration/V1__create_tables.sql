CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS courses(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tests(
    id SERIAL PRIMARY KEY,
    name varchar(255) not null,
    courses_id REFERENCES courses(id) ON DELETE CASCADE,
    date_time TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS courses_students (
    user_id INT REFERENCES users(id) ON DELETE CASCADE ,
    course_id INT REFERENCES courses(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, course_id)

);

CREATE TABLE IF NOT EXISTS exams_students (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    course_id INT REFERENCES courses(id) ON DELETE CASCADE,
    score INT CHECK (score>=0 AND score<=100),
    PRIMARY KEY (student_id, exam_id)
);