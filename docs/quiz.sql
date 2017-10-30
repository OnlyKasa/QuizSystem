
CREATE TABLE "public".examination_room ( 
	i_examination_room_pk integer  NOT NULL,
	str_examination_room_name varchar(100)  ,
	i_examination_room_pk_ek integer  ,
	CONSTRAINT pk_examination_room PRIMARY KEY ( i_examination_room_pk )
 );

CREATE TABLE "public".faculty_information ( 
	i_faculty_information_pk integer  NOT NULL,
	str_faculty_information_short_name varchar(10)  ,
	str_faculty_information_full_name varchar(100)  ,
	i_faculty_information_pk_ek integer  ,
	CONSTRAINT pk_faculty_information PRIMARY KEY ( i_faculty_information_pk )
 );

CREATE TABLE "public".rate_of_difficulty ( 
	i_rate_of_difficulty_pk integer  NOT NULL,
	i_num_question_level_1 integer  ,
	i_num_question_level_2 integer  ,
	i_num_question_level_3 integer  ,
	i_num_question_level_4 integer  ,
	i_rate_of_difficulty_pk_ek integer  ,
	CONSTRAINT pk_rate_of_difficulty PRIMARY KEY ( i_rate_of_difficulty_pk )
 );

CREATE TABLE "public".student_information ( 
	i_student_information_pk integer  NOT NULL,
	i_student_information_code integer  NOT NULL,
	i_faculty_information_pk integer  ,
	str_student_information_first_name varchar(30)  ,
	str_student_information_last_name varchar(30)  ,
	dt_student_information_birthday date  ,
	i_student_information_pk_ek integer  ,
	CONSTRAINT pk_student_information PRIMARY KEY ( i_student_information_pk ),
	CONSTRAINT idx_student_information_code UNIQUE ( i_student_information_code ) 
 );

CREATE INDEX idx_student_information ON "public".student_information ( i_faculty_information_pk );

CREATE TABLE "public".subject_information ( 
	i_subject_information_pk integer  NOT NULL,
	str_subject_information_name varchar(100)  NOT NULL,
	i_subject_information_credit_num integer  NOT NULL,
	i_subject_information_pk_ek integer  ,
	CONSTRAINT pk_subjects_information PRIMARY KEY ( i_subject_information_pk )
 );

CREATE TABLE "public".teacher_information ( 
	i_teacher_information_pk integer  NOT NULL,
	i_faculty_information_pk integer  ,
	str_teacher_information_first_name varchar(30)  ,
	str_teacher_information_last_name varchar(30)  ,
	b_teacher_information_gender bool  ,
	str_teacher_information_phone varchar(15)  ,
	i_teacher_information_pk_ek integer  ,
	CONSTRAINT pk_teacher_information PRIMARY KEY ( i_teacher_information_pk )
 );

CREATE INDEX idx_teacher_information ON "public".teacher_information ( i_faculty_information_pk );

CREATE TABLE "public".test_information ( 
	i_test_information_pk integer  NOT NULL,
	i_test_information_time integer  NOT NULL,
	i_rate_of_difficulty_pk integer  ,
	i_test_information_pk_ek integer  ,
	CONSTRAINT pk_test_information PRIMARY KEY ( i_test_information_pk )
 );

CREATE INDEX idx_test_information ON "public".test_information ( i_rate_of_difficulty_pk );

CREATE TABLE "public".examination_list ( 
	i_examination_list_pk integer  NOT NULL,
	i_examination_room_pk integer  ,
	i_subject_information_pk integer  ,
	i_teacher_information_pk integer  ,
	dt_examination_day   date  ,
	i_examination_list_pk_ek integer  ,
	CONSTRAINT pk_examination_list PRIMARY KEY ( i_examination_list_pk )
 );

CREATE INDEX idx_examination_list ON "public".examination_list ( i_examination_room_pk );

CREATE INDEX idx_examination_list_0 ON "public".examination_list ( i_subject_information_pk );

CREATE INDEX idx_examination_list_1 ON "public".examination_list ( i_teacher_information_pk );

CREATE TABLE "public".examination_list_detail ( 
	i_examination_list_detail_pk integer  NOT NULL,
	i_examination_list_pk integer  ,
	i_examination_list_detail_pk_ek integer  ,
	CONSTRAINT pk_examination_list_detail PRIMARY KEY ( i_examination_list_detail_pk )
 );
ALTER TABLE "public".examination_list_detail ADD COLUMN i_student_information_pk integer;
ALTER TABLE "public".examination_list_detail ADD CONSTRAINT fk_examination_list_detail_to_student_information FOREIGN KEY ( i_student_information_pk ) REFERENCES "public".student_information( i_student_information_pk );
CREATE INDEX idx_examination_list_detail ON "public".examination_list_detail ( i_examination_list_pk );

CREATE TABLE "public".examination_result ( 
	i_examination_result_pk integer  NOT NULL,
	i_test_information_pk integer  ,
	i_student_information_pk integer  ,
	f_examination_result_score float8  ,
	i_examination_result_num_answer_true integer  ,
	i_examination_result_pk_ek integer  ,
	CONSTRAINT pk_examination_result PRIMARY KEY ( i_examination_result_pk )
 );

CREATE INDEX idx_examination_result ON "public".examination_result ( i_student_information_pk );

CREATE INDEX idx_examination_result_0 ON "public".examination_result ( i_test_information_pk );

CREATE TABLE "public".question_information ( 
	i_question_information_pk integer  NOT NULL,
	i_teacher_information_pk integer  ,
	i_subject_information_pk integer  ,
	i_question_level_information integer  ,
	str_question_content_information varchar(1000)  NOT NULL,
	str_answer_1         varchar(500)  ,
	str_answer_2         varchar(500)  ,
	str_answer_3         varchar(500)  ,
	str_answer_4         varchar(500)  ,
	str_answer_5         varchar(500)  ,
	str_answer_true      varchar(500)  NOT NULL,
	i_question_information_pk_ek integer  ,
	CONSTRAINT pk_question_information PRIMARY KEY ( i_question_information_pk )
 );

CREATE INDEX idx_question_information ON "public".question_information ( i_teacher_information_pk );

CREATE INDEX idx_question_information_subject ON "public".question_information ( i_subject_information_pk );

CREATE INDEX idx_question_information_level ON "public".question_information ( i_question_level_information );

CREATE TABLE "public".test_detail_information ( 
	i_test_detail_information_pk integer  NOT NULL,
	i_test_information_pk integer  ,
	i_question_information_pk integer  ,
	i_test_detail_information_pk_ek integer  ,
	CONSTRAINT pk_test_detail_information PRIMARY KEY ( i_test_detail_information_pk )
 );
 CREATE TABLE "public".seiUser ( 
	user_id varchar(50) NOT NULL ,
	"password" varchar(100) NOT NULL,
	top_menu varchar(5) default 'ADM' ,
	i_student_information_pk integer,
	i_teacher_information_pk integer,
	CONSTRAINT pk_user_id PRIMARY KEY ( user_id )
);
CREATE INDEX idx_seiUser ON "public".seiUser ( user_id );
CREATE INDEX idx_seiUser_student ON "public".seiUser ( i_student_information_pk );
CREATE INDEX idx_seiUser_teacher ON "public".seiUser ( i_teacher_information_pk );
ALTER TABLE "public".seiUser ADD CONSTRAINT fk_seiUser_to_student FOREIGN KEY ( i_student_information_pk ) 
REFERENCES "public".student_information( i_student_information_pk );
ALTER TABLE "public".seiUser ADD CONSTRAINT fk_seiUser_to_teacher FOREIGN KEY ( i_teacher_information_pk ) 
REFERENCES "public".teacher_information( i_teacher_information_pk );

CREATE INDEX idx_test_detail_information_question ON "public".test_detail_information ( i_question_information_pk );

CREATE INDEX idx_test_detail_information_to_test ON "public".test_detail_information ( i_test_information_pk );

ALTER TABLE "public".examination_list ADD CONSTRAINT fk_examination_list_to_examination_room FOREIGN KEY ( i_examination_room_pk ) REFERENCES "public".examination_room( i_examination_room_pk ) ON DELETE SET NULL;

ALTER TABLE "public".examination_list ADD CONSTRAINT fk_examination_list_to_subject FOREIGN KEY ( i_subject_information_pk ) REFERENCES "public".subject_information( i_subject_information_pk );

ALTER TABLE "public".examination_list ADD CONSTRAINT fk_examination_list_to_teacher FOREIGN KEY ( i_teacher_information_pk ) REFERENCES "public".teacher_information( i_teacher_information_pk );

ALTER TABLE "public".examination_list_detail ADD CONSTRAINT fk_examination_list_detail FOREIGN KEY ( i_examination_list_pk ) REFERENCES "public".examination_list( i_examination_list_pk ) ON DELETE SET NULL;

ALTER TABLE "public".examination_result ADD CONSTRAINT fk_examination_result_to_student FOREIGN KEY ( i_student_information_pk ) REFERENCES "public".student_information( i_student_information_pk );

ALTER TABLE "public".examination_result ADD CONSTRAINT fk_examination_result_to_test FOREIGN KEY ( i_test_information_pk ) REFERENCES "public".test_information( i_test_information_pk );

ALTER TABLE "public".question_information ADD CONSTRAINT fk_question_information_to_teacher FOREIGN KEY ( i_teacher_information_pk ) REFERENCES "public".teacher_information( i_teacher_information_pk );

ALTER TABLE "public".question_information ADD CONSTRAINT fk_question_information_to_subject FOREIGN KEY ( i_subject_information_pk ) REFERENCES "public".subject_information( i_subject_information_pk );

ALTER TABLE "public".student_information ADD CONSTRAINT fk_student_information FOREIGN KEY ( i_faculty_information_pk ) REFERENCES "public".faculty_information( i_faculty_information_pk ) ON DELETE SET NULL;

ALTER TABLE "public".teacher_information ADD CONSTRAINT fk_teacher_information FOREIGN KEY ( i_faculty_information_pk ) REFERENCES "public".faculty_information( i_faculty_information_pk );

ALTER TABLE "public".test_detail_information ADD CONSTRAINT fk_test_detail_information_to_question FOREIGN KEY ( i_question_information_pk ) REFERENCES "public".question_information( i_question_information_pk );

ALTER TABLE "public".test_detail_information ADD CONSTRAINT fk_test_detail_information_to_test FOREIGN KEY ( i_test_information_pk ) REFERENCES "public".test_information( i_test_information_pk );

ALTER TABLE "public".test_information ADD CONSTRAINT fk_test_information FOREIGN KEY ( i_rate_of_difficulty_pk ) REFERENCES "public".rate_of_difficulty( i_rate_of_difficulty_pk );

