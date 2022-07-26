SELECT 
    employee_id
FROM
    Employees E
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            Salaries S
        WHERE
            E.employee_id = S.employee_id) 
UNION SELECT 
    employee_id
FROM
    Salaries S
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            Employees E
        WHERE
            E.employee_id = S.employee_id)
ORDER BY employee_id