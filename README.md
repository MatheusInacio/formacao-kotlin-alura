# formacao-kotlin-alura

Apps da formação kotlin Spring da Alura

Preparar o container Mysql

`cd forum`

`docker compose up`

Preparar o container do Redis

`docker pull redis:7.0.2-bullseye`

`docker run -d -p 6379:6379 --name=redis redis:7.0.2-bullseye`

