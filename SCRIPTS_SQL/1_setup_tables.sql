create table Livro(

id SERIAL,
titulo VARCHAR(100) NOT NULL,

PRIMARY KEY (id),
UNIQUE (id)
);


create table Edicao(

id SERIAL,
edicao int NOT NULL,
ano INT NOT NULL,
idLivro INT NOT NULL,

PRIMARY KEY (id),
FOREIGN KEY (idLivro) REFERENCES Livro 
);



create table Autor(

id SERIAL,
nome VARCHAR(100) NOT NULL,

PRIMARY KEY (id),
UNIQUE (id)
);


create table livrosAutor(

idLivro INT,
idAutor INT,

FOREIGN KEY (idLivro) REFERENCES Livro,
FOREIGN KEY (idAutor) REFERENCES Autor
);
