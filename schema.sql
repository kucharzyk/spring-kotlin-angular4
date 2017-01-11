ALTER TABLE jwt_tokens
  DROP CONSTRAINT FKhy6n4wirmw0ryw2wdmy9cx2mn;

alter table roles_permissions
  drop constraint FKeqt383nibym26cjj8we4uar8h;

alter table roles_permissions
  drop constraint FKqi9odri6c1o81vjox54eedwyh;

alter table users_roles
  drop constraint FKa62j07k5mhgifpp955h37ponj;

alter table users_roles
  drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

DROP TABLE IF EXISTS jwt_tokens CASCADE;

drop table if exists permissions cascade;

drop table if exists roles cascade;

drop table if exists roles_permissions cascade;

drop table if exists users cascade;

drop table if exists users_roles cascade;

DROP SEQUENCE sequence_jwt_tokens;

DROP SEQUENCE sequence_permissions;

DROP SEQUENCE sequence_roles;

DROP SEQUENCE sequence_users;

CREATE SEQUENCE sequence_jwt_tokens START 1 INCREMENT 1;

CREATE SEQUENCE sequence_permissions START 1 INCREMENT 1;

CREATE SEQUENCE sequence_roles START 1 INCREMENT 1;

CREATE SEQUENCE sequence_users START 1 INCREMENT 1;

CREATE TABLE jwt_tokens (
  id                INT8         NOT NULL,
  uuid              VARCHAR(255) NOT NULL,
  version           INT8,
  active            BOOLEAN      NOT NULL,
  expiration_date   TIMESTAMP    NOT NULL,
  invalidated       BOOLEAN      NOT NULL,
  invalidation_date TIMESTAMP,
  ip_adress         VARCHAR(39)  NOT NULL,
  user_id           INT8,
  PRIMARY KEY (id)
);

create table permissions (
  id      int8         not null,
  uuid    varchar(255) not null,
  version int8,
  name    varchar(64)  not null,
  primary key (id)
);

create table roles (
  id      int8         not null,
  uuid    varchar(255) not null,
  version int8,
  name    varchar(64)  not null,
  primary key (id)
);

create table roles_permissions (
  role_id        int8 not null,
  permissions_id int8 not null,
  primary key (role_id, permissions_id)
);

create table users (
  id         int8         not null,
  uuid       varchar(255) not null,
  version    int8,
  email      VARCHAR(250) NOT NULL,
  enabled    boolean      not null,
  expired    boolean      not null,
  first_name VARCHAR(120) NOT NULL,
  last_name  VARCHAR(120) NOT NULL,
  locked     boolean      not null,
  password   varchar(64)  not null,
  username   VARCHAR(250) NOT NULL,
  primary key (id)
);

create table users_roles (
  user_id  int8 not null,
  roles_id int8 not null,
  primary key (user_id, roles_id)
);

alter table permissions
  add constraint UK_pnvtwliis6p05pn6i3ndjrqt2 unique (name);

alter table roles
  add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

alter table roles_permissions
  add constraint UK_oll9subcln0cdjt31bp72a3uv unique (permissions_id);

alter table users
  add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

alter table users_roles
  add constraint UK_60loxav507l5mreo05v0im1lq unique (roles_id);

ALTER TABLE jwt_tokens
  ADD CONSTRAINT FKhy6n4wirmw0ryw2wdmy9cx2mn
FOREIGN KEY (user_id)
REFERENCES users;

alter table roles_permissions
  add constraint FKeqt383nibym26cjj8we4uar8h
foreign key (permissions_id)
references roles;

alter table roles_permissions
  add constraint FKqi9odri6c1o81vjox54eedwyh
foreign key (role_id)
references roles;

alter table users_roles
  add constraint FKa62j07k5mhgifpp955h37ponj
foreign key (roles_id)
references roles;

alter table users_roles
  add constraint FK2o0jvgh89lemvvo17cbqvdxaa
foreign key (user_id)
references users;
