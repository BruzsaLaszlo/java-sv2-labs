use barkacsbolt;

# Mely termékek drágábbak 1000 Ft-nál? (2 pont)
SELECT *
from termek
where ar > 1000;


# Hányszor rendelt termékeket Morgó? (3 pont)
select count(*)
from rendeles r
         join vasarlo v on r.vasarlo_id = v.id
where nev = 'Morgó';


# Ki vásárolta meg az egyes rendeléseket? A nevét is jelenítsd meg!
# Az eredményoszlopot nevezd el „ugyfel” néven!  (4 pont)
select r.id as rendeles_id, v.nev as ugyfel
from rendeles as r
         join vasarlo v on r.vasarlo_id = v.id;


# Hány darabot rendeltek összesen az egyes termékekből?
# A termékek árát is jelenítsd meg! (4 pont)
select t.ar, t.nev
from tetel
         join termek t on tetel.termek_id = t.id
         join rendeles r on r.id = tetel.rendeles_id
group by t.nev;


# Mely rendelések történtek délután?
# A megrendelt termékek nevét is jelenítsd meg! (4 pont)
select r.id as rendeles_id, ido, t.nev as termek_nev
from tetel
         join rendeles r on r.id = tetel.rendeles_id
         join termek t on t.id = tetel.termek_id
where ido >= 12;


# Melyik a legolcsóbb termék?
# Az árát, az azonosítóját és a nevét is listázd ki! (3 pont)
select *
from termek
where ar = (
    select min(ar)
    from termek);


# Mely termékek olcsóbbak 1000 Ft-nál? (2 pont)
select ar
from termek
where ar < 1000;

# Hányszor rendelt termékeket Szende? (3 pont)
select count(*)
from rendeles as r
         join vasarlo v on r.vasarlo_id = v.id
where v.nev = 'Szende';


# Ki adta el az egyes rendeléseket? A nevét is jelenítsd meg!
# Az eredményoszlopot nevezd el „elado” néven!  (4 pont)
select r.id as rendeles_id, e.nev elado
from rendeles as r
         join elado e on r.elado_id = e.id;


# Hány darabot rendeltek összesen az egyes termékekből?
# A termékek nevét is jelenítsd meg! (4 pont)
select count(*), nev
from tetel
         join termek t on t.id = tetel.termek_id
group by t.nev;

# Mely rendelések történtek délelőtt?
# A megrendelt termék nevét is jelenítsd meg! (4 pont)
select r.id as rendeles_id, ido, nev
from tetel t
         join rendeles r on r.id = t.rendeles_id
         join termek t2 on t2.id = t.termek_id
where ido < 12;


# Melyik a legdrágább termék?
# Az árát, az azonosítóját és a nevét is listázd ki! (4 pont)
select *
from termek
where ar = (
    select max(ar)
    from termek);


# Melyek azok a termékek, amelyekből még nem történt eladás,
# azaz csak porosodnak a raktárban? (4 pont)
select id, nev
from termek
where not id in (
    select termek_id
    from tetel);
