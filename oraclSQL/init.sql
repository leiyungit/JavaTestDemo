 用户名：orcl　密码：orcl
--删除表空间
drop tablespace JAVADATA including contents and datafiles;
--创建表空间
create tablespace JAVADATA datafile 'D:\app\Administrator\oradata\mydb\JAVADATA.dbf' size 5m autoextend 
on;
--删除用户以及用户所有的对象 
DROP USER test cascade;
--创建用户以及所属表空间
create user test IDENTIFIED BY test default tablespace JAVADATA;
--授予权限
GRANT  DBA,CONNECT,UNLIMITED TABLESPACE TO test;