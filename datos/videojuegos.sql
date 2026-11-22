DROP TABLE IF EXISTS listas_videojuegos;
DROP TABLE IF EXISTS listas;
DROP TABLE IF EXISTS jugadores;
DROP TABLE IF EXISTS videojuegos;

CREATE TABLE videojuegos (
                             id      SERIAL PRIMARY KEY,
                             titulo  TEXT    NOT NULL,
                             genero  TEXT    NOT NULL,
                             anio    INTEGER NOT NULL,
                             nota    REAL    NOT NULL
);

CREATE TABLE jugadores (
                           id_jugador SERIAL PRIMARY KEY,
                           nombre     TEXT NOT NULL
);

CREATE TABLE listas (
                        id_lista   SERIAL PRIMARY KEY,
                        nombre     TEXT NOT NULL,
                        id_jugador INTEGER NOT NULL,
                        FOREIGN KEY (id_jugador) REFERENCES jugadores(id_jugador) ON DELETE CASCADE
);

CREATE TABLE listas_videojuegos (
                                    id_lista      INTEGER,
                                    id_videojuego INTEGER,
                                    fecha_añadido TEXT,
                                    FOREIGN KEY (id_lista) REFERENCES listas(id_lista) ON DELETE CASCADE,
                                    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id) ON DELETE CASCADE
);

INSERT INTO videojuegos(titulo, genero, anio, nota) VALUES
                                                        ('The Legend of Zelda: Breath of the Wild', 'Aventura', 2017, 9.5),
                                                        ('Red Dead Redemption 2', 'Acción', 2018, 9.7),
                                                        ('Hades', 'Roguelike', 2020, 9.3),
                                                        ('Hollow Knight', 'Plataformas', 2017, 9.1),
                                                        ('Celeste', 'Plataformas', 2018, 8.9);

INSERT INTO jugadores(nombre) VALUES ('Diego'), ('Alba'), ('Pablo');

INSERT INTO listas(nombre, id_jugador) VALUES
                                           ('Pendientes', 1),
                                           ('Completados', 2),
                                           ('Favoritos', 3);