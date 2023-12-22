--product_option product_id 3번까지 추가
--선택안함
INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, null, '선택안함', 0);

--bath 옵션
INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 1, '스펀지 타월 S', 5900);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 1, '스펀지 타월 M', 18900);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 1, '스펀지 타월 L', 28900);

--food 옵션
INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 2, '닥터독 그레인프리 참치 사료 3.2kg', 55500);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 2, '닥터독 그레인프리 참치 사료 4.8kg', 78500);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 2, '피부모질 닥터독 사료 250g', 5000);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 2, '닥터독 그레인프리 동애등에 사료 200g', 4000);

--clothes 옵션
INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '차콜 S', 0);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '브라운 S', 0);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '차콜 M', 3500);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '브라운 M', 3500);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '차콜 L', 5000);

INSERT INTO PRODUCT_OPTION
(option_id, product_id, description, additional_price)
VALUES(PRODUCT_OPTION_SEQ.NEXTVAL, 3, '브라운 L', 5000);

