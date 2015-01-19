use edustats;
insert into rol values (1, 'ROL_USER');
insert into institucion_educativa values (1, 'Santa Rosa del Sauce', 'IESRS');
select * from persona;
insert into persona values ('12345678', '', 'admin', '', '12345678');
insert into usuario values ('admin', md5('admin'), 1, '12345678');
insert into usuario_has_rol values ('admin', 1);

select * from nivel;
insert into nivel (nivel_nombre) values ('PRIMARIA');
insert into nivel (nivel_nombre) values ('INICIAL');
insert into nivel (nivel_nombre) values ('SECUNDARIA');

