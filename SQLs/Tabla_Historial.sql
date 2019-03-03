
  CREATE TABLE "C##HOSPITAL3"."HISTORIAL" 
   (	"RESCITA_ID" NUMBER(*,0) NOT NULL ENABLE, 
	"CITA_ID" NUMBER(*,0) NOT NULL ENABLE, 
	"DIAGNOSTICO" VARCHAR2(150 BYTE), 
	"COLUMN1" VARCHAR2(150 BYTE), 
	"MEDICINAS" VARCHAR2(150 BYTE), 
	"PASOSASEGUIR" VARCHAR2(150 BYTE), 
	"OBSERVACIONES" NVARCHAR2(150), 
	 CONSTRAINT "HISTORIAL_PK" PRIMARY KEY ("RESCITA_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
