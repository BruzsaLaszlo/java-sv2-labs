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

select foldrajzi_hely, sum(nepesseg) s
from orszagok
group by foldrajzi_hely
having s > 2000
order by s desc;

SELECT COUNT(country) c, foldrajzi_hely, country
FROM orszagok
GROUP BY foldrajzi_hely
HAVING c = 1;