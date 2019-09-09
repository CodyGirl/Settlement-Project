--------------------------------------------------------
--  File created - Monday-September-09-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADMINLOGIN
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."ADMINLOGIN" 
   (	"ADMINUSERNAME" VARCHAR2(20 BYTE), 
	"ADMINPASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CORPORATEACTIONBONUS
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."CORPORATEACTIONBONUS" 
   (	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"RATIONUMERATOR" NUMBER, 
	"RATIODENOMENATOR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CORPORATEACTIONDIVIDEND
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."CORPORATEACTIONDIVIDEND" 
   (	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"DIVIDENDPERCENTAGE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CORPORATEACTIONSPLITS
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."CORPORATEACTIONSPLITS" 
   (	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"SPLITNUMERATOR" NUMBER, 
	"SPLITDENOMINATOR" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EQUITYBORROWINGRATE
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."EQUITYBORROWINGRATE" 
   (	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"BORROWINGRATE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EQUITYDETAILS
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."EQUITYDETAILS" 
   (	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"COMPANYNAME" VARCHAR2(40 BYTE), 
	"FACEVALUE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FUNDBORROWINGRATE
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."FUNDBORROWINGRATE" 
   (	"CURRENCY" VARCHAR2(20 BYTE), 
	"BORROWINGRATE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRADELIST
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."TRADELIST" 
   (	"TRADEID" VARCHAR2(20 BYTE), 
	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"QUANTITY" NUMBER, 
	"PRICE" FLOAT(126), 
	"BUYER" VARCHAR2(20 BYTE), 
	"SELLER" VARCHAR2(20 BYTE), 
	"ADMINUSERNAME" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRADERCASHDETAILS
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."TRADERCASHDETAILS" 
   (	"TRADERID" VARCHAR2(20 BYTE), 
	"TRADERNAME" VARCHAR2(40 BYTE), 
	"FUNDSAVAILABLE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRADEREQUITYDETAILS
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."TRADEREQUITYDETAILS" 
   (	"TRADERID" VARCHAR2(20 BYTE), 
	"TICKERSYMBOL" VARCHAR2(20 BYTE), 
	"QUANTITY" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRADERLOGIN
--------------------------------------------------------

  CREATE TABLE "SETTLEMENT"."TRADERLOGIN" 
   (	"TRADERID" VARCHAR2(20 BYTE), 
	"TRADERUSERNAME" VARCHAR2(20 BYTE), 
	"TRADERPASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SETTLEMENT.ADMINLOGIN
SET DEFINE OFF;
Insert into SETTLEMENT.ADMINLOGIN (ADMINUSERNAME,ADMINPASSWORD) values ('SB64531','Sneha123');
Insert into SETTLEMENT.ADMINLOGIN (ADMINUSERNAME,ADMINPASSWORD) values ('RA63173','Rutuja123');
Insert into SETTLEMENT.ADMINLOGIN (ADMINUSERNAME,ADMINPASSWORD) values ('NB64186','Nishtha123');
Insert into SETTLEMENT.ADMINLOGIN (ADMINUSERNAME,ADMINPASSWORD) values ('admin','admin');
REM INSERTING into SETTLEMENT.CORPORATEACTIONBONUS
SET DEFINE OFF;
REM INSERTING into SETTLEMENT.CORPORATEACTIONDIVIDEND
SET DEFINE OFF;
REM INSERTING into SETTLEMENT.CORPORATEACTIONSPLITS
SET DEFINE OFF;
REM INSERTING into SETTLEMENT.EQUITYBORROWINGRATE
SET DEFINE OFF;
Insert into SETTLEMENT.EQUITYBORROWINGRATE (TICKERSYMBOL,BORROWINGRATE) values ('MSFT',7);
Insert into SETTLEMENT.EQUITYBORROWINGRATE (TICKERSYMBOL,BORROWINGRATE) values ('AAPL',8);
Insert into SETTLEMENT.EQUITYBORROWINGRATE (TICKERSYMBOL,BORROWINGRATE) values ('AMZN',9);
Insert into SETTLEMENT.EQUITYBORROWINGRATE (TICKERSYMBOL,BORROWINGRATE) values ('GOOG',8);
Insert into SETTLEMENT.EQUITYBORROWINGRATE (TICKERSYMBOL,BORROWINGRATE) values ('FB',7);
REM INSERTING into SETTLEMENT.EQUITYDETAILS
SET DEFINE OFF;
Insert into SETTLEMENT.EQUITYDETAILS (TICKERSYMBOL,COMPANYNAME,FACEVALUE) values ('MSFT','Microsoft Corporation','0.5');
Insert into SETTLEMENT.EQUITYDETAILS (TICKERSYMBOL,COMPANYNAME,FACEVALUE) values ('AAPL','Apple Inc.','0.05');
Insert into SETTLEMENT.EQUITYDETAILS (TICKERSYMBOL,COMPANYNAME,FACEVALUE) values ('AMZN','Amazon.com, Inc.','0.3');
Insert into SETTLEMENT.EQUITYDETAILS (TICKERSYMBOL,COMPANYNAME,FACEVALUE) values ('GOOG','Alphabet Inc.','0.04');
Insert into SETTLEMENT.EQUITYDETAILS (TICKERSYMBOL,COMPANYNAME,FACEVALUE) values ('FB','Facebook, Inc.','0.5');
REM INSERTING into SETTLEMENT.FUNDBORROWINGRATE
SET DEFINE OFF;
Insert into SETTLEMENT.FUNDBORROWINGRATE (CURRENCY,BORROWINGRATE) values ('usd',1.25);
Insert into SETTLEMENT.FUNDBORROWINGRATE (CURRENCY,BORROWINGRATE) values ('inr',1.1);
Insert into SETTLEMENT.FUNDBORROWINGRATE (CURRENCY,BORROWINGRATE) values ('jpy',1.15);
REM INSERTING into SETTLEMENT.TRADELIST
SET DEFINE OFF;
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('3','MSFT',9882,94.40968797436656,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('4','MSFT',7945,101.44960619941467,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('5','GOOG',2384,297.56038236922836,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('6','AAPL',6933,200.99951109874115,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('7','AAPL',1765,202.15533346247787,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('8','MSFT',6186,98.1195944381408,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('9','AMZN',7445,50.08431723730986,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('10','MSFT',3360,104.65408521723681,'JPM','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('11','FB',8466,525.2741020562632,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('12','FB',5047,476.11348255055617,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('13','AMZN',9165,48.8952575987929,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('14','AAPL',8889,206.15849033880795,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('15','AMZN',4277,45.597933990436694,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('16','AAPL',1000,214.57997208738706,'JPM','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('17','MSFT',6549,91.36907173330954,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('18','AMZN',4895,45.95994854029429,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('19','AAPL',1223,194.4592350036285,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('20','GOOG',2195,311.26459875285343,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('21','AAPL',5908,189.03040082568532,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('22','GOOG',5387,290.805667343647,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('23','GOOG',8450,277.71935027330574,'JPM','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('24','AMZN',705,52.36524704994719,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('25','AMZN',6585,53.71844812537958,'CIT','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('26','GOOG',1433,305.399897376852,'CIT','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('27','AMZN',3851,46.561880064277446,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('28','GOOG',4248,310.7112475116194,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('29','AMZN',5348,45.34252829083118,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('30','GOOG',6982,325.7004774163489,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('31','GOOG',3609,328.93669582036114,'JPM','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('32','AAPL',5666,196.92902135964897,'CIT','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('33','GOOG',7357,318.5998161921227,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('34','AMZN',2646,50.08978076850611,'CIT','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('35','GOOG',5517,307.1645603124849,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('36','AAPL',1330,201.48511603818767,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('37','MSFT',3399,102.17858813901117,'CIT','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('38','MSFT',4516,107.9761262130553,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('39','FB',7607,479.2274954506993,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('40','AAPL',4451,218.89662428250864,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('41','AMZN',4281,47.606291749819434,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('42','AMZN',657,50.70511328713689,'JPM','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('43','GOOG',3507,291.7933690831892,'BCS','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('44','GOOG',3696,281.33296525539316,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('45','MSFT',7309,97.11255093014042,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('46','FB',6303,530.9510794592984,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('47','AMZN',9669,51.49552985806455,'DB','JPM','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('48','AMZN',6790,52.0075294287857,'BCS','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('49','GOOG',6881,305.2625880042351,'DB','BCS','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('50','MSFT',2241,93.05186600802543,'DB','CIT','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('1','MSFT',5781,97.93046842163346,'JPM','DB','admin');
Insert into SETTLEMENT.TRADELIST (TRADEID,TICKERSYMBOL,QUANTITY,PRICE,BUYER,SELLER,ADMINUSERNAME) values ('2','MSFT',2476,92.48271656309869,'JPM','CIT','admin');
REM INSERTING into SETTLEMENT.TRADERCASHDETAILS
SET DEFINE OFF;
Insert into SETTLEMENT.TRADERCASHDETAILS (TRADERID,TRADERNAME,FUNDSAVAILABLE) values ('1','Goldman Sachs',5500000);
Insert into SETTLEMENT.TRADERCASHDETAILS (TRADERID,TRADERNAME,FUNDSAVAILABLE) values ('2','JP Morgan Chase',5322113);
Insert into SETTLEMENT.TRADERCASHDETAILS (TRADERID,TRADERNAME,FUNDSAVAILABLE) values ('3','Barclays',4321232);
Insert into SETTLEMENT.TRADERCASHDETAILS (TRADERID,TRADERNAME,FUNDSAVAILABLE) values ('4','Deutsche Bank',982122);
Insert into SETTLEMENT.TRADERCASHDETAILS (TRADERID,TRADERNAME,FUNDSAVAILABLE) values ('5','Citigroup',1234232);
REM INSERTING into SETTLEMENT.TRADEREQUITYDETAILS
SET DEFINE OFF;
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('1','FB',40000);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('3','MSFT',33);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('3','AAPL',32425);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('3','GOOG',2343262);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('3','AMZN',12224);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('4','FB',5000);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('4','MSFT',300);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('1','MSFT',13242);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('4','AAPL',132213);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('4','GOOG',5343);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('4','AMZN',234241);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('5','FB',2452);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('5','MSFT',243321);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('5','AAPL',2432);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('5','GOOG',454332);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('1','AAPL',23556);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('1','GOOG',57644);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('1','AMZN',3532);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('2','FB',35634);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('2','MSFT',3454362);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('2','AAPL',574534);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('2','GOOG',245221);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('2','AMZN',464353);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('3','FB',242623);
Insert into SETTLEMENT.TRADEREQUITYDETAILS (TRADERID,TICKERSYMBOL,QUANTITY) values ('5','AMZN',45241);
REM INSERTING into SETTLEMENT.TRADERLOGIN
SET DEFINE OFF;
Insert into SETTLEMENT.TRADERLOGIN (TRADERID,TRADERUSERNAME,TRADERPASSWORD) values ('1','GS','goldman123');
Insert into SETTLEMENT.TRADERLOGIN (TRADERID,TRADERUSERNAME,TRADERPASSWORD) values ('2','JPM','jpmorgan123');
Insert into SETTLEMENT.TRADERLOGIN (TRADERID,TRADERUSERNAME,TRADERPASSWORD) values ('3','BCS','barclay123');
Insert into SETTLEMENT.TRADERLOGIN (TRADERID,TRADERUSERNAME,TRADERPASSWORD) values ('6','DB','dhuss123');
Insert into SETTLEMENT.TRADERLOGIN (TRADERID,TRADERUSERNAME,TRADERPASSWORD) values ('7','CITI','citi123');
--------------------------------------------------------
--  DDL for Index ADMINLOGIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."ADMINLOGIN_PK" ON "SETTLEMENT"."ADMINLOGIN" ("ADMINUSERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CORPORATEACTIONBONUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."CORPORATEACTIONBONUS_PK" ON "SETTLEMENT"."CORPORATEACTIONBONUS" ("TICKERSYMBOL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CORPORATEACTIONDIVIDEND_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."CORPORATEACTIONDIVIDEND_PK" ON "SETTLEMENT"."CORPORATEACTIONDIVIDEND" ("TICKERSYMBOL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EQUITYBORROWINGRATE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."EQUITYBORROWINGRATE_PK" ON "SETTLEMENT"."EQUITYBORROWINGRATE" ("TICKERSYMBOL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index EQUITYDETAILS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."EQUITYDETAILS_PK" ON "SETTLEMENT"."EQUITYDETAILS" ("TICKERSYMBOL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FUNDBORROWINGRATE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."FUNDBORROWINGRATE_PK" ON "SETTLEMENT"."FUNDBORROWINGRATE" ("CURRENCY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TRADERCASHDETAILS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."TRADERCASHDETAILS_PK" ON "SETTLEMENT"."TRADERCASHDETAILS" ("TRADERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index TRADERLOGIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SETTLEMENT"."TRADERLOGIN_PK" ON "SETTLEMENT"."TRADELIST" ("TRADEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table ADMINLOGIN
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."ADMINLOGIN" ADD CONSTRAINT "ADMINLOGIN_PK" PRIMARY KEY ("ADMINUSERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."ADMINLOGIN" MODIFY ("ADMINPASSWORD" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."ADMINLOGIN" MODIFY ("ADMINUSERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CORPORATEACTIONBONUS
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."CORPORATEACTIONBONUS" ADD CONSTRAINT "CORPORATEACTIONBONUS_PK" PRIMARY KEY ("TICKERSYMBOL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."CORPORATEACTIONBONUS" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CORPORATEACTIONDIVIDEND
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."CORPORATEACTIONDIVIDEND" ADD CONSTRAINT "CORPORATEACTIONDIVIDEND_PK" PRIMARY KEY ("TICKERSYMBOL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."CORPORATEACTIONDIVIDEND" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EQUITYBORROWINGRATE
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."EQUITYBORROWINGRATE" ADD CONSTRAINT "EQUITYBORROWINGRATE_PK" PRIMARY KEY ("TICKERSYMBOL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."EQUITYBORROWINGRATE" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EQUITYDETAILS
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."EQUITYDETAILS" MODIFY ("FACEVALUE" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."EQUITYDETAILS" ADD CONSTRAINT "EQUITYDETAILS_PK" PRIMARY KEY ("TICKERSYMBOL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."EQUITYDETAILS" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."EQUITYDETAILS" MODIFY ("COMPANYNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FUNDBORROWINGRATE
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."FUNDBORROWINGRATE" ADD CONSTRAINT "FUNDBORROWINGRATE_PK" PRIMARY KEY ("CURRENCY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."FUNDBORROWINGRATE" MODIFY ("CURRENCY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRADELIST
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."TRADELIST" ADD CONSTRAINT "TRADERLOGIN_PK" PRIMARY KEY ("TRADEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("ADMINUSERNAME" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("SELLER" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("BUYER" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADELIST" MODIFY ("TRADEID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRADERCASHDETAILS
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."TRADERCASHDETAILS" ADD CONSTRAINT "TRADERCASHDETAILS_PK" PRIMARY KEY ("TRADERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SETTLEMENT"."TRADERCASHDETAILS" MODIFY ("TRADERID" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADERCASHDETAILS" MODIFY ("FUNDSAVAILABLE" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADERCASHDETAILS" MODIFY ("TRADERNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRADEREQUITYDETAILS
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."TRADEREQUITYDETAILS" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADEREQUITYDETAILS" MODIFY ("TICKERSYMBOL" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADEREQUITYDETAILS" MODIFY ("TRADERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRADERLOGIN
--------------------------------------------------------

  ALTER TABLE "SETTLEMENT"."TRADERLOGIN" MODIFY ("TRADERPASSWORD" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADERLOGIN" MODIFY ("TRADERUSERNAME" NOT NULL ENABLE);
  ALTER TABLE "SETTLEMENT"."TRADERLOGIN" MODIFY ("TRADERID" NOT NULL ENABLE);
