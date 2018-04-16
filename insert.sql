DELETE FROM rentals;
DELETE FROM sales;
DELETE FROM movies;
DELETE FROM employees;
DELETE FROM members;
DELETE FROM store;
DELETE FROM vendors;


INSERT INTO store VALUES (001, "123 Iverleigh Lane");
INSERT INTO store VALUES (002, "482 Echo Sound Drive");
INSERT INTO store VALUES (003, "549 Wayverly Place");

INSERT INTO employees VALUES (1001, "Kevin Johnson", 001, .05);
INSERT INTO employees VALUES (1002, "Stephen Childs", 001, .15);
INSERT INTO employees VALUES (1003, "Christopher Franklin", 001, .12);
INSERT INTO employees VALUES (2001, "Hubert Smith", 002, .20);
INSERT INTO employees VALUES (2002, "Gregory Shepard", 002, .15);
INSERT INTO employees VALUES (2003, "David Fourqurean", 002, .30);
INSERT INTO employees VALUES (3001, "Thelma Jean", 003, .17);
INSERT INTO employees VALUES (3002, "Bevlin James", 003, .18);
INSERT INTO employees VALUES (3003, "Jared Smith", 003, .21);

INSERT INTO vendors VALUES ("Yellow Dog Discs", "184 South College Road", "910-385-9950");
INSERT INTO vendors VALUES ("Disc Dealers", "169 Long Island Court", "365-867-5309");

INSERT INTO movies VALUES (59865, 00001, "Inception", 5.99, "Action", 0.99, 9.99, '2017-04-15', "Yellow Dog Discs", 10);
INSERT INTO movies VALUES (59866, 00002, "The Prestige", 5.99, "Drama", 0.99, 9.99, '2017-04-15', "Yellow Dog Discs", 8);
INSERT INTO movies VALUES (59867, 00003, "Harry Potter and the Sorcerers Stone", 3.99, "Fantasy", 0.99, 5.99, '2017-04-15', "Yellow Dog Discs", 3);
INSERT INTO movies VALUES (59868, 00004, "Looper", 5.99, "Action", 0.99, 9.99, '2017-04-15', "Yellow Dog Discs", 10);
INSERT INTO movies VALUES (59869, 00005, "Lion King", 3.99, "Fantasy", 0.99, 5.99, '2017-04-15', "Yellow Dog Discs", 5);
INSERT INTO movies VALUES (59870, 00006, "The Shawshank Redemption", 1.99, "Drama", 0.99, 3.99, '2017-04-15', "Yellow Dog Discs", 5);
INSERT INTO movies VALUES (59871, 00007, "The Dark Knight", 5.99, "Action", 0.99, 9.99, '2017-04-15', "Yellow Dog Discs", 6);
INSERT INTO movies VALUES (60145, 00008, "The Lord of the Rings: The Return of the King", 5.99, "Fantasy", 0.99, 9.99, '2017-05-01', "Disc Dealers", 8);
INSERT INTO movies VALUES (60146, 00009, "The Lord of the Rings: The Two Towers", 5.99, "Fantasy", 0.99, 9.99, '2017-05-01', "Disc Dealers", 6);
INSERT INTO movies VALUES (60147, 00010, "The Lord of the Rings: The Fellowship of the Ring", 5.99, "Fantasy", 0.99, 9.99, '2017-05-01', "Disc Dealers", 8);
INSERT INTO movies VALUES (60148, 00011, "Forrest Gump", 3.99, "Drama", 0.99, 6.99, '2017-05-01', "Disc Dealers", 3);
INSERT INTO movies VALUES (60149, 00012, "Interstellar", 5.99, "Sci-fi", 0.99, 9.99, '2017-05-01', "Disc Dealers", 10);
INSERT INTO movies VALUES (60150, 00013, "Whiplash", 5.99, "Drama", 0.99, 9.99, '2017-05-01', "Disc Dealers", 7);
INSERT INTO movies VALUES (60151, 00014, "Wall-E", 3.99, "Animated", 0.99, 5.99, '2017-05-01', "Disc Dealers", 3);
INSERT INTO movies VALUES (60152, 00015, "Toy Story 2", 2.99, "Animated", 0.99, 5.99, '2017-05-01', "Disc Dealers", 4);
INSERT INTO movies VALUES (60153, 00016, "Sharknado: The 4th Awakens", 0.99, "Sci-fi", 0.99, 1.99, '2017-05-01', "Disc Dealers", 1);
INSERT INTO movies VALUES (60154, 00017, "Stepbrothers", 3.99, "Comedy", 0.99, 5.99, '2017-05-01', "Disc Dealers", 5);
INSERT INTO movies VALUES (60155, 00018, "Shes the Man", 3.99, "Comedy", 0.99, 5.99, '2017-05-01', "Disc Dealers", 3);
INSERT INTO movies VALUES (60156, 00019, "Oculus", 5.99, "Horror", 0.99, 9.99, '2017-05-01', "Disc Dealers", 8);
INSERT INTO movies VALUES (60157, 00020, "Strangers", 3.99, "Horror", 0.99, 5.99, '2017-05-01', "Disc Dealers", 4);

INSERT INTO members VALUES(101, 'Stevens', 'Tony', '1515 Harris Street', 5);
INSERT INTO members VALUES(102, 'Saunders', 'Jessica', '615 Terrace Court', 0);
INSERT INTO members VALUES(103, 'Johnson', 'Danielle', '743 Long Street', 8);
INSERT INTO members VALUES(104, 'Brantley', 'Christina', '2752 Independence Ave', 1);
INSERT INTO members VALUES(105, 'Markham', 'Kaylee', '14 5th Street', 3);
INSERT INTO members VALUES(106, 'Coppick', 'Samuel', '68 Market Road', 6);
INSERT INTO members VALUES(107, 'Patterson', 'Greg', '1394 Wilmont Drive', 15);
INSERT INTO members VALUES(108, 'Brown', 'Alex', '916 Grayson Circle', 0);
INSERT INTO members VALUES(109, 'Warren', 'Jason', '1922 Community Drive', 7);
INSERT INTO members VALUES(110, 'Jones', 'Tyler', '2 2nd Street', 2);

INSERT INTO rentals VALUES (89402, 101, 00011, 60148, 1001, '5-10/month', '2017-05-15', '2017-05-18', '2017-05-16');
INSERT INTO rentals VALUES (89403, 107, 00011, 60148, 1001, '5-10/month', '2017-05-15', '2017-05-18', '2017-05-17');
INSERT INTO rentals VALUES (89404, 107, 00003, 59867, 1003, '2-3/month', '2017-05-16', '2017-05-19', '2017-05-17');
INSERT INTO rentals VALUES (89405, 110, 00011, 60148, 3003, '5-10/month', '2017-05-17', '2017-05-20', '2017-05-19');
INSERT INTO rentals VALUES (89406, 108, 00011, 60148, 2001, '5-10/month', '2017-05-23', '2017-05-26', '2017-05-24');
INSERT INTO rentals VALUES (89407, 109, 00011, 60148, 2002, '5-10/month', '2017-05-25', '2017-05-28', '2017-05-26');
INSERT INTO rentals VALUES (89408, 101, 00009, 60146, 1001, '2-3/month', '2017-06-27', '2017-06-30', '2017-06-29');
INSERT INTO rentals VALUES (89409, 106, 00015, 60152, 2002, '3-4/month', '2017-06-27', '2017-06-30', '2017-06-29');
INSERT INTO rentals VALUES (89410, 109, 00008, 60145, 3002, '1-2/month', '2017-07-04', '2017-07-07', '2017-07-08');
INSERT INTO rentals VALUES (89411, 103, 00008, 60145, 1002, '1-2/month', '2017-07-23', '2017-07-26', '2017-07-24');

INSERT INTO sales VALUES (10001, 102, 00001, 59865, 2002, '2017-07-20');
INSERT INTO sales VALUES (10002, 103, 00002, 59866, 3001, '2017-06-16');
INSERT INTO sales VALUES (10003, 108, 00003, 59867, 3001, '2017-06-23');
INSERT INTO sales VALUES (10004, 109, 00006, 59870, 3002, '2017-05-09');
INSERT INTO sales VALUES (10005, 110, 00006, 59870, 2003, '2017-08-10');
INSERT INTO sales VALUES (10006, 106, 00006, 59870, 2003, '2017-08-10');
INSERT INTO sales VALUES (10007, 108, 00007, 59871, 1001, '2017-10-31');

DELIMITER $$
CREATE TRIGGER controlDate BEFORE INSERT ON rentals
FOR EACH ROW
BEGIN
    SET NEW.date_out = thisDate();
    SET NEW.due_date = rentalTime(thisDate());
END $$
DELIMITER ;