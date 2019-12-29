SELECT username, password FROM m_user WHERE username=? AND locked=1;
SELECT * FROM m_role;
SELECT
        rur.role_id
        ,mr.role
        ,mr.role_name
        , mr.create_user
        , mr.created
        , mr.update_user
        , mr.updated
        , mr.locked
FROM r_user_role rur
    LEFT JOIN m_role mr ON rur.role_id=mr.role_id
WHERE rur.user_id=1;

