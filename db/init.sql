use edustats;
insert into rol values (null, 'ROL_USER');
insert into institucion_educativa values (null, 'Santa Rosa del Sauce', 'IESRS');
insert into persona values ('Jax', '', 'kodex', '', '12345678');
insert into usuario values ('jaxkodex', md5('123456'), 1, '12345678');
insert into usuario_has_rol values ('jaxkodex', 1);