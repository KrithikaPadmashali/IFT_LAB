
SELECT * FROM CUST_CL;
SELECT * FROM CUST_ID;
SELECT * FROM CUST_DETAILS;
SELECT * FROM CUST_NAME;
SELECT * FROM CUST_POI;
SELECT * FROM CUST_ADDRESS;
SELECT * FROM CUST_CI;
UPDATE CUST_CL 
SET CSTCL_TYP_VALUE = 'MIDDLE_NAME UPDATED', CSTCL_USER_ID = 'user_updated' 
WHERE CSTCL_ID = 2;
UPDATE CUST_ID 
SET CUSTID_ITEM = 'A123456789' 
WHERE CST_ID = 1001;
UPDATE CUST_DETAILS 
SET CSTDET_CONTACT = 'John Updated', CSTDET_MOBILE = '987-654-3210'
WHERE CST_ID = 1001;


DELETE FROM CUST_CL WHERE CSTCL_ID = 5;
DELETE FROM CUST_ID WHERE CST_ID = 1003;
DELETE FROM CUST_DETAILS WHERE CST_ID = 1001;
