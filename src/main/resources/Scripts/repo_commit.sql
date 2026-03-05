DROP DATABASE IF EXISTS repos_commit;
CREATE DATABASE repos_commit;
USE repos_commit;

CREATE TABLE Repositorios (
    id_repo BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    lenguaje VARCHAR(100)
);

CREATE TABLE Commits (
    id_commit BIGINT PRIMARY KEY AUTO_INCREMENT,
    hash CHAR(40) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha DATETIME NOT NULL,
    id_repo BIGINT,
    CONSTRAINT fk_commits_repos FOREIGN KEY (id_repo) REFERENCES Repositorios (id_repo)
        ON DELETE CASCADE
);

INSERT INTO Repositorios (nombre, url, lenguaje) VALUES 
('MiWebAppDAW', 'https://github.com/jgonz/MiWebAppDAW', 'PHP'),
('BlogPersonal', 'https://github.com/jgonz/BlogPersonal', 'JavaScript'),
('ApiRestJava', 'https://github.com/jgonz/ApiRestJava', 'Java'),
('BaseDatosSQL', 'https://github.com/jgonz/BaseDatosSQL', 'SQL'),
('AngularFront', 'https://github.com/jgonz/AngularFront', 'TypeScript');

INSERT INTO Commits (hash, mensaje, fecha, id_repo) VALUES
('a1b2c3d4e5f6789012345678901234567890abcd', 'Inicializar proyecto DAW con HTML/CSS', '2026-02-20 09:15:00', 1),
('f1e2d3c4b5a6789012345678901234567890fedc', 'Añadir navbar responsive y footer', '2026-02-22 14:30:00', 1),
('9e8d7c6b5a4321098765432109876543210fedc', 'Conectar backend PHP con MySQL', '2026-02-25 11:45:00', 1),
('b2a3c4d5e6f7890123456789012345678901234', 'Crear primer post del blog con React', '2026-02-28 16:20:00', 2),
('c3b4a5d6e7f8901234567890123456789012345', 'Añadir sistema de comentarios', '2026-03-01 10:10:00', 2),
('d4c5b6a7e8f9012345678901234567890123456', 'Crear endpoint /usuarios GET', '2026-02-21 08:35:00', 3),
('e5d6c7b8a9f0123456789012345678901234567', 'Añadir POST /usuarios con validación', '2026-02-27 13:50:00', 3),
('f6e7d8c9b0a1234567890123456789012345678', 'Crear scripts de creación de tablas', '2026-02-23 15:25:00', 4),
('a7b8c9d0e1f2345678901234567890123456789', 'Inserts de datos de prueba', '2026-02-26 17:40:00', 4),
('b8c9d0e1f2a3456789012345678901234567890', 'Inicializar Angular con routing', '2026-03-01 09:05:00', 5),
('c9d0e1f2a3b4567890123456789012345678901', 'Componente login con formulario', '2026-03-01 12:30:00', 5),
('d0e1f2a3b4c5678901234567890123456789012', 'Servicio HTTP para conectar API', '2026-03-01 16:55:00', 5);

-- Consulta ejemplo: commits por repositorio
SELECT r.nombre, COUNT(c.id_commit) as num_commits, r.lenguaje
FROM Repositorios r 
JOIN Commits c ON c.id_repo = r.id_repo
GROUP BY r.id_repo, r.nombre, r.lenguaje
ORDER BY num_commits DESC;
