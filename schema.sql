
    alter table jwt_tokens 
        drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table roles_permissions 
        drop constraint FKeqt383nibym26cjj8we4uar8h;

    alter table roles_permissions 
        drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table users_roles 
        drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
        drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    drop table if exists jwt_tokens cascade;

    drop table if exists permissions cascade;

    drop table if exists roles cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists users cascade;

    drop table if exists users_roles cascade;

    drop sequence sequence_jwt_tokens;

    drop sequence sequence_permissions;

    drop sequence sequence_roles;

    drop sequence sequence_users;

    create sequence sequence_jwt_tokens start 1 increment 1;

    create sequence sequence_permissions start 1 increment 1;

    create sequence sequence_roles start 1 increment 1;

    create sequence sequence_users start 1 increment 1;

    create table jwt_tokens (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        active boolean not null,
        expiration_date timestamp not null,
        invalidated boolean not null,
        invalidation_date timestamp,
        ip_adress varchar(39) not null,
        user_id int8,
        primary key (id)
    );

    create table permissions (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles_permissions (
        role_id int8 not null,
        permissions_id int8 not null,
        primary key (role_id, permissions_id)
    );

    create table users (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        email varchar(250) not null,
        enabled boolean not null,
        expired boolean not null,
        first_name varchar(120) not null,
        last_name varchar(120) not null,
        locked boolean not null,
        password varchar(64) not null,
        username varchar(250) not null,
        primary key (id)
    );

    create table users_roles (
        user_id int8 not null,
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

    alter table jwt_tokens 
        add constraint FKhy6n4wirmw0ryw2wdmy9cx2mn 
        foreign key (user_id) 
        references users;

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
