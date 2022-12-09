 ### **ПРОГРАММА УЧЕТА ДЛЯ АВТОСЕРВИСА**

- *REST API, Spring Boot, PostgreSQL, Hibernate, Docker, JUnit, SQL, JPQL, Maven, lombok, h2, Mockito*
  
Является моим pet-проектом и находится в стадии разработки. Идея состоит в том, чтобы создать простую и интуитивно понятную программу для учета работы автосервиса.

Предполагается реализовать два уровня доступа:
- пользовательский (ограниченный)
- административный (расширенный)


### На данный момент реализовано:

1) Первичная схема базы данных:
- филиалы (branches)
- должности (positions)
- сотрудники (employees)
- виды услуг (services)
- разделы запчастей (auto_parts_section)
- запасти (auto_parts)
- клиенты (clients)
- автомобили (cars)
- заказы (orders)

  ![схема БД](/order_services.png)

2) Раздел филиалы (Branch) - CRUD;

3) Раздел должности (Position) - CRUD;

4) Раздел сотрудники (Employee) - CRUD;

5) Раздел услуги (ServicesSection) - CRUD;
