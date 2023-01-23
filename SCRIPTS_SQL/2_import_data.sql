COPY livro (titulo)
FROM 'D:\Desktop\path\livros.csv'
DELIMITER ','
CSV HEADER;

COPY edicao(edicao,ano,idLivro)
FROM 'D:\Desktop\path\edicao.csv'
DELIMITER ','
CSV HEADER;

COPY autor(nome)
FROM 'D:\Desktop\path\autor.csv'
DELIMITER ','
CSV HEADER;

COPY livrosautor (idLivro,idAutor)
FROM 'D:\Desktop\path\livrosautor.csv'
DELIMITER ','
CSV HEADER;