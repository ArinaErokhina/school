-- liquibase formatted sql

-- changeset aerokhina:1
CREATE INDEX student_n_idx ON student(name);

-- changeset aerokhina:2
CREATE INDEX faculty_nc_idx ON faculty(name, color);