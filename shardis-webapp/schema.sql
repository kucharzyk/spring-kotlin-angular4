
    alter table jwt_tokens 
        drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table jwt_tokens_aud 
        drop constraint FK6jp64i8dvuahfik6kui8prbjd;

    alter table permissions_aud 
        drop constraint FKbcjh1knyfnk51nv2cllrct4iw;

    alter table roles_aud 
        drop constraint FKt0mnl3rej2p0h9gxnbalf2kdd;

    alter table roles_permissions 
        drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
        drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table roles_permissions_aud 
        drop constraint FKnofx22xg9kko3i1geh4jikive;

    alter table users_aud 
        drop constraint FKc4vk4tui2la36415jpgm9leoq;

    alter table users_roles 
        drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
        drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    alter table users_roles_aud 
        drop constraint FKktxqr55ntd0j2i228uj8sq6j9;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists jwt_tokens_aud cascade;

    drop table if exists permissions cascade;

    drop table if exists permissions_aud cascade;

    drop table if exists revinfo cascade;

    drop table if exists roles cascade;

    drop table if exists roles_aud cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists roles_permissions_aud cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_aud cascade;

    drop table if exists users_roles cascade;

    drop table if exists users_roles_aud cascade;

    drop sequence hibernate_sequence;

    drop sequence sequence_jwt_tokens;

    drop sequence sequence_permissions;

    drop sequence sequence_roles;

    drop sequence sequence_users;

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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        active boolean not null,
        expiration_date timestamp not null,
        invalidated boolean not null,
        invalidation_date timestamp,
        ip_adress varchar(39) not null,
        user_id int8,
        primary key (id)
    );

    create table jwt_tokens_aud (
        id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        active boolean,
        expiration_date timestamp,
        invalidated boolean,
        invalidation_date timestamp,
        ip_adress varchar(39),
        user_id int8,
        primary key (id, rev)
    );

    create table permissions (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table permissions_aud (
        id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table revinfo (
        rev int4 not null,
        revtstmp int8,
        primary key (rev)
    );

    create table roles (
        id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles_aud (
        id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table roles_permissions (
        role_id int8 not null,
        permissions_id int8 not null,
        primary key (role_id, permissions_id)
    );

    create table roles_permissions_aud (
        rev int4 not null,
        role_id int8 not null,
        permissions_id int8 not null,
        revtype int2,
        primary key (rev, role_id, permissions_id)
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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
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

    create table users_aud (
        id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        email varchar(250),
        enabled boolean,
        expired boolean,
        first_name varchar(120),
        last_name varchar(120),
        locked boolean,
        password varchar(120),
        username varchar(250),
        primary key (id, rev)
    );

    create table users_roles (
        user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );

    create table users_roles_aud (
        rev int4 not null,
        user_id int8 not null,
        roles_id int8 not null,
        revtype int2,
        primary key (rev, user_id, roles_id)
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

    alter table jwt_tokens_aud 
        add constraint FK6jp64i8dvuahfik6kui8prbjd 
        foreign key (rev) 
        references revinfo;

    alter table permissions_aud 
        add constraint FKbcjh1knyfnk51nv2cllrct4iw 
        foreign key (rev) 
        references revinfo;

    alter table roles_aud 
        add constraint FKt0mnl3rej2p0h9gxnbalf2kdd 
        foreign key (rev) 
        references revinfo;

    alter table roles_permissions 
        add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
        foreign key (permissions_id) 
        references permissions;

    alter table roles_permissions 
        add constraint FKqi9odri6c1o81vjox54eedwyh 
        foreign key (role_id) 
        references roles;

    alter table roles_permissions_aud 
        add constraint FKnofx22xg9kko3i1geh4jikive 
        foreign key (rev) 
        references revinfo;

    alter table users_aud 
        add constraint FKc4vk4tui2la36415jpgm9leoq 
        foreign key (rev) 
        references revinfo;

    alter table users_roles 
        add constraint FKa62j07k5mhgifpp955h37ponj 
        foreign key (roles_id) 
        references roles;

    alter table users_roles 
        add constraint FK2o0jvgh89lemvvo17cbqvdxaa 
        foreign key (user_id) 
        references users;

    alter table users_roles_aud 
        add constraint FKktxqr55ntd0j2i228uj8sq6j9 
        foreign key (rev) 
        references revinfo;

    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table jwt_tokens_aud 
       drop constraint FK6jp64i8dvuahfik6kui8prbjd;

    alter table permissions_aud 
       drop constraint FKbcjh1knyfnk51nv2cllrct4iw;

    alter table roles_aud 
       drop constraint FKt0mnl3rej2p0h9gxnbalf2kdd;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table roles_permissions_aud 
       drop constraint FKnofx22xg9kko3i1geh4jikive;

    alter table users_aud 
       drop constraint FKc4vk4tui2la36415jpgm9leoq;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    alter table users_roles_aud 
       drop constraint FKktxqr55ntd0j2i228uj8sq6j9;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists jwt_tokens_aud cascade;

    drop table if exists permissions cascade;

    drop table if exists permissions_aud cascade;

    drop table if exists revinfo cascade;

    drop table if exists roles cascade;

    drop table if exists roles_aud cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists roles_permissions_aud cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_aud cascade;

    drop table if exists users_roles cascade;

    drop table if exists users_roles_aud cascade;

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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        active boolean not null,
        expiration_date timestamp not null,
        invalidated boolean not null,
        invalidation_date timestamp,
        ip_adress varchar(39) not null,
        user_id int8,
        primary key (id)
    );

    create table jwt_tokens_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        active boolean,
        expiration_date timestamp,
        invalidated boolean,
        invalidation_date timestamp,
        ip_adress varchar(39),
        user_id int8,
        primary key (id, rev)
    );

    create table permissions (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table permissions_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table revinfo (
       rev int4 not null,
        revtstmp int8,
        primary key (rev)
    );

    create table roles (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table roles_permissions (
       role_id int8 not null,
        permissions_id int8 not null,
        primary key (role_id, permissions_id)
    );

    create table roles_permissions_aud (
       rev int4 not null,
        role_id int8 not null,
        permissions_id int8 not null,
        revtype int2,
        primary key (rev, role_id, permissions_id)
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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
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

    create table users_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        email varchar(250),
        enabled boolean,
        expired boolean,
        first_name varchar(120),
        last_name varchar(120),
        locked boolean,
        password varchar(120),
        username varchar(250),
        primary key (id, rev)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );

    create table users_roles_aud (
       rev int4 not null,
        user_id int8 not null,
        roles_id int8 not null,
        revtype int2,
        primary key (rev, user_id, roles_id)
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

    alter table jwt_tokens_aud 
       add constraint FK6jp64i8dvuahfik6kui8prbjd 
       foreign key (rev) 
       references revinfo;

    alter table permissions_aud 
       add constraint FKbcjh1knyfnk51nv2cllrct4iw 
       foreign key (rev) 
       references revinfo;

    alter table roles_aud 
       add constraint FKt0mnl3rej2p0h9gxnbalf2kdd 
       foreign key (rev) 
       references revinfo;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

    alter table roles_permissions 
       add constraint FKqi9odri6c1o81vjox54eedwyh 
       foreign key (role_id) 
       references roles;

    alter table roles_permissions_aud 
       add constraint FKnofx22xg9kko3i1geh4jikive 
       foreign key (rev) 
       references revinfo;

    alter table users_aud 
       add constraint FKc4vk4tui2la36415jpgm9leoq 
       foreign key (rev) 
       references revinfo;

    alter table users_roles 
       add constraint FKa62j07k5mhgifpp955h37ponj 
       foreign key (roles_id) 
       references roles;

    alter table users_roles 
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa 
       foreign key (user_id) 
       references users;

    alter table users_roles_aud 
       add constraint FKktxqr55ntd0j2i228uj8sq6j9 
       foreign key (rev) 
       references revinfo;

    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table jwt_tokens_aud 
       drop constraint FK6jp64i8dvuahfik6kui8prbjd;

    alter table permissions_aud 
       drop constraint FKbcjh1knyfnk51nv2cllrct4iw;

    alter table roles_aud 
       drop constraint FKt0mnl3rej2p0h9gxnbalf2kdd;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table roles_permissions_aud 
       drop constraint FKnofx22xg9kko3i1geh4jikive;

    alter table users_aud 
       drop constraint FKc4vk4tui2la36415jpgm9leoq;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    alter table users_roles_aud 
       drop constraint FKktxqr55ntd0j2i228uj8sq6j9;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists jwt_tokens_aud cascade;

    drop table if exists permissions cascade;

    drop table if exists permissions_aud cascade;

    drop table if exists revinfo cascade;

    drop table if exists roles cascade;

    drop table if exists roles_aud cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists roles_permissions_aud cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_aud cascade;

    drop table if exists users_roles cascade;

    drop table if exists users_roles_aud cascade;

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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        active boolean not null,
        expiration_date timestamp not null,
        invalidated boolean not null,
        invalidation_date timestamp,
        ip_adress varchar(39) not null,
        user_id int8,
        primary key (id)
    );

    create table jwt_tokens_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        active boolean,
        expiration_date timestamp,
        invalidated boolean,
        invalidation_date timestamp,
        ip_adress varchar(39),
        user_id int8,
        primary key (id, rev)
    );

    create table permissions (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table permissions_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table revinfo (
       rev int4 not null,
        revtstmp int8,
        primary key (rev)
    );

    create table roles (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table roles_permissions (
       role_id int8 not null,
        permissions_id int8 not null,
        primary key (role_id, permissions_id)
    );

    create table roles_permissions_aud (
       rev int4 not null,
        role_id int8 not null,
        permissions_id int8 not null,
        revtype int2,
        primary key (rev, role_id, permissions_id)
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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
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

    create table users_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        email varchar(250),
        enabled boolean,
        expired boolean,
        first_name varchar(120),
        last_name varchar(120),
        locked boolean,
        password varchar(120),
        username varchar(250),
        primary key (id, rev)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );

    create table users_roles_aud (
       rev int4 not null,
        user_id int8 not null,
        roles_id int8 not null,
        revtype int2,
        primary key (rev, user_id, roles_id)
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

    alter table jwt_tokens_aud 
       add constraint FK6jp64i8dvuahfik6kui8prbjd 
       foreign key (rev) 
       references revinfo;

    alter table permissions_aud 
       add constraint FKbcjh1knyfnk51nv2cllrct4iw 
       foreign key (rev) 
       references revinfo;

    alter table roles_aud 
       add constraint FKt0mnl3rej2p0h9gxnbalf2kdd 
       foreign key (rev) 
       references revinfo;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

    alter table roles_permissions 
       add constraint FKqi9odri6c1o81vjox54eedwyh 
       foreign key (role_id) 
       references roles;

    alter table roles_permissions_aud 
       add constraint FKnofx22xg9kko3i1geh4jikive 
       foreign key (rev) 
       references revinfo;

    alter table users_aud 
       add constraint FKc4vk4tui2la36415jpgm9leoq 
       foreign key (rev) 
       references revinfo;

    alter table users_roles 
       add constraint FKa62j07k5mhgifpp955h37ponj 
       foreign key (roles_id) 
       references roles;

    alter table users_roles 
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa 
       foreign key (user_id) 
       references users;

    alter table users_roles_aud 
       add constraint FKktxqr55ntd0j2i228uj8sq6j9 
       foreign key (rev) 
       references revinfo;

    alter table jwt_tokens 
       drop constraint FKhy6n4wirmw0ryw2wdmy9cx2mn;

    alter table jwt_tokens_aud 
       drop constraint FK6jp64i8dvuahfik6kui8prbjd;

    alter table permissions_aud 
       drop constraint FKbcjh1knyfnk51nv2cllrct4iw;

    alter table roles_aud 
       drop constraint FKt0mnl3rej2p0h9gxnbalf2kdd;

    alter table roles_permissions 
       drop constraint FK570wuy6sacdnrw8wdqjfh7j0q;

    alter table roles_permissions 
       drop constraint FKqi9odri6c1o81vjox54eedwyh;

    alter table roles_permissions_aud 
       drop constraint FKnofx22xg9kko3i1geh4jikive;

    alter table users_aud 
       drop constraint FKc4vk4tui2la36415jpgm9leoq;

    alter table users_roles 
       drop constraint FKa62j07k5mhgifpp955h37ponj;

    alter table users_roles 
       drop constraint FK2o0jvgh89lemvvo17cbqvdxaa;

    alter table users_roles_aud 
       drop constraint FKktxqr55ntd0j2i228uj8sq6j9;

    drop table if exists association_value_entry cascade;

    drop table if exists domain_event_entry cascade;

    drop table if exists jwt_tokens cascade;

    drop table if exists jwt_tokens_aud cascade;

    drop table if exists permissions cascade;

    drop table if exists permissions_aud cascade;

    drop table if exists revinfo cascade;

    drop table if exists roles cascade;

    drop table if exists roles_aud cascade;

    drop table if exists roles_permissions cascade;

    drop table if exists roles_permissions_aud cascade;

    drop table if exists saga_entry cascade;

    drop table if exists snapshot_event_entry cascade;

    drop table if exists token_entry cascade;

    drop table if exists users cascade;

    drop table if exists users_aud cascade;

    drop table if exists users_roles cascade;

    drop table if exists users_roles_aud cascade;

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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        active boolean not null,
        expiration_date timestamp not null,
        invalidated boolean not null,
        invalidation_date timestamp,
        ip_adress varchar(39) not null,
        user_id int8,
        primary key (id)
    );

    create table jwt_tokens_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        active boolean,
        expiration_date timestamp,
        invalidated boolean,
        invalidation_date timestamp,
        ip_adress varchar(39),
        user_id int8,
        primary key (id, rev)
    );

    create table permissions (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table permissions_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table revinfo (
       rev int4 not null,
        revtstmp int8,
        primary key (rev)
    );

    create table roles (
       id int8 not null,
        uuid varchar(255) not null,
        version int8,
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
        name varchar(64) not null,
        primary key (id)
    );

    create table roles_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        name varchar(64),
        primary key (id, rev)
    );

    create table roles_permissions (
       role_id int8 not null,
        permissions_id int8 not null,
        primary key (role_id, permissions_id)
    );

    create table roles_permissions_aud (
       rev int4 not null,
        role_id int8 not null,
        permissions_id int8 not null,
        revtype int2,
        primary key (rev, role_id, permissions_id)
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
        created_by int8,
        created_date timestamp not null,
        updated_by int8,
        updated_date timestamp,
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

    create table users_aud (
       id int8 not null,
        rev int4 not null,
        revtype int2,
        uuid varchar(255),
        created_by int8,
        created_date timestamp,
        updated_by int8,
        updated_date timestamp,
        email varchar(250),
        enabled boolean,
        expired boolean,
        first_name varchar(120),
        last_name varchar(120),
        locked boolean,
        password varchar(120),
        username varchar(250),
        primary key (id, rev)
    );

    create table users_roles (
       user_id int8 not null,
        roles_id int8 not null,
        primary key (user_id, roles_id)
    );

    create table users_roles_aud (
       rev int4 not null,
        user_id int8 not null,
        roles_id int8 not null,
        revtype int2,
        primary key (rev, user_id, roles_id)
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

    alter table jwt_tokens_aud 
       add constraint FK6jp64i8dvuahfik6kui8prbjd 
       foreign key (rev) 
       references revinfo;

    alter table permissions_aud 
       add constraint FKbcjh1knyfnk51nv2cllrct4iw 
       foreign key (rev) 
       references revinfo;

    alter table roles_aud 
       add constraint FKt0mnl3rej2p0h9gxnbalf2kdd 
       foreign key (rev) 
       references revinfo;

    alter table roles_permissions 
       add constraint FK570wuy6sacdnrw8wdqjfh7j0q 
       foreign key (permissions_id) 
       references permissions;

    alter table roles_permissions 
       add constraint FKqi9odri6c1o81vjox54eedwyh 
       foreign key (role_id) 
       references roles;

    alter table roles_permissions_aud 
       add constraint FKnofx22xg9kko3i1geh4jikive 
       foreign key (rev) 
       references revinfo;

    alter table users_aud 
       add constraint FKc4vk4tui2la36415jpgm9leoq 
       foreign key (rev) 
       references revinfo;

    alter table users_roles 
       add constraint FKa62j07k5mhgifpp955h37ponj 
       foreign key (roles_id) 
       references roles;

    alter table users_roles 
       add constraint FK2o0jvgh89lemvvo17cbqvdxaa 
       foreign key (user_id) 
       references users;

    alter table users_roles_aud 
       add constraint FKktxqr55ntd0j2i228uj8sq6j9 
       foreign key (rev) 
       references revinfo;
