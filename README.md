# Hibernate dialect for Machbase

This repository includes MachbaseDialect and these three different sample projects.

-  Log
-  Tag
-  Lookup(It's similar to Volatile)

## Preparation
----
1.  Install JDK 1.8 or above. Either Oracle Java or OpenJDK is okay.
2.  Install Maven(Linux) or Intellij IDEA or Eclips(Windows).
3.  Clone this repository to your local directory.
4.  Check if machbase.jar is in `$MACHBASE_HOME/lib/`

When building the Java project with Maven, add the following lines to pom.xml file
and also You can use machbase.jar
```
<dependencies>
    ...
    <dependency>
        <groupId>com.machbase.jdbc</groupId>
        <artifactId>machbase</artifactId>
        <version>350ac83b9</version>
        <scope>system</scope>
        <systemPath>${env.MACHBASE_HOME}/lib/machbase.jar</systemPath>
    </dependency>
</dependencies>
```

Or with Gradle, Create /libs directory in the project and copy the .JAR files in that place and add the following lines to the /build.gradle file.
```
dependencies {
    compile files('libs/machbase.jar')
}
```

Copy dialect Directory─org.hibernate.dialect─in the project(Sample projects in this repository already include the org.hibernate.dialect directory and files) and Change application.properties file.
```
spring.datasource.url=jdbc:machbase://localhost:5656/mhdb
spring.datasource.username=SYS
spring.datasource.password=MANAGER
spring.datasource.driver-class-name=com.machbase.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MachbaseDialect
```
<br>

**This Dialect does not support DDL yet.** So before running the project, please execute the following SQL queries to create a table.
```
- Log
create table log (name varchar(32), age integer);

- Tag
create table tag (name varchar(32) primary key, time datetime basetime, value double summarized);

- Lookup
create lookup table lookup (id long primary key, name varchar(32), ts datetime);

- Volatile
create volatile table volatile (id long primary key, name varchar(32), ts datetime);
```
<br>

## Compile & Run (Maven)
----
Change the directory to where `pom.xml` is located. Then,
```
mvn compile
mvn spring-boot:run
```

## Compile & Run (IDE)
----
1.  Click [File]-[Open] and open as project pom.xml.
2.  Click [Reimport All Maven Projects].
3.  Find application java file and click [Run '~Application'](Shift + F10 or ⌃+⌥+R).

## Reference
----
If you encounter any problem before running, please refer to [Spring Data JPA - Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) pages of Spring. Otherwise, please feel free to contant via support email (support@machbase.com) or signals in this repository page!
