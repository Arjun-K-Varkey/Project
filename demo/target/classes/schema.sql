DROP TABLE IF EXISTS MUSIC;
 
CREATE TABLE MUSIC (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  singer VARCHAR(250) NOT NULL,
  time VARCHAR(250) DEFAULT NULL,
  playlist_id INT
);

DROP TABLE IF EXISTS PLAYLIST;
 
CREATE TABLE PLAYLIST (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
);

alter table MUSIC add constraint fki_playlist_id foreign key (playlist_id) references PLAYLIST(id);
