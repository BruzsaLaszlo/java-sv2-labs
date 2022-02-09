use orszag;

select orszag, penznem
from orszagok
where penznem like '%eu%';

select orszag, gdp
from orszagok
order by gdp desc;

select allamforma, count(*) c
from orszagok
group by allamforma
order by c desc;

select foldrajzi_hely, count(*)
from orszagok
group by foldrajzi_hely;

select orszag
from orszagok
where foldrajzi_hely like 'Nyugat-Európa';