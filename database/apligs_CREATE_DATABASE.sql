/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2. 12. 2016 12:38:36                         */
/*==============================================================*/


drop table if exists igra;

drop table if exists instrument;

drop table if exists izvaja;

drop table if exists oglas;

drop table if exists sporocilo;

drop table if exists uporabnik;

drop table if exists vloga;

drop table if exists zvrst;

drop table if exists lokacija;

/*==============================================================*/
/* Table: igra                                                  */
/*==============================================================*/
create table igra
(
   id_instrument        int not null,
   id_uporabnik         int not null,
   primary key (id_instrument, id_uporabnik)
);

/*==============================================================*/
/* Table: instrument                                            */
/*==============================================================*/
create table instrument
(
   id_instrument        int not null AUTO_INCREMENT,
   in_naziv             varchar(50) not null,
   primary key (id_instrument)
);

/*==============================================================*/
/* Table: izvaja                                                */
/*==============================================================*/
create table izvaja
(
   id_zvrst             int not null,
   id_uporabnik         int not null,
   primary key (id_zvrst, id_uporabnik)
);

/*==============================================================*/
/* Table: lokacija                                              */
/*==============================================================*/
create table lokacija
(
   postna_stevilka      int not null,
   lo_naziv             varchar(60) not null,
   primary key (postna_stevilka)
);

/*==============================================================*/
/* Table: oglas                                                 */
/*==============================================================*/
create table oglas
(
   id_oglas             int not null AUTO_INCREMENT,
   id_vloga             int not null,
   id_uporabnik         int not null,
   id_zvrst             int not null,
   og_naslov            varchar(30) not null,
   og_objavljen         date not null,
   og_opis              varchar(200) not null,
   og_premium           bool not null,
   og_band				bool not null,
   primary key (id_oglas)
);

/*==============================================================*/
/* Table: sporocilo                                             */
/*==============================================================*/
create table sporocilo
(
   id_sporocila         int not null AUTO_INCREMENT,
   id_poslje            int not null,
   id_prejme            int not null,
   sp_zadeva            varchar(25) not null,
   sp_vsebina           varchar(250) not null,
   sp_poslano         	date not null,
   primary key (id_sporocila)
);

/*==============================================================*/
/* Table: uporabnik                                             */
/*==============================================================*/
create table uporabnik
(
   id_uporabnik         int not null AUTO_INCREMENT,
   postna_stevilka      int not null,
   id_vloga             int not null,
   up_ime               varchar(30) not null,
   up_priimek           varchar(50) not null,
   up_email             varchar(70) not null,
   up_ustvarjen         date,
   up_geslo				varchar(30) not null,
   up_picture			varchar(50),
   primary key (id_uporabnik)
);

/*==============================================================*/
/* Table: vloga                                                 */
/*==============================================================*/
create table vloga
(
   id_vloga             int not null AUTO_INCREMENT,
   vl_naziv             varchar(25) not null,
   primary key (id_vloga)
);

/*==============================================================*/
/* Table: zvrst                                                 */
/*==============================================================*/
create table zvrst
(
   id_zvrst             int not null AUTO_INCREMENT,
   zv_naziv             varchar(50) not null,
   primary key (id_zvrst)
);

alter table igra add constraint FK_igra foreign key (id_instrument)
      references instrument (id_instrument) on delete restrict on update restrict;

alter table igra add constraint FK_igra2 foreign key (id_uporabnik)
      references uporabnik (id_uporabnik) on delete restrict on update restrict;

alter table izvaja add constraint FK_izvaja foreign key (id_zvrst)
      references zvrst (id_zvrst) on delete restrict on update restrict;

alter table izvaja add constraint FK_izvaja2 foreign key (id_uporabnik)
      references uporabnik (id_uporabnik) on delete restrict on update restrict;

alter table oglas add constraint FK_ima1 foreign key (id_zvrst)
      references zvrst (id_zvrst) on delete restrict on update restrict;

alter table oglas add constraint FK_objavi foreign key (id_uporabnik)
      references uporabnik (id_uporabnik) on delete restrict on update restrict;

alter table oglas add constraint FK_vsebovan foreign key (id_vloga)
      references vloga (id_vloga) on delete restrict on update restrict;

alter table sporocilo add constraint FK_poslje foreign key (id_prejme)
      references uporabnik (id_uporabnik) on delete restrict on update restrict;

alter table sporocilo add constraint FK_prejme foreign key (id_poslje)
      references uporabnik (id_uporabnik) on delete restrict on update restrict;

alter table uporabnik add constraint FK_biva foreign key (postna_stevilka)
      references lokacija (postna_stevilka) on delete restrict on update restrict;

alter table uporabnik add constraint FK_ima foreign key (id_vloga)
      references vloga (id_vloga) on delete restrict on update restrict;

