CREATE TABLE user_test(

id serial primary key,
email text not null unique,
hashed_password text not null,
createdAt DATE,
updatedAt DATE

);