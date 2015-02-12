# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table film (
  id                        bigint not null,
  label                     varchar(255),
  year                      varchar(255),
  country                   varchar(255),
  director                  varchar(255),
  genre                     varchar(255),
  rating                    varchar(255),
  picture                   varchar(255),
  description               TEXT,
  constraint pk_film primary key (id))
;

create sequence film_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists film;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists film_seq;

