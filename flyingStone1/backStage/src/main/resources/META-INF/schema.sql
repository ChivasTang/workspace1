DROP TABLE R_USER_ROLES;
DROP TABLE R_ROLE_PERMISSIONS;
DROP TABLE M_USER;
DROP TABLE M_ROLE;
DROP TABLE M_PERMISSION;

CREATE TABLE M_PERMISSION
(
    PERMISSION_ID NUMBER(10,0),-- リンクId
    PERMISSION_NAME VARCHAR2(255) NOT NULL UNIQUE ,-- リンク名
    DESCRIPTION VARCHAR2(255) NOT NULL ,-- 説明
    LINK VARCHAR2(255) NOT NULL ,-- リンクの内容
    CREATE_USER VARCHAR2(255) NOT NULL ,-- 作成ユーザ
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 作成日付
    UPDATE_USER VARCHAR2(255) DEFAULT NULL,-- 更新ユーザ
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 更新日付
    DEL_KBN NUMBER(1,0) DEFAULT 1, -- 有効区分
    CONSTRAINT PK_M_PERMISSION PRIMARY KEY (PERMISSION_ID)
);

CREATE TABLE M_ROLE
(
    ROLE_ID NUMBER(10,0),-- ロールId
    ROLE VARCHAR2(255) NOT NULL UNIQUE ,-- ロール名
    ROLE_NAME VARCHAR2(255) NOT NULL ,-- ロールの表示名
    DESCRIPTION VARCHAR2(255) NOT NULL ,-- 説明
    CREATE_USER VARCHAR2(255) NOT NULL ,-- 作成ユーザ
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 作成日付
    UPDATE_USER VARCHAR2(255) DEFAULT NULL,-- 更新ユーザ
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 更新日付
    DEL_KBN NUMBER(1,0) DEFAULT 1, -- 有効区分
    CONSTRAINT PK_M_ROLE PRIMARY KEY (ROLE_ID)
);

CREATE TABLE R_ROLE_PERMISSIONS
(
    ROLE_ID NUMBER(10,0),-- ロールId
    PERMISSION_ID NUMBER(10,0),-- リンクId
    CREATE_USER VARCHAR2(255) NOT NULL ,-- 作成ユーザ
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 作成日付
    UPDATE_USER VARCHAR2(255) DEFAULT NULL,-- 更新ユーザ
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 更新日付
    DEL_KBN NUMBER(1,0) DEFAULT 1, -- 有効区分
    CONSTRAINT FK_M_ROLE_R_ROLE_PERMISSION FOREIGN KEY (ROLE_ID) REFERENCES M_ROLE(ROLE_ID),
    CONSTRAINT FK_M_PERMISSION_R_ROLE_PERMISSION FOREIGN KEY (PERMISSION_ID) REFERENCES M_PERMISSION(PERMISSION_ID),
    CONSTRAINT PK_R_ROLE_PERMISSION PRIMARY KEY (ROLE_ID,PERMISSION_ID)
);

CREATE TABLE M_USER
(
    USER_ID NUMBER(10,0),-- ユーザId
    USERNAME VARCHAR2(255) NOT NULL UNIQUE ,-- ユーザ名
    EMAIL VARCHAR2(255) NOT NULL UNIQUE ,-- イーメール
    PASSWORD VARCHAR2(255) NOT NULL,-- パスワード
    FIRST_NAME VARCHAR2(255) NOT NULL ,-- 名前
    LAST_NAME VARCHAR2(255) NOT NULL ,-- 苗字
    BIRTHDAY DATE NOT NULL ,-- 生年月日
    CREATE_USER VARCHAR2(255) NOT NULL ,-- 作成ユーザ
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 作成日付
    UPDATE_USER VARCHAR2(255) DEFAULT NULL,-- 更新ユーザ
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 更新日付
    DEL_KBN NUMBER(1,0) DEFAULT 1, -- 有効区分
    CONSTRAINT PK_M_USER PRIMARY KEY (USER_ID)
);




CREATE TABLE R_USER_ROLES
(
    USER_ID NUMBER(10,0),-- ユーザId
    ROLE_ID NUMBER(10,0),-- ロールId
    CREATE_USER VARCHAR2(255) NOT NULL ,-- 作成ユーザ
    CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 作成日付
    UPDATE_USER VARCHAR2(255) DEFAULT NULL,-- 更新ユーザ
    UPDATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,-- 更新日付
    DEL_KBN NUMBER(1,0) DEFAULT 1, -- 有効区分
    CONSTRAINT FK_M_USER_R_USER_ROLE FOREIGN KEY (USER_ID) REFERENCES M_USER(USER_ID),
    CONSTRAINT FK_M_ROLE_R_USER_ROLE FOREIGN KEY (ROLE_ID) REFERENCES M_ROLE(ROLE_ID),
    CONSTRAINT PK_R_USER_ROLE PRIMARY KEY (USER_ID,ROLE_ID)
);

