insert into lokacija (postna_stevilka, lo_naziv) values (2380, 'Slovenj Gradec');

insert into lokacija (postna_stevilka, lo_naziv) values (1000, 'Ljubljana');

insert into lokacija (postna_stevilka, lo_naziv) values (2000, 'Maribor');

insert into lokacija (postna_stevilka, lo_naziv) values (3301, 'Petrovce');

insert into lokacija (postna_stevilka, lo_naziv) values (1290 , 'Grosuplje');

insert into zvrst (id_zvrst, zv_naziv) values (2, 'rock');

insert into zvrst (id_zvrst, zv_naziv) values (1, 'rap');

insert into zvrst (id_zvrst, zv_naziv) values (4, 'country');

insert into zvrst (id_zvrst, zv_naziv) values (5, 'reggae');

insert into zvrst (id_zvrst, zv_naziv) values (3, 'salsa');

insert into instrument (id_instrument, in_naziv) values (1, 'kitara');

insert into instrument (id_instrument, in_naziv) values (4, 'harmonika');

insert into instrument (id_instrument, in_naziv) values (3, 'bobni');

insert into instrument (id_instrument, in_naziv) values (2, 'bas kitara');

insert into instrument (id_instrument, in_naziv) values (5, 'klavir');

insert into instrument (in_naziv) values ('klarinet');

insert into vloga (id_vloga, vl_naziv) values (1, 'pevec');

insert into vloga (id_vloga, vl_naziv) values (5, 'kitarist');

insert into vloga (id_vloga, vl_naziv) values (2, 'basist');

insert into vloga (id_vloga, vl_naziv) values (4, 'pianist');

insert into vloga (id_vloga, vl_naziv) values (3, 'back vocal');

insert into uporabnik (id_uporabnik, postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_ustvarjen) values (2, 2380, 3, 'Mitja', 'Kotnik', 'mj0073@student.uni-lj.si', '2016-2-25');

insert into uporabnik (id_uporabnik, postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_ustvarjen) values (1, 2000, 5, 'Rok', 'Solar', 'rs0424@student.uni-lj.si', '2016-11-22');

insert into uporabnik (id_uporabnik, postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_ustvarjen) values (4, 1000, 1, 'Luka', 'Lavtar', 'll0523@student.uni-lj.si', '2016-11-13');

insert into uporabnik (id_uporabnik, postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_ustvarjen) values (3, 3301, 5, 'Andrej', 'Kokelj', 'ak1729@student.uni-lj.si', CURDATE());

insert into uporabnik (id_uporabnik, postna_stevilka, id_vloga, up_ime, up_priimek, up_email, up_ustvarjen) values (5, 1290, 4, 'Miha', 'Lampret', 'ml0043@student.uni-lj.si', '2016-11-19');

insert into igra (id_instrument, id_uporabnik) values (1, 2);

insert into igra (id_instrument, id_uporabnik) values (4, 1);

insert into igra (id_instrument, id_uporabnik) values (3, 4);

insert into igra (id_instrument, id_uporabnik) values (2, 3);

insert into igra (id_instrument, id_uporabnik) values (5, 1);

insert into izvaja (id_zvrst, id_uporabnik) values (2, 1);

insert into izvaja (id_zvrst, id_uporabnik) values (1, 4);

insert into izvaja (id_zvrst, id_uporabnik) values (4, 4);

insert into izvaja (id_zvrst, id_uporabnik) values (5, 3);

insert into izvaja (id_zvrst, id_uporabnik) values (3, 5);

insert into sporocilo (id_sporocila, id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) values (1, 2, 1, 'Pozdrav', 'Test aplikacije', '2016-12-13');

insert into sporocilo (id_sporocila, id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) values (2, 1, 2, 'Zivjo', 'Kako si kaj danes?', '2016-12-13');

insert into sporocilo (id_sporocila, id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) values (4, 2, 4, 'Kitarist', 'Pozdravljen, opazili smo, da si kitarist. Bi se nam pridruzil?', '2016-12-13');

insert into sporocilo (id_sporocila, id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) values (3, 1, 2, 'Ansambel', 'Oj, sem opazil, da iscete pevca.', '2016-12-13');

insert into sporocilo (id_sporocila, id_poslje, id_prejme, sp_zadeva, sp_vsebina, sp_poslano) values (5, 3, 1, 'Kritika', 'Niste glih najboljsi', '2016-12-13');

insert into oglas (id_oglas, id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) values (4, 5, 4, 5, 'Ansambel', '2016-12-1', 'Iscemo pevca za v ansambel!', 1);

insert into oglas (id_oglas, id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) values (5, 2, 1, 2, 'Pevec', '2016-12-1', 'Iscemo pevca za petje v duetu!', 0);

insert into oglas (id_oglas, id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) values (2, 2, 4, 1, 'Kitarist', '2016-12-1', 'Potrebujemo se enega kitarista, ki bi zamenjal obstojecega.', 1);

insert into oglas (id_oglas, id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) values (3, 5, 2, 5, 'Back vocal', '2016-12-1', 'Iscemo back vocal za pop skupino', 0);

insert into oglas (id_oglas, id_vloga, id_uporabnik, id_zvrst, og_naslov, og_objavljen, og_opis, og_premium) values (1, 2, 3, 5, 'Rock-punk', '2016-12-1', 'Iscemo pianista za jazz skupino', 0);

