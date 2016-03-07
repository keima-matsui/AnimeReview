# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ani_list (
  ani_id                    integer auto_increment not null,
  title                     varchar(255),
  story                     varchar(255),
  time                      datetime(6) not null,
  constraint pk_ani_list primary key (ani_id))
;

create table ani_user (
  user_id                   varchar(255) not null,
  mail                      varchar(255),
  password                  varchar(255),
  nick                      varchar(255),
  age                       integer,
  sex                       integer,
  constraint pk_ani_user primary key (user_id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ani_list;

drop table ani_user;

SET FOREIGN_KEY_CHECKS=1;

