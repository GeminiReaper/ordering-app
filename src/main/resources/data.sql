
INSERT INTO product (product_name, product_description) VALUES ('Water Valve', 'Part needed to replace a portion of piping for any type of water system');
INSERT INTO product (product_name, product_description) VALUES ('Washer', 'Necessary piece to ensure that nuts and bolts do not buckle from the tension against each other');
INSERT INTO product (product_name, product_description) VALUES ('Power Supply Unit', 'Part that provides power from an outlet to whatever device it connects to');
INSERT INTO product (product_name, product_description) VALUES ('Piping', 'replacement pipe for any water based piping');

INSERT INTO ORDER_LIST (last_name, first_name, company_name, email, contact_number, creation_date, due_date)
VALUES ('Williams', 'Nick','Vista', 'nick.williams@vista.com', '245-414-5954', CURRENT_DATE, PARSEDATETIME('26 Jul 2020, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'));

INSERT INTO ORDER_LIST (last_name, first_name, company_name, email, contact_number, creation_date, due_date)
VALUES ('Matthiu', 'Tim','OpenShift', 'tim.matthiu@openshift.com', '583-555-3820', CURRENT_DATE, PARSEDATETIME('26 Jul 2020, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'));

INSERT INTO ORDER_LIST (last_name, first_name, company_name, email, contact_number, creation_date, due_date)
VALUES ('Flores', 'Samantha','Halls', 'sam.flores@halls.com', '158-565-8888', CURRENT_DATE, PARSEDATETIME('26 Jul 2020, 05:15:58 AM','dd MMM yyyy, hh:mm:ss a','en'));


INSERT INTO ordered_product (product_id, quantity, created_date, order_list_id) VALUES(1, 4, CURRENT_DATE, 1);
INSERT INTO ordered_product (product_id, quantity, created_date, order_list_id) VALUES(2, 2, CURRENT_DATE, 1);
INSERT INTO ordered_product (product_id, quantity, created_date, order_list_id) VALUES(2, 3, CURRENT_DATE, 2);

