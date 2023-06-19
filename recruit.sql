/*
 Navicat Premium Data Transfer

 Source Server         : Postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 150003 (150003)
 Source Host           : 10.100.164.47:5432
 Source Catalog        : recruit
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150003 (150003)
 File Encoding         : 65001

 Date: 19/06/2023 16:10:22
*/


-- ----------------------------
-- Table structure for Account
-- ----------------------------
DROP TABLE IF EXISTS "public"."Account";
CREATE TABLE "public"."Account" (
  "UUID" int8 NOT NULL,
  "Username" varchar(10) COLLATE "pg_catalog"."default",
  "Password" varchar(20) COLLATE "pg_catalog"."default",
  "Role" varchar(8) COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for BossInfo
-- ----------------------------
DROP TABLE IF EXISTS "public"."BossInfo";
CREATE TABLE "public"."BossInfo" (
  "UUID" int8 NOT NULL,
  "Name" varchar(20) COLLATE "pg_catalog"."default",
  "Company_Name" varchar(30) COLLATE "pg_catalog"."default",
  "Address" varchar(30) COLLATE "pg_catalog"."default",
  "Introduction" text COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for Job
-- ----------------------------
DROP TABLE IF EXISTS "public"."Job";
CREATE TABLE "public"."Job" (
  "UUID" int8 NOT NULL,
  "Type_UUID" int8,
  "Boss_UUID" int8,
  "Name" varchar(20) COLLATE "pg_catalog"."default",
  "type" varchar(10) COLLATE "pg_catalog"."default",
  "Salary_num" numeric(10,2),
  "Salary_unit" varchar(10) COLLATE "pg_catalog"."default",
  "Description" text COLLATE "pg_catalog"."default",
  "Requirement" text COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for Recruit
-- ----------------------------
DROP TABLE IF EXISTS "public"."Recruit";
CREATE TABLE "public"."Recruit" (
  "UUID" int8 NOT NULL,
  "Seeker_UUID" int8,
  "Job_UUID" int8,
  "Resume_UUID" int8,
  "Status" varchar(5) COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for Resume
-- ----------------------------
DROP TABLE IF EXISTS "public"."Resume";
CREATE TABLE "public"."Resume" (
  "UUID" int8 NOT NULL,
  "Seeker_UUID" int8,
  "content" text COLLATE "pg_catalog"."default",
  "type" varchar(4) COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for SeekerInfo
-- ----------------------------
DROP TABLE IF EXISTS "public"."SeekerInfo";
CREATE TABLE "public"."SeekerInfo" (
  "UUID" int8 NOT NULL,
  "Name" varchar(20) COLLATE "pg_catalog"."default",
  "ID" varchar(18) COLLATE "pg_catalog"."default",
  "email" varchar(30) COLLATE "pg_catalog"."default",
  "age" int2,
  "location" text COLLATE "pg_catalog"."default",
  "status" varchar(20) COLLATE "pg_catalog"."default",
  "salary_expected_num" numeric(10,2),
  "salary_expected_unit" varchar(10) COLLATE "pg_catalog"."default",
  "phone" varchar(11) COLLATE "pg_catalog"."default",
  "education" varchar(255) COLLATE "pg_catalog"."default",
  "Sex" varchar(10) COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Table structure for Talk
-- ----------------------------
DROP TABLE IF EXISTS "public"."Talk";
CREATE TABLE "public"."Talk" (
  "UUID" int8 NOT NULL,
  "Seeker_UUID" int8,
  "Boss_UUID" int8,
  "content" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for Type
-- ----------------------------
DROP TABLE IF EXISTS "public"."Type";
CREATE TABLE "public"."Type" (
  "UUID" int8 NOT NULL,
  "Father_UUID" int8,
  "content" varchar(10) COLLATE "pg_catalog"."default",
  "Version" int2
)
;

-- ----------------------------
-- Indexes structure for table Account
-- ----------------------------
CREATE UNIQUE INDEX "Account_Username_idx" ON "public"."Account" USING btree (
  "Username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table Account
-- ----------------------------
ALTER TABLE "public"."Account" ADD CONSTRAINT "Account_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table BossInfo
-- ----------------------------
ALTER TABLE "public"."BossInfo" ADD CONSTRAINT "BossInfo_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table Job
-- ----------------------------
ALTER TABLE "public"."Job" ADD CONSTRAINT "Job_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table Recruit
-- ----------------------------
ALTER TABLE "public"."Recruit" ADD CONSTRAINT "Recruit_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table Resume
-- ----------------------------
ALTER TABLE "public"."Resume" ADD CONSTRAINT "Resume_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table SeekerInfo
-- ----------------------------
ALTER TABLE "public"."SeekerInfo" ADD CONSTRAINT "SeekerInfo_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table Talk
-- ----------------------------
ALTER TABLE "public"."Talk" ADD CONSTRAINT "Talk_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Primary Key structure for table Type
-- ----------------------------
ALTER TABLE "public"."Type" ADD CONSTRAINT "Type_pkey" PRIMARY KEY ("UUID");

-- ----------------------------
-- Foreign Keys structure for table BossInfo
-- ----------------------------
ALTER TABLE "public"."BossInfo" ADD CONSTRAINT "BossInfo_UUID_fkey" FOREIGN KEY ("UUID") REFERENCES "public"."Account" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Job
-- ----------------------------
ALTER TABLE "public"."Job" ADD CONSTRAINT "Job_Boss_UUID_fkey" FOREIGN KEY ("Boss_UUID") REFERENCES "public"."BossInfo" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."Job" ADD CONSTRAINT "Job_Type_UUID_fkey" FOREIGN KEY ("Type_UUID") REFERENCES "public"."Type" ("UUID") ON DELETE SET NULL ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table Recruit
-- ----------------------------
ALTER TABLE "public"."Recruit" ADD CONSTRAINT "Recruit_Job_UUID_fkey" FOREIGN KEY ("Job_UUID") REFERENCES "public"."Job" ("UUID") ON DELETE SET NULL ON UPDATE NO ACTION;
ALTER TABLE "public"."Recruit" ADD CONSTRAINT "Recruit_Resume_UUID_fkey" FOREIGN KEY ("Resume_UUID") REFERENCES "public"."Resume" ("UUID") ON DELETE SET NULL ON UPDATE NO ACTION;
ALTER TABLE "public"."Recruit" ADD CONSTRAINT "Recruit_Seeker_UUID_fkey" FOREIGN KEY ("Seeker_UUID") REFERENCES "public"."SeekerInfo" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Resume
-- ----------------------------
ALTER TABLE "public"."Resume" ADD CONSTRAINT "Resume_Seeker_UUID_fkey" FOREIGN KEY ("Seeker_UUID") REFERENCES "public"."SeekerInfo" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table SeekerInfo
-- ----------------------------
ALTER TABLE "public"."SeekerInfo" ADD CONSTRAINT "SeekerInfo_UUID_fkey" FOREIGN KEY ("UUID") REFERENCES "public"."Account" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Talk
-- ----------------------------
ALTER TABLE "public"."Talk" ADD CONSTRAINT "Talk_Boss_UUID_fkey" FOREIGN KEY ("Boss_UUID") REFERENCES "public"."Account" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."Talk" ADD CONSTRAINT "Talk_Seeker_UUID_fkey" FOREIGN KEY ("Seeker_UUID") REFERENCES "public"."Account" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table Type
-- ----------------------------
ALTER TABLE "public"."Type" ADD CONSTRAINT "Type_Father_UUID_fkey" FOREIGN KEY ("Father_UUID") REFERENCES "public"."Type" ("UUID") ON DELETE CASCADE ON UPDATE NO ACTION;
