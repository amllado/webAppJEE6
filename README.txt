- Tecnologías JavaEE6 utilizadas:

    JPA 2.0
    EJB 3.1
    Servlet 3.0
    CDI 1.0
    JSF 2.0
    JSP 2.2
    EL 2.2
    JSTL 1.2

- Referencias:

    https://en.wikipedia.org/wiki/Java_EE_version_history#Java_EE_6_.28December_10.2C_2009.29
    http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/intServletsEJB/integratingCdiEjb.html

- Versión de TomEE utilizada: TomEE JAXRS 1.7.4
- Versión de Eclipse: 4.5.2 (Mars)
- Versión de MySQL: 5.6.24, for Win64
- Driver MySQL: mysql-connector-java-5.1.41-bin.jar (proporcionado en proyecto).

- Base de datos:

    create database test;
    create table test_entity (id integer not null primary key auto_increment, name varchar(32) not null);
    insert into test_entity (name) values ('Test');

- Datasource para TomEE (en tomee.xml):

  <Resource id="test" type="DataSource">
    #  MySQL example
    #
    #  This connector will not work until you download the driver at:
    #  http://www.mysql.com/downloads/api-jdbc-stable.html

    JdbcDriver  com.mysql.jdbc.Driver
    JdbcUrl jdbc:mysql://localhost:3306/test?serverTimezone=UTC
    UserName    user
    Password    pass
  </Resource>