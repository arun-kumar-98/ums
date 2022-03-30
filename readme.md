About the university management project
in this we basically try to understand the

project details
----------------
1.model
--------
we have 2 entity classes

University
------------
university id,
department,
list of student

Student(mapped entity)
----------------------------
student entity details like
id,name,age,marks.

2.repository
-------------
IStudentDao.java
IUniversityDao.java

3.service classes
-----------------
IUniversityService.java
UniversityServiceImpl.java

4.controller class
-------------------
StudentController.ajava

about controller class
=======================

/university
--------------
this is my main request mapping url for the application.

/save
------
http://localhost:9090/university/save
above url for store the records in database .

/get
-----
http://localhost:9090/university/get
by this url we will all database list of records.

/get/mech
------------
http://localhost:9090/university/get/mech
by this url we will only machanical student details.

/marks/{dept}
--------------
http://localhost:9090/university/marks/physics
 in above example url we will get physics according to marks.
 
 /bonus_marks
 -------------
 http://localhost:9090/university/bonus_marks
 
if any any department student is performing well
then we will add 10 extra marksto them.

/low_performance
-----------------
http://localhost:9090/university//low_performance
low performing student list according to there department.

/delete
---------
http://localhost:9090/university/delete
this is url to remove extremely poor performer in university.

/sort_by_marks/{dept}
----------------------
http://localhost:9090/university/sort_by_marks/{dept}
in the particular department we can sort the student to there obtaining marks.

 






