/*Query a list of CITY names from STATION for cities that have an even ID number. 
Print the results in any order, but exclude duplicates from the answer. 
The STATION table is described as follows:

+--------+--------------+------+-----+---------+-------+
| Field  | Type         | Null | Key | Default | Extra |
+--------+--------------+------+-----+---------+-------+
| ID     | NUMBER       | YES  |     | NULL    |       |
| CITY   | VARCHAR2(21) | YES  |     | NULL    |       |
| STATE  | VARCHAR2(2)  | YES  |     | NULL    |       |
| LAT N  | NUMBER       | YES  |     | NULL    |       |
| LONG W | NUMBER       | YES  |     | NULL    |       |
+--------+--------------+------+-----+---------+-------+
*/

ANSWER:
SELECT DISTINCT CITY
FROM STATION
WHERE MOD(ID, 2) = 0;
