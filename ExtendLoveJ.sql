/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/7/31 21:46:34                           */
/*==============================================================*/

drop table if exists category_article;

drop table if exists site_config;

drop table if exists tag_article;

drop table if exists tag;

drop table if exists attach;

drop table if exists category;

drop table if exists comment;

drop table if exists article;

drop table if exists contact;

drop table if exists link;

drop table if exists user;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   id                   int(11) not null auto_increment,
   content              longtext not null,
   modifyTime           timestamp default CURRENT_TIMESTAMP,
   postTime             timestamp,
   articleType          varchar(255),
   status               varchar(10),
   summary              longtext,
   title                varchar(255) not null,
   view                 int(11) default 0,
   trash                bit(1) default false comment '�ж������Ƿ�ɾ��
            ',
   topTime              timestamp,
   menuOrder            int(11),
   parentId             int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: attach                                                */
/*==============================================================*/
create table attach
(
   id                   int(11) not null auto_increment,
   articleId            int(11),
   description          varchar(255),
   url                  varchar(255),
   download             int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   id                   int(11) not null auto_increment,
   parentId             int(11) default 0,
   createTime           timestamp default CURRENT_TIMESTAMP,
   description          varchar(255),
   name                 varchar(50),
   priority             int(11),
   trash                bit(1),
   type                 varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: category_article                                      */
/*==============================================================*/
create table category_article
(
   id                   int(11) not null auto_increment,
   categoryId           int(11),
   articleId            int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   id                   int(11) not null auto_increment,
   articleId            int(11),
   content              longtext not null,
   email                varchar(255),
   name                 varchar(50),
   postIP               varchar(20),
   postTime             timestamp default CURRENT_TIMESTAMP,
   site                 varchar(255),
   status               bit(1) default false,
   trash                bit(1) default false,
   primary key (id)
);

/*==============================================================*/
/* Table: contact                                               */
/*==============================================================*/
create table contact
(
   id                   int(11) not null auto_increment,
   content              longtext not null,
   email                varchar(255) not null,
   name                 varchar(50) not null,
   postIP               varchar(20),
   postTime             timestamp not null default CURRENT_TIMESTAMP,
   site                 varchar(255),
   status               varchar(10),
   trash                bit(1),
   primary key (id)
);

/*==============================================================*/
/* Table: link                                                  */
/*==============================================================*/
create table link
(
   id                   int(11) not null auto_increment,
   createTime           timestamp,
   description          varchar(255),
   name                 varchar(50),
   site                 varchar(255),
   status               varchar(10),
   trash                bit(1),
   primary key (id)
);

/*==============================================================*/
/* Table: site_config                                           */
/*==============================================================*/
create table site_config
(
   id                   int(11) not null auto_increment,
   about                varchar(255),
   contactDescription   longtext,
   icp                  varchar(50),
   name                 varchar(50),
   url                  varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   id                   int(11) not null auto_increment,
   name                 varchar(255),
   description          varchar(255),
   trash                bit(1),
   primary key (id)
);

/*==============================================================*/
/* Table: tag_article                                           */
/*==============================================================*/
create table tag_article
(
   id                   int(11) not null auto_increment,
   tagId                int(11),
   articleId            int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int(11) not null auto_increment,
   age                  int(11) not null,
   birthday             timestamp default CURRENT_TIMESTAMP,
   email                varchar(255) not null,
   gender               bit(1) not null,
   nickname             varchar(20) not null,
   password             varchar(20) not null,
   qq                   varchar(14),
   username             varchar(20) not null,
   createTime           timestamp,
   description          varchar(255),
   roleType             int not null default 1 comment '�û�������˵����0��root 1: ��ͨ�û�',
   primary key (id)
);

alter table attach add constraint FK_Reference_8 foreign key (articleId)
      references article (id) on delete restrict on update restrict;

alter table category_article add constraint FK_Reference_11 foreign key (categoryId)
      references category (id) on delete restrict on update restrict;

alter table category_article add constraint FK_Reference_12 foreign key (articleId)
      references article (id) on delete restrict on update restrict;

alter table comment add constraint FK_Reference_6 foreign key (articleId)
      references article (id) on delete restrict on update restrict;

alter table tag_article add constraint FK_Reference_10 foreign key (articleId)
      references article (id) on delete restrict on update restrict;

alter table tag_article add constraint FK_Reference_9 foreign key (tagId)
      references tag (id) on delete restrict on update restrict;

