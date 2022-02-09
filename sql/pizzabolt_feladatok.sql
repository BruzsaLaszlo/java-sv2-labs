use pizzabolt;

# Listázd ki az összes pizzát név szerint csökkenő sorrendben! (2 pont)
select nev
from pizza
order by nev desc;


# Számold meg, hány futár van, akinek a neve nem ’G’ betűvel kezdődik!
select count(*)
from futar
where nev not like 'G%';


# Számold össze, hogy melyik dátumon hány darab megrendelés történt! (2 pont)
select datum, count(*)
from rendeles
group by datum;


# Mely rendelések történtek délelőtt? (2 pont)
select *
from rendeles
where ido < 12;


# Átlagosan mennyibe kerül egy pizza? 1 tizedes pontossággal add meg a választ!
# Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)
select round(avg(ar), 1) as Atlag
from pizza;


# Listázd ki az összes megrendelés idejét, a megrendelő azonosítóját
# és a megrendelő nevét is! (3 pont)
select ido, vevo_id, nev
from rendeles
         join vevo v on v.id = rendeles.vevo_id;


# Szúrj be egy új oszlopot a vevo táblába!
# Az új mező típusa szöveges legyen, 9 karakter hosszú, a mező neve ’telefon’! (3 pont)
alter table vevo
    add telefon varchar(9);


# Szúrj be egy új rekordot a módosított vevo táblába!
# Minden mezőbe kerüljön adat! (3 pont)
insert into vevo (id, nev, cim, telefon)
values (8, 'Pistike', 'Kukutyin', '061234567');


# Listázd ki az összes pizzafutárt név szerint csökkenő sorrendben! (2 pont)
select nev
from futar
order by nev desc;


# Számold meg, mennyi vásárló van, akinek a neve nem ’S’ betűvel kezdődik! (2 pont)
select count(*)
from vevo
where nev not like 'S%';


# Számold össze, hogy melyik dátumon mennyi darab megrendelés történt! (2 pont)
select datum, count(*)
from rendeles
group by datum;


# Mely rendelések történtek délután? (2 pont)
select *
from rendeles
where id >= 12;


# Átlagosan hány órakor rendelnek pizzát?
# 1 tizedes pontossággal add meg a választ!
# Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)
select round(avg(ido), 1) as Atlag
from rendeles;


# Listázd ki az összes megrendeléshez tartozó azonosítót,
# a megrendelés idejét és a megrendelő nevét is! (3 pont)
select r.id, ido, nev
from rendeles r
         join vevo v on v.id = r.vevo_id;


# Szúrj be egy új oszlopot a futar táblába!
# Az új mező típusa szám legyen, 4 karakter hosszú, a mező neve ’szuletesi_ev’! (3 pont)
alter table futar
    add szuletesi_ev int(4);


# Szúrj be egy új rekordot a futar táblába! Minden mezőbe kerüljön adat! (3 pont)
insert into futar(id, nev, telefon, szuletesi_ev)
values (6, 'Jancsi', '06123456789', 2000);


# Listázd ki az összes vásárlót név szerint csökkenő sorrendben! (2 pont)
select nev
from vevo
order by nev desc;


# Átlagosan mennyi pizzát rendelnek egy alkalommal?
# 1 tizedes pontossággal add meg a választ!
# Az eredményoszlopot nevezd el ’Atlag’ néven! (3 pont)
select round(avg(db), 1) as Atlag
from tetel;


# Listázd ki az összes megrendeléshez tartozó azonosítót,
# a megrendelő azonosítóját és a megrendelő nevét is! (3 pont)
select r.id, v.id, nev
from rendeles r
         join vevo v on v.id = r.vevo_id;


# Szúrj be egy új oszlopot a pizza táblába!
# Az új mező típusa szám legyen, 4 karakter hosszú, a mező neve ’atmero’! (3 pont)
alter table pizza
    add atmero int(4);


# Szúrj be egy új rekordot a pizza táblába! Minden mezőbe kerüljön adat! (3 pont)
insert into pizza(id, nev, ar, atmero)
VALUES (6, 'Szalámis', 1500, 40);
