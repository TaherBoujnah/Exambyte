
CREATE TABLE IF NOT EXISTS users (
id SERIAL PRIMARY KEY,
uuid UUID UNIQUE NOT NULL,
name VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
role VARCHAR(50) NOT NULL CHECK (role IN ('organiser', 'corrector', 'student'))
);


CREATE TABLE IF NOT EXISTS exam (
id SERIAL PRIMARY KEY,
uuid UUID UNIQUE NOT NULL,
name VARCHAR(255) NOT NULL,
overall_score INT NOT NULL
);


CREATE TABLE IF NOT EXISTS questions (
id UUID PRIMARY KEY,
question_text TEXT NOT NULL,
points INTEGER NOT NULL,
accorded_points INTEGER
);


CREATE TABLE IF NOT EXISTS mcq_questions (
id UUID PRIMARY KEY REFERENCES questions(id) ON DELETE CASCADE,
options TEXT NOT NULL,
correct_option_index INTEGER NOT NULL
);


CREATE TABLE IF NOT EXISTS text_questions (
id UUID PRIMARY KEY REFERENCES questions(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS exam_results (
id SERIAL PRIMARY KEY,
uuid UUID UNIQUE NOT NULL,
student_id UUID NOT NULL,
exam_id UUID NOT NULL,
corrector_id UUID NOT NULL,
grade INTEGER NOT NULL,
FOREIGN KEY (student_id) REFERENCES users(uuid) ON DELETE CASCADE,
FOREIGN KEY (exam_id) REFERENCES exam(uuid) ON DELETE CASCADE,
FOREIGN KEY (corrector_id) REFERENCES users(uuid) ON DELETE CASCADE
);




