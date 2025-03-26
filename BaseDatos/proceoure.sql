DECLARE 
    PROCEDURE GET_contact (p_first_name in varchar2,... out_phone out varchar2)

    IS
    BEGIN
        SELECT email, phone into ,out_email,out_phone from employees where ...
    END;

BEGIN

    null;

end;