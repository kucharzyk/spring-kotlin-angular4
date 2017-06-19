
    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists permissions cascade;

    drop table if exists roles cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_roles cascade;

    drop sequence if exists hibernate_sequence;

    drop sequence if exists sequence_jwt_tokens;

    drop sequence if exists sequence_permissions;

    drop sequence if exists sequence_roles;

    drop sequence if exists sequence_users;
create sequence hibernate_sequence start 1 increment 1;
create sequence sequence_jwt_tokens start 1 increment 1;
create sequence sequence_permissions start 1 increment 1;
create sequence sequence_roles start 1 increment 1;
create sequence sequence_users start 1 increment 1;

    create table association_value_entry (
       id int8 not null,
        association_key varchar(255) not null,
        association_value varchar(255),
        saga_id varchar(255) not null,
        saga_type varchar(255),
        primary key (id)
    );

    create table domain_event_entry (
       global_index int8 not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255),
        primary key (global_index)
    );

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

    create table saga_entry (
       saga_id varchar(255) not null,
        revision varchar(255),
        saga_type varchar(255),
        serialized_saga oid,
        primary key (saga_id)
    );

    create table snapshot_event_entry (
       aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255) not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        primary key (aggregate_identifier, sequence_number, type)
    );

    create table token_entry (
       processor_name varchar(255) not null,
        segment int4 not null,
        owner varchar(255),
        timestamp varchar(255) not null,
        token oid,
        token_type varchar(255),
        primary key (processor_name, segment)
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
        password varchar(120) not null,
        username varchar(250) not null,
        primary key (id)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );
create index IDXs2yi8bobx8dd4ee6t63dufs6d on association_value_entry (saga_id, association_key);

    alter table domain_event_entry 
       add constraint UK8s1f994p4la2ipb13me2xqm1w unique (aggregate_identifier, sequence_number);

    alter table domain_event_entry 
       add constraint UK_fwe6lsa8bfo6hyas6ud3m8c7x unique (event_identifier);

    alter table permissions 
       add constraint UK_pnvtwliis6p05pn6i3ndjrqt2 unique (name);

    alter table roles 
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

    alter table snapshot_event_entry 
       add constraint UK_e1uucjseo68gopmnd0vgdl44h unique (event_identifier);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table jwt_tokens 
       add constraint FKhy6n4wirmw0ryw2wdmy9cx2mn 
       foreign key (user_id) 
       references users;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

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

    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists permissions cascade;

    drop table if exists roles cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_roles cascade;

    drop sequence if exists hibernate_sequence;

    drop sequence if exists sequence_jwt_tokens;

    drop sequence if exists sequence_permissions;

    drop sequence if exists sequence_roles;

    drop sequence if exists sequence_users;
create sequence hibernate_sequence start 1 increment 1;
create sequence sequence_jwt_tokens start 1 increment 1;
create sequence sequence_permissions start 1 increment 1;
create sequence sequence_roles start 1 increment 1;
create sequence sequence_users start 1 increment 1;

    create table association_value_entry (
       id int8 not null,
        association_key varchar(255) not null,
        association_value varchar(255),
        saga_id varchar(255) not null,
        saga_type varchar(255),
        primary key (id)
    );

    create table domain_event_entry (
       global_index int8 not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255),
        primary key (global_index)
    );

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

    create table saga_entry (
       saga_id varchar(255) not null,
        revision varchar(255),
        saga_type varchar(255),
        serialized_saga oid,
        primary key (saga_id)
    );

    create table snapshot_event_entry (
       aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255) not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        primary key (aggregate_identifier, sequence_number, type)
    );

    create table token_entry (
       processor_name varchar(255) not null,
        segment int4 not null,
        owner varchar(255),
        timestamp varchar(255) not null,
        token oid,
        token_type varchar(255),
        primary key (processor_name, segment)
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
        password varchar(120) not null,
        username varchar(250) not null,
        primary key (id)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );
create index IDXs2yi8bobx8dd4ee6t63dufs6d on association_value_entry (saga_id, association_key);

    alter table domain_event_entry 
       add constraint UK8s1f994p4la2ipb13me2xqm1w unique (aggregate_identifier, sequence_number);

    alter table domain_event_entry 
       add constraint UK_fwe6lsa8bfo6hyas6ud3m8c7x unique (event_identifier);

    alter table permissions 
       add constraint UK_pnvtwliis6p05pn6i3ndjrqt2 unique (name);

    alter table roles 
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

    alter table snapshot_event_entry 
       add constraint UK_e1uucjseo68gopmnd0vgdl44h unique (event_identifier);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table jwt_tokens 
       add constraint FKhy6n4wirmw0ryw2wdmy9cx2mn 
       foreign key (user_id) 
       references users;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

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

    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists permissions cascade;

    drop table if exists roles cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_roles cascade;

    drop sequence if exists hibernate_sequence;

    drop sequence if exists sequence_jwt_tokens;

    drop sequence if exists sequence_permissions;

    drop sequence if exists sequence_roles;

    drop sequence if exists sequence_users;
create sequence hibernate_sequence start 1 increment 1;
create sequence sequence_jwt_tokens start 1 increment 1;
create sequence sequence_permissions start 1 increment 1;
create sequence sequence_roles start 1 increment 1;
create sequence sequence_users start 1 increment 1;

    create table association_value_entry (
       id int8 not null,
        association_key varchar(255) not null,
        association_value varchar(255),
        saga_id varchar(255) not null,
        saga_type varchar(255),
        primary key (id)
    );

    create table domain_event_entry (
       global_index int8 not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255),
        primary key (global_index)
    );

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

    create table saga_entry (
       saga_id varchar(255) not null,
        revision varchar(255),
        saga_type varchar(255),
        serialized_saga oid,
        primary key (saga_id)
    );

    create table snapshot_event_entry (
       aggregate_identifier varchar(255) not null,
        sequence_number int8 not null,
        type varchar(255) not null,
        event_identifier varchar(255) not null,
        meta_data oid,
        payload oid not null,
        payload_revision varchar(255),
        payload_type varchar(255) not null,
        time_stamp varchar(255) not null,
        primary key (aggregate_identifier, sequence_number, type)
    );

    create table token_entry (
       processor_name varchar(255) not null,
        segment int4 not null,
        owner varchar(255),
        timestamp varchar(255) not null,
        token oid,
        token_type varchar(255),
        primary key (processor_name, segment)
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
        password varchar(120) not null,
        username varchar(250) not null,
        primary key (id)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );
create index IDXs2yi8bobx8dd4ee6t63dufs6d on association_value_entry (saga_id, association_key);

    alter table domain_event_entry 
       add constraint UK8s1f994p4la2ipb13me2xqm1w unique (aggregate_identifier, sequence_number);

    alter table domain_event_entry 
       add constraint UK_fwe6lsa8bfo6hyas6ud3m8c7x unique (event_identifier);

    alter table permissions 
       add constraint UK_pnvtwliis6p05pn6i3ndjrqt2 unique (name);

    alter table roles 
       add constraint UK_ofx66keruapi6vyqpv6f2or37 unique (name);

    alter table snapshot_event_entry 
       add constraint UK_e1uucjseo68gopmnd0vgdl44h unique (event_identifier);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table jwt_tokens 
       add constraint FKhy6n4wirmw0ryw2wdmy9cx2mn 
       foreign key (user_id) 
       references users;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

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
