
INSERT INTO User (ID, NAME,PHONE_NUMBER,PASSWORD,EMAIL, USER_LOCATION, BIRTH_DATE ) 
VALUES(10001,  'Sudhanshu', 8100889366,'Sudhanshu','sudhanshu@iiitkalyani.ac.in','Muzaffarur',sysdate());

INSERT INTO User (ID, NAME,PHONE_NUMBER,PASSWORD,EMAIL, USER_LOCATION, BIRTH_DATE ) 
VALUES(10002,  'Sudhanshu', 8100889366,'Sudhanshu','sudhanshu@ii.ac.in','Muzaffarur',sysdate());


INSERT INTO User (ID, NAME,PHONE_NUMBER,PASSWORD,EMAIL, USER_LOCATION, BIRTH_DATE ) 
VALUES(10003,  'Sudhanshu', 8100889366,'Sudhanshu','sudhanshu@iiitk.ac.in','Muzaffarur',sysdate());

insert into client (id, email, liscence_number,location,name)
values(2001,'sudha@gmail.com','123456','bengaluru','Honda');


insert into client (id, email, liscence_number,location,name)
values(2002,'sudhaRash@gmail.com','123456','bengaluru','Hero');


insert into product (id, category, exp_date,name,price,stock_available,client_id)
values(3001,'motorbike',sysdate(),'Navi',50000.0,5,2001);

insert into product (id, category, exp_date,name,price,stock_available,client_id)
values(3002,'scooty',sysdate(),'activa',40000.0,4,2001);


insert into cart (id, no_of_products, price_total,user_id)
values(4001,1,50000.0,10001);

insert into cart (id, no_of_products, price_total,user_id)
values(4002,1,50000.0,10002);


insert into Cart_Product (cart_id,product_id)
values(4001,3001);
insert into Cart_Product (cart_id,product_id)
values(4002,3002);
insert into Cart_Product (cart_id,product_id)
values(4002,3001);