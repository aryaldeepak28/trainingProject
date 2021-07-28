create table users(
	user_id int primary key NOT NULL AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    phone_no varchar(13) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    address varchar(100),
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    password varchar(100) NOT NULL,
    upload_photo varchar(100),
    index(user_id)
);

show tables;
desc users;

insert into users(name,phone_no,email,address,password,upload_photo)
values('Ankit','4578008234','ankit@gmail.com','noida','ankit','img.jpg');
insert into users(name,phone_no,email,address,password,upload_photo)
values('Rahul','9586234712','rahul@gmail.com','banglore','rahul','img1.jpg');
insert into users(name,phone_no,email,address,password,upload_photo)
values('gouthami',8524379162,'gouthami@gmail.com','anantapur','gouthami','img2.jpg');
insert into users(name,phone_no,email,address,password,upload_photo)
values('iswarya',9256279162,'iswarya@gmail.com','nellore','iswarya','img3.jpg');
insert into users(name,phone_no,email,address,password,upload_photo)
values('harshitha',7456279162,'harshitha@gmail.com','vijayawada','harshitha','img4.jpg');

select * from users;