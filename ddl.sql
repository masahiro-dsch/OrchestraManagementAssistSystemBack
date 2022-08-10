-- Project Name : noname
-- Date/Time    : 2022/08/10 00:04:02
-- Author       : masah
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

--CREATE DATABASE omas;

--<<注意！！ by近藤>>
--先にpgAdminなどでデータベース「omas」を作成しておくこと。

-- concert
--* BackupToTempTable
DROP TABLE IF EXISTS concert CASCADE;

--* RestoreFromTempTable
CREATE TABLE concert (
  id serial NOT NULL
  , title character varying(255)
  , date date
  , description character varying(4096)
  , organization character varying[]
  , CONSTRAINT concert_PKC PRIMARY KEY (id)
) ;

-- order
--* BackupToTempTable
DROP TABLE IF EXISTS "order" CASCADE;

--* RestoreFromTempTable
CREATE TABLE "order" (
  id serial NOT NULL
  , concert_id integer
  , user_id text
  , name_sei text
  , name_mei text
  , post_code text
  , address text
  , mail text
  , phone text
  , order_date timestamp(6) without time zone
  , pay_method text
  , pay_status text
  , pass_method text
  , pass_status text
  , CONSTRAINT order_PKC PRIMARY KEY (id)
) ;

-- order_detail
--* BackupToTempTable
DROP TABLE IF EXISTS order_detail CASCADE;

--* RestoreFromTempTable
CREATE TABLE order_detail (
  id serial NOT NULL
  , order_id integer
  , floor text
  , "column" text
  , number text
  , rank text
) ;

-- order_number
--* BackupToTempTable
DROP TABLE IF EXISTS order_number CASCADE;

--* RestoreFromTempTable
CREATE TABLE order_number (
  id integer NOT NULL
  , order_number integer NOT NULL
  , CONSTRAINT order_number_PKC PRIMARY KEY (id)
) ;

-- product
--* BackupToTempTable
DROP TABLE IF EXISTS product CASCADE;

--* RestoreFromTempTable
CREATE TABLE product (
  id serial NOT NULL
  , name character varying(255)
  , description character varying(4096)
  , quantity integer
  , CONSTRAINT product_PKC PRIMARY KEY (id)
) ;

-- todo
--* BackupToTempTable
DROP TABLE IF EXISTS todo CASCADE;

--* RestoreFromTempTable
CREATE TABLE todo (
  id serial NOT NULL
  , description character varying(255)
  , details character varying(4096)
  , done boolean
  , CONSTRAINT todo_PKC PRIMARY KEY (id)
) ;

COMMENT ON TABLE concert IS 'concert';
COMMENT ON COLUMN concert.id IS 'id';
COMMENT ON COLUMN concert.title IS 'title';
COMMENT ON COLUMN concert.date IS 'date';
COMMENT ON COLUMN concert.description IS 'description';
COMMENT ON COLUMN concert.organization IS 'organization';

COMMENT ON TABLE "order" IS 'order';
COMMENT ON COLUMN "order".id IS 'id';
COMMENT ON COLUMN "order".concert_id IS 'concert_id';
COMMENT ON COLUMN "order".user_id IS 'user_id';
COMMENT ON COLUMN "order".name_sei IS 'name_sei';
COMMENT ON COLUMN "order".name_mei IS 'name_mei';
COMMENT ON COLUMN "order".post_code IS 'post_code';
COMMENT ON COLUMN "order".address IS 'address';
COMMENT ON COLUMN "order".mail IS 'mail';
COMMENT ON COLUMN "order".phone IS 'phone';
COMMENT ON COLUMN "order".order_date IS 'order_date';
COMMENT ON COLUMN "order".pay_method IS 'pay_method';
COMMENT ON COLUMN "order".pay_status IS 'pay_status';
COMMENT ON COLUMN "order".pass_method IS 'pass_method';
COMMENT ON COLUMN "order".pass_status IS 'pass_status';

COMMENT ON TABLE order_detail IS 'order_detail';
COMMENT ON COLUMN order_detail.id IS 'id';
COMMENT ON COLUMN order_detail.order_id IS 'order_id';
COMMENT ON COLUMN order_detail.floor IS 'floor';
COMMENT ON COLUMN order_detail.column IS 'column';
COMMENT ON COLUMN order_detail.number IS 'number';
COMMENT ON COLUMN order_detail.rank IS 'rank';

COMMENT ON TABLE order_number IS 'order_number';
COMMENT ON COLUMN order_number.id IS 'id';
COMMENT ON COLUMN order_number.order_number IS 'order_number';

COMMENT ON TABLE product IS 'product';
COMMENT ON COLUMN product.id IS 'id';
COMMENT ON COLUMN product.name IS 'name';
COMMENT ON COLUMN product.description IS 'description';
COMMENT ON COLUMN product.quantity IS 'quantity';

COMMENT ON TABLE todo IS 'todo';
COMMENT ON COLUMN todo.id IS 'id';
COMMENT ON COLUMN todo.description IS 'description';
COMMENT ON COLUMN todo.details IS 'details';
COMMENT ON COLUMN todo.done IS 'done';

INSERT INTO public.concert(title,"date",description,organization) VALUES 
    ('第50回定期演奏会',DATE '2022-07-30','毎月の恒例行事です','{ほげほげ交響楽団,ふがふが合唱団}')
  , ('第25回サマーコンサート',DATE '2022-08-05','暖房が効いています','{ほげほげ交響楽団,もにょもにょ少年合唱団}');

INSERT INTO public."order"(concert_id,user_id,name_sei,name_mei,post_code,address,mail,phone,order_date,pay_method,pay_status,pass_method,pass_status) VALUES 
    (1,'postgreTestID','バックエンド','太郎','1234567','名古屋市東区東新町１番地','test@example.com','0120-123-4567',TIMESTAMP '2022-08-05 01:23:45.000','furikomi','no','yuso','no');

INSERT INTO public.order_detail(order_id,floor,"column",number,rank) VALUES 
    (1,'2','A','50','S')
  , (1,'2','B','60','A');

INSERT INTO public.order_number(id,order_number) VALUES 
    (1,1);

INSERT INTO public.product(name,description,quantity) VALUES 
    ('いちご','おいしいいちご',1)
  , ('りんご','あかいりんご',1)
  , ('メロン','メロンはカタカナ',1);

INSERT INTO public.todo(description,details,done) VALUES 
    ('configuration','congratulations, you have set up JDBC correctly!',True);
