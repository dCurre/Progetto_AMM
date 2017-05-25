/**
 * Author:  davide
 * Created: May 12, 2017
 */
--DB: dCurre ; user: dCurre; pass: 1234;

/* CREAZIONE DELLA TABELLA UTENTI */
CREATE TABLE UTENTI (ID INTEGER DEFAULT GENERATED_BY_DEFAULT  NOT NULL GENERATED ALWAYS AS IDENTITY, NOME VARCHAR(256), EMAIL VARCHAR(256) NOT NULL, PASSWORD VARCHAR(256) NOT NULL, URLFOTOPROFILO VARCHAR(256), FRASEPERSONALE VARCHAR(256), COGNOME VARCHAR(256), PRIMARY KEY (ID));

/* -Creazione degli utenti statici */
INSERT INTO DCURRE.UTENTI (NOME, EMAIL, PASSWORD, URLFOTOPROFILO, FRASEPERSONALE, COGNOME) 
	VALUES ('Davide', 'davidecurreli@mail.com', '123', '../img/fotoProfilo1.jpg', 'Welà', 'Curreli');
INSERT INTO DCURRE.UTENTI (NOME, EMAIL, PASSWORD, URLFOTOPROFILO, FRASEPERSONALE, COGNOME) 
	VALUES ('Gigi', 'ggserreli@mail.com', '123', '../img/fotoProfilo2.jpg', 'Ciaoo', 'Serreli');
INSERT INTO DCURRE.UTENTI (NOME, EMAIL, PASSWORD, URLFOTOPROFILO, FRASEPERSONALE, COGNOME) 
	VALUES ('Gesu', 'camminosullacqua@mail.com', '123', '../img/gesuFoto.jpg', 'Che Papà sia con te!', 'Cristo');
INSERT INTO DCURRE.UTENTI (NOME, EMAIL, PASSWORD, URLFOTOPROFILO, FRASEPERSONALE, COGNOME) 
	VALUES ('Andrea', 'andreamutolo@mail.com', '123', '../img/fotoProfilo3.jpg', 'We', 'Mutolo');
INSERT INTO DCURRE.UTENTI (NOME, EMAIL, PASSWORD, URLFOTOPROFILO, FRASEPERSONALE, COGNOME) 
	VALUES ('Incompleto', 'prova@mail.com', '123', '../img/fotoLandscapePost.jpg', NULL, 'gatto');




/* CREAZIONE DELLA TABELLA AMICIZIE*/
CREATE TABLE AMICIZIE (FOLLOWER INTEGER NOT NULL, FOLLOWED INTEGER NOT NULL, PRIMARY KEY (FOLLOWER, FOLLOWED));

/* -Creazione delle amicizie statiche*/
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (0, 1);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (0, 2);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (0, 3);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (0, 4);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (1, 0);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (1, 2);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (1, 3);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (2, 1);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (2, 3);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (3, 1);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (3, 2);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (3, 4);
INSERT INTO DCURRE.AMICIZIE (FOLLOWER, FOLLOWED) 
	VALUES (4, 2);




/* CREAZIONE DELLA TABELLA POSTS */
CREATE TABLE POSTS (ID INTEGER DEFAULT GENERATED_BY_DEFAULT  NOT NULL GENERATED ALWAYS AS IDENTITY, AUTHOR INTEGER, CONTENT VARCHAR(1024), IMG VARCHAR(1024), RICEVENTE INTEGER, APPARTENENZA_GRUPPO INTEGER, PRIMARY KEY (ID));

/* -Creazione post statici */
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'Auguri Gigi in ritardo!!', 'http://blog.giallozafferano.it/unacucinadasingle/wp-content/uploads/2015/10/Immagine.png', 1, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (3, 'Saluta il Capo!', NULL, NULL, 0);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, '', NULL, 0, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'buondino', NULL, 3, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'WE GRUPPO', NULL, NULL, 0);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'WE PIRLETTI', NULL, NULL, 2);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (2, 'Pace a te, figliuolo.', NULL, 3, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'wewe', NULL, NULL, 2);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'wewe', NULL, NULL, 2);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'Frase a caso1', NULL, 0, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (1, 'Frase a caso con immagine1', '../img/fotoLandscapePost.jpg', 1, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (2, 'Sempre sia lodato', NULL, 2, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (3, 'Frase a caso2', NULL, 3, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (2, 'Alzati e cammina', NULL, 2, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (2, 'Frase a caso con immagine2', 'http://static.qnm.it/www/fotogallery/1200X0/195073/selfie-sosia-di-gesu.jpg', 2, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (3, 'Frase a caso con immagine3', '../img/fotoLandscapePost.jpg', 3, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (1, 'Frase a caso3', NULL, 1, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (0, 'Frase a caso con immagine4', '../img/fotoLandscapePost.jpg', 0, NULL);
INSERT INTO DCURRE.POSTS (AUTHOR, CONTENT, IMG, RICEVENTE, APPARTENENZA_GRUPPO) 
	VALUES (3, 'Frase a caso con immagine5', '../img/allegatoProfilo2.jpg', 3, NULL);




/* CREAZIONE DELLA TABELLA GRUPPI */
CREATE TABLE GRUPPI (ID INTEGER DEFAULT GENERATED_BY_DEFAULT  NOT NULL GENERATED ALWAYS AS IDENTITY, NOME VARCHAR(256), URLFOTOGRUPPO VARCHAR(256), PRIMARY KEY (ID));

/* -Creazione gruppi statici */
INSERT INTO DCURRE.GRUPPI (NOME, URLFOTOGRUPPO) 
	VALUES ('Malati di viaggi', '../img/groupAirplane.png');
INSERT INTO DCURRE.GRUPPI (NOME, URLFOTOGRUPPO) 
	VALUES ('Cuochi provetti', '../img/groupCucina.png');
INSERT INTO DCURRE.GRUPPI (NOME, URLFOTOGRUPPO) 
	VALUES ('Iemi', '../img/groupFriends.png');




/* CREAZIONE DELLA TABELLA CHE GESTISCE LA POSSIBILITA' DI FAR PARTE DI UN GRUPPO*/
CREATE TABLE GRUPPI_APPARTENENZA (FOLLOWER INTEGER NOT NULL, FOLLOWED INTEGER NOT NULL, PRIMARY KEY (FOLLOWER, FOLLOWED));

/* -Creazione gruppi_appartenenza statici */
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (0, 0);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (0, 2);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (1, 1);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (1, 2);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (2, 0);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (2, 1);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (3, 0);
INSERT INTO DCURRE.GRUPPI_APPARTENENZA (FOLLOWER, FOLLOWED) 
	VALUES (3, 1);
