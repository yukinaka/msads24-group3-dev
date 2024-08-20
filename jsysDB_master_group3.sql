-- /*================================================================*/
-- /*  システム研修 テーブル/データ作成スクリプト            2021.12 */
-- /*    データベース：jsysdb                                        */
-- /*  All Rights Reserved, Copyright(c) Fujitsu Learning Media Ltd. */
-- /*================================================================*/

use jsysdb;


-- /*================================================================*/
-- /*  得意先採番テーブル（customer_numbering）テーブル削除          */
-- /*================================================================*/

DROP TABLE IF EXISTS customer_numbering;
DROP TABLE IF EXISTS customer_numberingA;


-- /*================================================================*/
-- /*  受注明細（order_details）テーブル削除                         */
-- /*================================================================*/

DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS order_detailsA;

-- /*================================================================*/
-- /*  受注（order）テーブル削除                                     */
-- /*================================================================*/

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS ordersA;

-- /*================================================================*/
-- /*  得意先（customer）テーブル削除                                */
-- /*================================================================*/

DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS customerA;

-- /*================================================================*/
-- /*  従業員（employee）テーブル削除                                */
-- /*================================================================*/

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employeeA;

-- /*================================================================*/
-- /*  商品（item）テーブル削除                                      */
-- /*================================================================*/

DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS itemA;

-- /*================================================================*/
-- /*  得意先採番テーブル（customer_numbering）テーブル作成          */
-- /*================================================================*/

CREATE TABLE customer_numbering (
  customer_code INTEGER(4) NOT NULL
)engine=InnoDB;


-- /*================================================================*/
-- /*  従業員（employee）テーブル作成                                */
-- /*================================================================*/

CREATE TABLE employee (
  employee_no VARCHAR(6) NOT NULL,
  employee_name VARCHAR(32),
  password VARCHAR(6),
  PRIMARY KEY(employee_no)
)engine=InnoDB;


-- /*================================================================*/
-- /*  得意先（customer）テーブル作成                                */
-- /*================================================================*/

CREATE TABLE customer (
  customer_code VARCHAR(6) NOT NULL,
  customer_name VARCHAR(32) NOT NULL,
  customer_telno1 VARCHAR(14) NOT NULL,
  customer_telno2 VARCHAR(14),
  customer_telno3 VARCHAR(14),
  customer_postalcode1 VARCHAR(8),
  customer_address1 VARCHAR(40),
  customer_postalcode2 VARCHAR(8),
  customer_address2 VARCHAR(40),
  discount_rate INTEGER(2) NOT NULL,
  delete_flag BIT(1) NOT NULL,
  last_update_by VARCHAR(6),
  PRIMARY KEY(customer_code),
  FOREIGN KEY (last_update_by) REFERENCES employee(employee_no)
)engine=InnoDB;


-- /*================================================================*/
-- /*  商品（item）テーブル作成                                      */
-- /*================================================================*/

CREATE TABLE item (
  item_code VARCHAR(6),
  item_name VARCHAR(32),
  price INTEGER(6),
  stock INTEGER(8),
  PRIMARY KEY(item_code)
)engine=InnoDB;


-- /*================================================================*/
-- /*  受注（orders）テーブル作成                                    */
-- /*================================================================*/

CREATE TABLE orders (
  order_no VARCHAR(6),
  customer_code VARCHAR(6),
  employee_no VARCHAR(6),
  total_price INTEGER(12),
  detail_num INTEGER(2),
  deliver_date date,
  order_date date,
  PRIMARY KEY(order_no),
  FOREIGN KEY (customer_code) REFERENCES customer(customer_code),
  FOREIGN KEY (employee_no) REFERENCES employee(employee_no)
)engine=InnoDB;


-- /*================================================================*/
-- /*  受注明細（order_details）テーブル作成                         */
-- /*================================================================*/

CREATE TABLE order_details (
  order_no VARCHAR(6),
  item_code VARCHAR(6),
  order_num INTEGER(4),
  order_price INTEGER(10),
  PRIMARY KEY(order_no,item_code),
  FOREIGN KEY (order_no) REFERENCES orders(order_no),
  FOREIGN KEY (item_code) REFERENCES item(item_code)
)engine=InnoDB;


-- /*================================================================*/
-- /*  得意先採番（customer_numbering）テーブル データ挿入           */
-- /*================================================================*/

INSERT INTO customer_numbering VALUES(15);


-- /*================================================================*/
-- /*  従業員（employee）テーブル データ挿入                         */
-- /*================================================================*/

INSERT INTO employee VALUES('H20001','安藤直也','zy0001');
INSERT INTO employee VALUES('H20002','加西春美','yx0002');
INSERT INTO employee VALUES('H20003','坂口雅也','xw0003');
INSERT INTO employee VALUES('H20004','田中泰','wv0004');


-- /*================================================================*/
-- /*  得意先（customer）テーブル データ挿入                         */
-- /*================================================================*/

INSERT INTO customer VALUES('KA0001','Aストア','045-128-3581','','','220-0001','横浜市西区北幸２－１','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0002','Bストア','045-128-3582','','','220-0002','横浜市西区浅間２－２','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0003','Cストア','045-128-3583','','','220-0003','横浜市西区みなとみらい２－１','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0004','Dストア','045-128-3584','','','220-0004','横浜市西区南幸１－４','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0005','Eストア','045-128-3585','','','220-0005','横浜市西区北幸２－５','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0006','Fストア','045-128-3586','','','220-0006','横浜市西区北幸２－６','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0007','Gストア','045-128-3587','','','220-0007','横浜市西区高島１－１','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0008','Hストア','045-128-3588','','','220-0008','横浜市西区高島１－２','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0009','Iストア','045-128-3589','','','220-0009','横浜市西区高島２－３','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0010','Jストア','045-150-3590','','','220-0010','横浜市西区高島２－４','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0011','Kストア','045-150-3591','','','220-0011','横浜市西区みなとみらい２－１','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0012','Lストア','045-150-3592','','','220-0012','横浜市西区みなとみらい２－２','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0013','Mストア','045-150-3593','','','220-0013','横浜市西区みなとみらい２－３','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0014','Nストア','045-150-3594','','','220-0014','横浜市西区みなとみらい２－４','','',0,false,'H20001');
INSERT INTO customer VALUES('KA0015','Oストア','045-150-3595','','','220-0015','横浜市西区みなとみらい２－５','','',0,false,'H20001');

-- /*================================================================*/
-- /*  商品（item）テーブル データ挿入                               */
-- /*================================================================*/

INSERT INTO item VALUES('AX0001','ミネラルウォーター（500ml）',80 ,99975); 
INSERT INTO item VALUES('AX0002','ミネラルウォーター（2ｌ）',100 ,100000); 
INSERT INTO item VALUES('AX0003','ミネラルウォーター（業務用）',1000 ,100000); 
INSERT INTO item VALUES('AX0004','ミネラルウォーター(500ml)x12本',500 ,100000); 
INSERT INTO item VALUES('AX0005','ミネラルウォーター(2ｌ)x12本',1200 ,100000); 
INSERT INTO item VALUES('AX0006','海洋深層水（500ml）',80 ,100000); 
INSERT INTO item VALUES('AX0007','海洋深層水（2ｌ）',100 ,100000); 
INSERT INTO item VALUES('AX0008','海洋深層水（業務用）',1000 ,100000); 
INSERT INTO item VALUES('AX0009','海洋深層水(500ml)x12本',500 ,100000); 
INSERT INTO item VALUES('AX0010','海洋深層水(2ｌ)x12本',1200 ,100000); 

INSERT INTO item VALUES('BX0001','黄金にんにく・10日分',1200 ,99970); 
INSERT INTO item VALUES('BX0002','黄金にんにく・30日分',3000 ,99990); 
INSERT INTO item VALUES('BX0003','黄金にんに・ 90日分',8000 ,100000); 
INSERT INTO item VALUES('BX0004','無臭にんにく・10日分',1000 ,100000); 
INSERT INTO item VALUES('BX0005','無臭にんにく・30日分',2800 ,99990); 
INSERT INTO item VALUES('BX0006','無臭にんにく・90日分',7400 ,100000); 
INSERT INTO item VALUES('BX0007','健康黒ゴマ・10日分',500 ,100000); 
INSERT INTO item VALUES('BX0008','健康黒ゴマ・30日分',1300 ,99990); 
INSERT INTO item VALUES('BX0009','健康黒ゴマ・90日分',3500 ,100000); 
INSERT INTO item VALUES('BX0010','黒ゴマセサミン・10日分',600 ,100000); 
INSERT INTO item VALUES('BX0011','黒ゴマセサミン・30日分',1500 ,99990); 
INSERT INTO item VALUES('BX0012','黒ゴマセサミン・90日分',4000 ,100000); 

INSERT INTO item VALUES('CX0001','食べる納豆キナーゼ・10日分',600 ,99980); 
INSERT INTO item VALUES('CX0002','食べる納豆キナーゼ・30日分',1600 ,100000); 
INSERT INTO item VALUES('CX0003','食べる納豆キナーゼ・90日分',4500 ,100000); 

INSERT INTO item VALUES('DX0001','雑穀プラス・10食分',500 ,100000); 
INSERT INTO item VALUES('DX0002','雑穀プラス・30食分',1300 ,100000); 
INSERT INTO item VALUES('DX0003','雑穀プラス・90食分',3500 ,100000); 
INSERT INTO item VALUES('DX0004','五穀米・10食分',1000 ,100000); 
INSERT INTO item VALUES('DX0005','五穀米・30食分',2800 ,100000); 
INSERT INTO item VALUES('DX0006','五穀米・90食分',8500 ,100000); 
INSERT INTO item VALUES('DX0007','十穀米・10食分',1200 ,100000); 
INSERT INTO item VALUES('DX0008','十穀米・30食分',3400 ,100000); 
INSERT INTO item VALUES('DX0009','十穀米・90食分',9500 ,100000); 
INSERT INTO item VALUES('DX0010','健康発芽玄米・10食分',1000 ,100000); 
INSERT INTO item VALUES('DX0011','健康発芽玄米・30食分',2800 ,100000); 
INSERT INTO item VALUES('DX0012','健康発芽玄米・90食分',8500 ,100000); 
INSERT INTO item VALUES('DX0013','健康黒酢（200ml）',350 ,100000); 
INSERT INTO item VALUES('DX0014','健康黒酢（1ｌ）',900 ,100000); 
INSERT INTO item VALUES('DX0015','健康黒酢（200ml）x12本',3500 ,100000); 
INSERT INTO item VALUES('DX0016','健康黒酢（1ｌ）x12本',9000 ,100000); 

INSERT INTO item VALUES('EX0001','乳酸菌飲料ジョイ・6本パック',280 ,100000); 
INSERT INTO item VALUES('EX0002','乳酸菌飲料ジョイ・12本パック',500 ,100000); 
INSERT INTO item VALUES('EX0003','乳酸菌プラス・24袋パック',2200 ,100000); 
INSERT INTO item VALUES('EX0004','乳酸菌プラス・36袋パック',3000 ,100000); 
INSERT INTO item VALUES('EX0005','乳酸菌プラス・36袋パック',5000 ,100000); 
INSERT INTO item VALUES('EX0006','健康青汁・24袋パック',2200 ,100000); 
INSERT INTO item VALUES('EX0007','健康青汁・36袋パック',3000 ,100000); 
INSERT INTO item VALUES('EX0008','健康青汁・60袋パック',5000 ,100000); 

INSERT INTO item VALUES('FX0001','マルチビタミン&ミネラル・10日分',1200 ,99990); 
INSERT INTO item VALUES('FX0002','マルチビタミン&ミネラル・30日分',3500 ,100000); 
INSERT INTO item VALUES('FX0003','マルチビタミン&ミネラル・120日分',12000 ,100000); 
INSERT INTO item VALUES('FX0004','マルチビタミンforMen・10日分',1200 ,100000); 
INSERT INTO item VALUES('FX0005','マルチビタミンforMen・30日分',3500 ,100000); 
INSERT INTO item VALUES('FX0006','マルチビタミンforMen・120日分',12000 ,100000); 
INSERT INTO item VALUES('FX0007','マルチビタミンforWomen・10日分',1200 ,100000); 
INSERT INTO item VALUES('FX0008','マルチビタミンforWomen・30日分',3500 ,100000); 
INSERT INTO item VALUES('FX0009','マルチビタミンforWomen・120日分',12000 ,100000); 
INSERT INTO item VALUES('FX0010','ビタミン13・10日分',1000 ,100000); 
INSERT INTO item VALUES('FX0011','ビタミン13・30日分',3500 ,100000); 
INSERT INTO item VALUES('FX0012','ビタミン13・120日分',10000 ,100000); 
INSERT INTO item VALUES('FX0013','ビタミンBB・10日分',900 ,100000); 
INSERT INTO item VALUES('FX0014','ビタミンBB・30日分',2500 ,100000); 
INSERT INTO item VALUES('FX0015','ビタミンBB・120日分',9000 ,100000); 
INSERT INTO item VALUES('FX0016','ビタミンC・10日分',800 ,100000); 
INSERT INTO item VALUES('FX0017','ビタミンC・30日分',2200 ,100000); 
INSERT INTO item VALUES('FX0018','ビタミンC・120日分',8000 ,100000); 
INSERT INTO item VALUES('FX0019','天然ビタミンＥ・10日分',900 ,100000); 
INSERT INTO item VALUES('FX0020','天然ビタミンＥ・30日分',2500 ,100000); 
INSERT INTO item VALUES('FX0021','天然ビタミンＥ・120日分',9000 ,100000); 
INSERT INTO item VALUES('FX0022','紫蘇・10日分',300 ,100000); 
INSERT INTO item VALUES('FX0023','紫蘇・30日分',800 ,100000); 
INSERT INTO item VALUES('FX0024','紫蘇・120日分',3000 ,100000); 
INSERT INTO item VALUES('FX0025','天然アミノ・10日分',350 ,100000); 
INSERT INTO item VALUES('FX0026','天然アミノ・30日分',1200 ,100000); 
INSERT INTO item VALUES('FX0027','天然アミノ・120日分',4000 ,100000); 
INSERT INTO item VALUES('FX0028','甜茶･10日分',300 ,100000); 
INSERT INTO item VALUES('FX0029','甜茶･30日分',800 ,100000); 
INSERT INTO item VALUES('FX0030','甜茶･120日分',3000 ,100000); 
INSERT INTO item VALUES('FX0031','天然田七人参・10日分',300 ,100000); 
INSERT INTO item VALUES('FX0032','天然田七人参・30日分',800 ,100000); 
INSERT INTO item VALUES('FX0033','天然田七人参・30日分',3000 ,100000); 

INSERT INTO item VALUES('GX0001','健康十穀の粥・1食',120 ,99990); 
INSERT INTO item VALUES('GX0002','健康十穀の粥・10食パック',1000 ,100000); 
INSERT INTO item VALUES('GX0003','健康十穀の粥・30食パック',2800 ,100000); 
INSERT INTO item VALUES('GX0004','健康十穀の粥・90食パック',8000 ,99990); 
INSERT INTO item VALUES('GX0005','健康十穀の粥(カレー)・1食',120 ,99990); 
INSERT INTO item VALUES('GX0006','健康十穀の粥(カレー）・10食パック',1000 ,100000); 
INSERT INTO item VALUES('GX0007','健康十穀の粥(カレー)・30食パック',2800 ,100000); 
INSERT INTO item VALUES('GX0008','健康十穀の粥(カレー)・90食パック',8000 ,99990); 

INSERT INTO item VALUES('HX0001','健康低反発まくらS',12000 ,100000); 
INSERT INTO item VALUES('HX0002','健康低反発まくらM',12500 ,100000); 
INSERT INTO item VALUES('HX0003','健康低反発まくらL',13000 ,100000); 

INSERT INTO item VALUES('IX0001','健康オーダーまくらS',17000 ,100000); 
INSERT INTO item VALUES('IX0002','健康オーダーまくらM',17500 ,100000); 
INSERT INTO item VALUES('IX0003','健康オーダーまくらL',18000 ,100000); 

INSERT INTO item VALUES('JX0001','男性用育毛トニック',6500 ,99990); 
INSERT INTO item VALUES('JX0002','女性用育毛トニック',6500 ,99990); 
INSERT INTO item VALUES('JX0003','育毛シャンプー',2000 ,99990); 
INSERT INTO item VALUES('JX0004','育毛コンディショナー',2200 ,99990); 



-- /*================================================================*/
-- /*  受注（orders）テーブル データ挿入                             */
-- /*================================================================*/

INSERT INTO orders VALUES ('000001','KA0001','H20001',800,1,'2021-11-10','2021-11-9');
INSERT INTO orders VALUES ('000002','KA0015','H20002',12000,1,'2021-12-8','2021-12-7');
INSERT INTO orders VALUES ('000003','KA0015','H20001',6000,1,'2021-12-1','2021-12-1');
INSERT INTO orders VALUES ('000004','KA0001','H20003',13200,2,'2021-12-10','2021-12-9');
INSERT INTO orders VALUES ('000005','KA0014','H20001',172000,4,'2022-1-5','2022-1-5');
INSERT INTO orders VALUES ('000006','KA0003','H20003',86000,4,'2022-2-10','2022-2-10');
INSERT INTO orders VALUES ('000007','KA0001','H20001',18000,2,'2022-2-15','2022-2-15');
INSERT INTO orders VALUES ('000008','KA0003','H20002',174400,5,'2022-3-20','2022-3-20');


-- /*================================================================*/
-- /*  受注明細（order_details）テーブル データ挿入                  */
-- /*================================================================*/

INSERT INTO order_details VALUES('000001','AX0001',10,800);
INSERT INTO order_details VALUES('000002','BX0001',10,12000);
INSERT INTO order_details VALUES('000003','CX0001',10,6000);
INSERT INTO order_details VALUES('000004','AX0001',15,1200);
INSERT INTO order_details VALUES('000004','BX0001',10,12000);
INSERT INTO order_details VALUES('000005','JX0001',10,65000);
INSERT INTO order_details VALUES('000005','JX0002',10,65000);
INSERT INTO order_details VALUES('000005','JX0003',10,20000);
INSERT INTO order_details VALUES('000005','JX0004',10,22000);
INSERT INTO order_details VALUES('000006','BX0002',10,30000);
INSERT INTO order_details VALUES('000006','BX0005',10,28000);
INSERT INTO order_details VALUES('000006','BX0008',10,13000);
INSERT INTO order_details VALUES('000006','BX0011',10,15000);
INSERT INTO order_details VALUES('000007','BX0001',10,12000);
INSERT INTO order_details VALUES('000007','CX0001',10,6000);
INSERT INTO order_details VALUES('000008','FX0001',10,12000);
INSERT INTO order_details VALUES('000008','GX0001',10,1200);
INSERT INTO order_details VALUES('000008','GX0004',10,80000);
INSERT INTO order_details VALUES('000008','GX0005',10,1200);
INSERT INTO order_details VALUES('000008','GX0008',10,80000);


COMMIT;

