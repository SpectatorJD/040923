--changeset dtkakischak:add_index
CREATE INDEX index_student_name ON student(name);
CREATE  INDEX index_faculty_color_name ON faculty(color, name);