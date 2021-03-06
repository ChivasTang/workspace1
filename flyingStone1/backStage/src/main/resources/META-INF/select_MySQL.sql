SELECT * FROM m_user;
UPDATE m_user SET password='$2a$10$/R6b5d6aBOBbpCU6J78mHuaN5nEyhXgha4xdu07eNrXk/EapQEJk6' WHERE user_id<>0;
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
ORDER BY rur.role_id ASC