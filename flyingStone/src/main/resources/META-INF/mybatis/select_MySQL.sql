SELECT * FROM m_user;
SELECT * FROM t_permission;
SELECT * FROM m_role;
SELECT * FROM r_user_roles;
SELECT
    rur.role_id
     , mr.role
     , mr.role_name
     , mr.create_user
     , mr.create_date
     , mr.update_user
     , mr.update_date
     , mr.del_kbn
FROM r_user_roles rur
LEFT JOIN m_user mu ON rur.user_id=mu.user_id
LEFT JOIN m_role mr ON rur.role_id=mr.role_id
WHERE rur.user_id=1
AND rur.del_kbn=0
AND mu.del_kbn=0
AND mr.del_kbn=0
ORDER BY rur.role_id ASC;

CREATE TABLE flyingStone.t_root_permission (
    root_permission_id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'root_permission_id',
    icon VARCHAR(255) NOT NULL COMMENT 'icon名',
    code VARCHAR(255) NOT NULL COMMENT '多言語用コード',
    emoji VARCHAR(255) NOT NULL COMMENT '絵文字',
    encoded TINYINT(1) DEFAULT 0 COMMENT 'エンコード可否',
    expanded TINYINT(1) DEFAULT 0 COMMENT '展開可否',
    create_user VARCHAR(255) NOT NULL COMMENT '作成ユーザ',
    create_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成日付',
    update_user VARCHAR(255) DEFAULT NULL COMMENT '更新ユーザ',
    update_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日付',
    del_kbn   TINYINT(1)   DEFAULT 0 COMMENT '有効区分',
    PRIMARY KEY (root_permission_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_bin
    AUTO_INCREMENT = 1;

CREATE TABLE flyingStone.t_parent_permission (
    parent_permission_id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'parent_permission_id',
    root_permission_id BIGINT NOT NULL COMMENT 'root_permission_id',
    icon VARCHAR(255) NOT NULL COMMENT 'icon名',
    code VARCHAR(255) NOT NULL COMMENT '多言語用コード',
    cssClass VARCHAR(255) NOT NULL COMMENT 'カスタマ外観',
    encoded TINYINT(1) DEFAULT 0 COMMENT 'エンコード可否',
    expanded TINYINT(1) DEFAULT 0 COMMENT '展開可否',
    create_user VARCHAR(255) NOT NULL COMMENT '作成ユーザ',
    create_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成日付',
    update_user VARCHAR(255) DEFAULT NULL COMMENT '更新ユーザ',
    update_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日付',
    del_kbn   TINYINT(1)   DEFAULT 0 COMMENT '有効区分',
    PRIMARY KEY (parent_permission_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_bin
    AUTO_INCREMENT = 1;

CREATE TABLE flyingStone.t_permission (
    permission_id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'permission_id',
    parent_permission_id BIGINT NOT NULL COMMENT 'parent_permission_id',
    root_permission_id BIGINT NOT NULL COMMENT 'root_permission_id',
    icon VARCHAR(255) DEFAULT NULL COMMENT 'icon名',
    code VARCHAR(255) NOT NULL COMMENT 'Nav名称コード',
    encoded TINYINT(1) DEFAULT 0 COMMENT 'エンコード可否',
    cssClass VARCHAR(255) NOT NULL COMMENT 'カスタマ外観',
    link VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'リンク',
    type VARCHAR(255) NOT NULL COMMENT 'リンクタイプ',
    create_user VARCHAR(255) NOT NULL COMMENT '作成ユーザ',
    create_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP COMMENT '作成日付',
    update_user VARCHAR(255) DEFAULT NULL COMMENT '更新ユーザ',
    update_date     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日付',
    del_kbn   TINYINT(1)   DEFAULT 0 COMMENT '有効区分',
    PRIMARY KEY (permission_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8
    COLLATE = utf8_bin
    AUTO_INCREMENT = 1;