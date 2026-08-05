CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

    DECLARE nsalary INT;
    DECLARE kmaxSal INT;
    Declare offsetval INT;

    set offsetval=N-1;

    SELECT COUNT(DISTINCT salary) into nsalary
    FROM Employee;

    IF N > nsalary THEN
        return Null;
    END IF;

    SELECT DISTINCT salary
    INTO kmaxSal
    FROM Employee
    ORDER BY salary DESC
    LIMIT offsetval, 1;

  RETURN kmaxSal;
END