SELECT tfinal.NOMBRE_TABLA,tfinal.NUM_COLUMNAS,COALESCE(tfinal.NUM_COLS_NULLABLE,0),COALESCE(tfinal.NUM_COLS_FK,0)
FROM (SELECT tcols.NOMBRE_TABLA,tcols.NUM_COLUMNAS,tcolsnull.NUM_COLS_NULLABLE,tcolsfks.NUM_COLS_FK
      FROM (SELECT TABLE_NAME AS NOMBRE_TABLA,COUNT(*)AS NUM_COLUMNAS
            FROM ALL_TAB_COLUMNS
            WHERE OWNER = 'PARRANDEROS'
            GROUP BY TABLE_NAME)tcols 
            FULL OUTER JOIN 
            (SELECT TABLE_NAME AS NOMBRE_TABLA, COUNT(*) AS NUM_COLS_NULLABLE
            FROM ALL_TAB_COLUMNS
            WHERE OWNER = 'PARRANDEROS' AND NULLABLE = 'Y'
            GROUP BY TABLE_NAME)tcolsnull 
            ON tcols.NOMBRE_TABLA=tcolsnull.NOMBRE_TABLA
            FULL OUTER JOIN
            (SELECT TABLE_NAME AS NOMBRE_TABLA, COUNT(*) AS NUM_COLS_FK
            FROM ALL_CONSTRAINTS
            WHERE OWNER = 'PARRANDEROS' 
            AND CONSTRAINT_TYPE = 'R'
            GROUP BY TABLE_NAME)tcolsfks
            ON tcols.NOMBRE_TABLA=tcolsfks.NOMBRE_TABLA)tfinal
ORDER BY tfinal.NOMBRE_TABLA;