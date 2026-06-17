INSERT IGNORE INTO hospital_db.patients (
    name,
    email,
    gender,
    birth_date,
    blood_group
) VALUES
      ('John Doe', 'john.doe@example.com', 'MALE', '1995-08-15', 'A_POSITIVE'),
      ('Jane Smith', 'jane.smith@example.com', 'FEMALE', '1998-03-22', 'O_NEGATIVE'),
      ('Bob Johnson', 'bob.johnson@example.com', 'MALE', '1992-11-10', 'B_POSITIVE'),
      ('Alice Brown', 'alice.brown@example.com', 'FEMALE', '1997-06-05', 'AB_POSITIVE'),
      ('Michael Wilson', 'michael.wilson@example.com', 'MALE', '1990-01-18', 'O_POSITIVE'),
      ('Emma Davis', 'emma.davis@example.com', 'FEMALE', '1999-09-12', 'A_NEGATIVE'),
      ('William Taylor', 'william.taylor@example.com', 'MALE', '1993-04-27', 'B_NEGATIVE'),
      ('Sophia Anderson', 'sophia.anderson@example.com', 'FEMALE', '1996-12-03', 'AB_NEGATIVE'),
      ('James Thomas', 'james.thomas@example.com', 'MALE', '1989-07-21', 'O_POSITIVE'),
      ('Olivia Martinez', 'olivia.martinez@example.com', 'FEMALE', '2000-02-14', 'A_POSITIVE'),
      ('Benjamin Garcia', 'benjamin.garcia@example.com', 'MALE', '1994-05-30', 'B_POSITIVE'),
      ('Isabella Rodriguez', 'isabella.rodriguez@example.com', 'FEMALE', '1991-10-08', 'O_NEGATIVE'),
      ('Lucas Hernandez', 'lucas.hernandez@example.com', 'MALE', '1998-01-25', 'AB_POSITIVE'),
      ('Mia Lopez', 'mia.lopez@example.com', 'FEMALE', '1995-11-17', 'A_NEGATIVE'),
      ('Ethan Gonzalez', 'ethan.gonzalez@example.com', 'MALE', '1992-08-09', 'B_NEGATIVE');
