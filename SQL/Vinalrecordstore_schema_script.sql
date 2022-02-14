DROP DATABASE IF EXISTS vinylrecordshop;
CREATE DATABASE vinylrecordshop;
USE vinylrecordshop;

CREATE TABLE band(
bandId int primary key  auto_increment,
bandname varchar(50) not null);

CREATE TABLE artist(
	artistId int primary key auto_increment,
    artistFirstName varchar(25),
    artistLastName varchar(50) NOT NULL
);

CREATE TABLE bandArtist (
	bandId int NOT NULL,
    artistId int NOT NULL,
    CONSTRAINT PRIMARY KEY PK_bandArtist (bandId, artistId),
    CONSTRAINT FK_band_bandArtist FOREIGN KEY (bandId) REFERENCES band(bandId),
    CONSTRAINT FK_artist_bandArtist FOREIGN KEY (artistId) REFERENCES artist(artistId)
);


CREATE TABLE song (
    songId INT PRIMARY KEY AUTO_INCREMENT,
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT,
    CONSTRAINT FK_band_song FOREIGN KEY (bandId)
        REFERENCES band (bandId)
);

CREATE TABLE album(
albumId int primary key auto_increment,
albumTitle varchar(100) NOT NULL,
label varchar(50),
releaseDate date,
price decimal(5,2)
);

CREATE TABLE songAlbum (
	songId int,
	albumId int,
    CONSTRAINT PRIMARY KEY PK_songalbum (songId, albumId),
    CONSTRAINT FK_song_songalbum FOREIGN KEY (songId) REFERENCES song(songId),
	CONSTRAINT FK_album_songalbum FOREIGN KEY (albumId) REFERENCES album(albumId)
);

