
delete from Ingredient_Ref;
delete from Pizza;
delete from Pizza_Order;
delete from Ingredient;

insert into Ingredient (id, name, type)
    values('SCK', 'Sucuk', 'PROTEiN');

insert into Ingredient (id, name, type)
    values('SOSIS', 'Sosis', 'PROTEiN');

insert into Ingredient (id, name, type)
    values('SLM', 'Salam', 'PROTEiN');

insert into Ingredient (id, name, type)
    values('MZRLL', 'Mozerella', 'CHEESE');

insert into Ingredient (id, name, type)
    values('BYZ', 'Beyaz Peynir', 'CHEESE');

insert into Ingredient (id, name, type)
    values('CHD', 'Cheddar Peyniri', 'CHEESE');

insert into Ingredient (id, name, type)
    values('MNTR', 'Mantar', 'VEGGiES');

insert into Ingredient (id, name, type)
    values('ZYTN', 'Zeytin', 'VEGGiES');


insert into Ingredient (id, name, type)
    values('MSR', 'Mısır', 'VEGGiES');


insert into Ingredient (id, name, type)
    values('SGN', 'Soğan', 'VEGGiES');


insert into Ingredient (id, name, type)
    values('PTLCN', 'Patlıcan', 'VEGGiES');