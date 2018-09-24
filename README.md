# exus-assignment
Spring boot simple web application

Connect to mysql via command line

sudo mysql --password

Create a new database

```bash
mysql> create database assignment;
```
```bash
mysql> create user 'springuser'@'localhost' identified by 'springuser';
```

```bash
mysql> grant all on assignment.* to 'springuser'@'localhost';
```
Create the Users table

```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `ip_address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
select * from user;
```

-Checkout the project

-verify the db connection details at assignment\src\main\resources\application.properties

-Navigate to the project's folder via command line and run it with the command 

```bash
mvn spring-boot:run
```

Execute post request with curl to save a user

```bash
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"first_name":"test","last_name":"test", "email":"test@gmail.com","gender":"male", "ip_address":"127.0.0.1" }' \
  localhost:8080/assignment/saveuser
```

Execute get request to get all users

```bash
curl 'localhost:8080/assignment/getusers'
```
