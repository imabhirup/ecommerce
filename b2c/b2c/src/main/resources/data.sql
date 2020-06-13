DROP TABLE IF EXISTS CUSTOMER,MEDIA,PRODUCT,CATALOG,STORE;

CREATE TABLE CUSTOMER (
    EMAIL varchar(255),
    ID long,
    FIRSTNAME varchar(255),
    LASTNAME varchar(255),
    PHONE varchar(255),
    PASSWORD varchar(255)
);

CREATE TABLE STORE(ID VARCHAR(255) PRIMARY KEY,
   NAME VARCHAR(255), CURRENCY VARCHAR(255));


CREATE TABLE CATALOG(ID VARCHAR(255) PRIMARY KEY,
   NAME VARCHAR(255), STORE_ID VARCHAR(255), FOREIGN KEY (STORE_ID) REFERENCES STORE(ID));

CREATE TABLE PRODUCT(ID VARCHAR(255) PRIMARY KEY,
   NAME VARCHAR(255),DESCRIPTION VARCHAR(1000), WEIGHT VARCHAR(255), DIMENSION VARCHAR(255),
   COLOR VARCHAR(255), SIZE VARCHAR(255),
PRICE VARCHAR(255), CATALOG_ID VARCHAR(255),
 FOREIGN KEY(CATALOG_ID) REFERENCES CATALOG(ID));


CREATE TABLE MEDIA(ID VARCHAR(255) PRIMARY KEY, PICTURE VARBINARY (MAX), PRODUCT_ID VARCHAR(255),
FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCT(ID));

INSERT INTO STORE VALUES('store', 'store name','INR');

INSERT INTO CATALOG VALUES('catalog', 'test catalog','store');
INSERT INTO PRODUCT VALUES('888', 'PLEATED BALLOON JEANS','Aenean sit amet gravida nisi. Nam fermentum est felis, quis feugiat nunc fringilla sit amet. Ut in blandit ipsum. Quisque luctus dui at ante aliquet, in hendrerit lectus interdum. Morbi elementum sapien rhoncus pretium maximus. Nulla lectus enim, cursus et elementum sed, sodales vitae eros. Ut ex quam, porta consequat interdum in, faucibus eu velit. Quisque rhoncus ex ac libero varius molestie. Aenean tempor sit amet orci nec iaculis. Cras sit amet nulla libero. Curabitur dignissim, nunc nec laoreet consequat, purus nunc porta lacus, vel efficitur tellus augue in ipsum. Cras in arcu sed metus rutrum iaculis. Nulla non tempor erat. Duis in egestas nunc','0.79KG','110 x 33 x 100cm','Black, Blue, Grey, Green, Red, White', 'XL, L, M, S','100', 'catalog');
INSERT INTO MEDIA VALUES('media1', FILE_READ('857910001_01_Front.jpg'), '888');
INSERT INTO MEDIA VALUES('media2', FILE_READ('857910001_02_Back.jpg'), '888');

INSERT INTO PRODUCT VALUES('999', 'PLEATED BALLOON JEANS','Aenean sit amet gravida nisi. Nam fermentum est felis, quis feugiat nunc fringilla sit amet. Ut in blandit ipsum. Quisque luctus dui at ante aliquet, in hendrerit lectus interdum. Morbi elementum sapien rhoncus pretium maximus. Nulla lectus enim, cursus et elementum sed, sodales vitae eros. Ut ex quam, porta consequat interdum in, faucibus eu velit. Quisque rhoncus ex ac libero varius molestie. Aenean tempor sit amet orci nec iaculis. Cras sit amet nulla libero. Curabitur dignissim, nunc nec laoreet consequat, purus nunc porta lacus, vel efficitur tellus augue in ipsum. Cras in arcu sed metus rutrum iaculis. Nulla non tempor erat. Duis in egestas nunc','0.79KG','110 x 33 x 100cm','Black, Blue, Grey, Green, Red, White', 'XL, L, M, S','100', 'catalog');
INSERT INTO MEDIA VALUES('media3', FILE_READ('product-01.jpg'), '999');
INSERT INTO MEDIA VALUES('media4', FILE_READ('product-10.jpg'), '999');
INSERT INTO MEDIA VALUES('media5', FILE_READ('product-13.jpg'), '999');

