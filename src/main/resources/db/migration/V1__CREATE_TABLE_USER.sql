create table users (
  id bigserial primary key,
  username varchar(100) not null unique,
  password varchar(100) not null,
  role varchar(100)
)



