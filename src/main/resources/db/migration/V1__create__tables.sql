create schema dbo;

CREATE TABLE dbo.tbluser(

       user_id int auto_increment primary key,

       user_registration_number varchar(10) NOT NULL unique,

       user_first_name varchar(50) NOT NULL,

       user_last_name varchar(50) NOT NULL,

       role_txt varchar(50) NOT NULL,

       branch_name varchar(50) NOT NULL ,

       email varchar(100) NOT NULL

);

 

 

CREATE TABLE dbo.tblnotification(

       notification_id int auto_increment primary key,

       notification_summary varchar(100) NOT NULL,
       
       notification_txt varchar(1000) NOT NULL,

       created_by int not null,

       created_timestamp datetime not null,

       CONSTRAINT FK_notification_user_id FOREIGN KEY (created_by)    

    REFERENCES tbluser (user_id) 

);

 

 

CREATE TABLE dbo.tbllimit(

       limit_id int auto_increment primary key,

       user_id int NOT NULL unique,

       created_by int not null,

       created_timestamp datetime not null,

       CONSTRAINT FK_limit_user_id FOREIGN KEY (user_id) REFERENCES tbluser (user_id)  ,

       CONSTRAINT FK_limit_user_id1 FOREIGN KEY (created_by)  REFERENCES tbluser (user_id) 

);

 

 

CREATE TABLE dbo.tblissue(

       issue_id int auto_increment primary key,

       issue_txt varchar(1000) NOT NULL unique,

       created_by int not null,

       created_timestamp datetime not null,

       CONSTRAINT FK_issue_user_id FOREIGN KEY (created_by)    

    REFERENCES tbluser (user_id) 

);

 

 

CREATE TABLE dbo.tblcomment(

       comment_id int auto_increment primary key,

       comment_txt varchar(1000) NOT NULL,

       issue_id int NOT NULL,

       created_by int not null,

       created_timestamp datetime not null,

       CONSTRAINT FK_comment_issue_id FOREIGN KEY (issue_id)    

    REFERENCES tblissue (issue_id)  ,

       CONSTRAINT FK_comment_user_id FOREIGN KEY (created_by)    

    REFERENCES tbluser (user_id) 

);

 

CREATE TABLE dbo.tbllike(

       like_id int auto_increment primary key,

       issue_id int NOT NULL,

       created_by int not null,

       created_timestamp datetime not null,

       CONSTRAINT FK_like_issue_id FOREIGN KEY (issue_id)    

    REFERENCES tblissue (issue_id)  ,

       CONSTRAINT FK_like_user_id FOREIGN KEY (created_by)    

    REFERENCES tbluser (user_id) 

);

 

CREATE TABLE dbo.tblogin(

       login_id int auto_increment primary key,

       user_registration_number varchar(10) NOT NULL unique,

       user_password varchar(16) NOT NULL

);

 

insert into dbo.tbluser(user_registration_number,user_first_name,user_last_name,role_txt,branch_name,email)

                                  values ('18CSE150','studfirst','studlast','student','CSE','abc@gmail.com');

 

insert into dbo.tbluser(user_registration_number,user_first_name,user_last_name,role_txt,branch_name,email)

                                  values ('18DIR001','dirfirst','dirlast','Director','Admin','admin@gmail.com');

 

 

insert into dbo.tblogin(user_registration_number,user_password)

                                  values ('18CSE150','stud1234');

 

insert into dbo.tblogin(user_registration_number,user_password)

                                  values ('18DIR001','dir12345');
