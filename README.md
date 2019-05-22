# Feign_Kafka_Docker
Projeto para testes utilizando Docker para subir um Kafka Stream com consumo utilizando Feign

Para utilizar o projeto é necesário a instalação do docker e docker-compose:
https://docs.docker.com/install/

Após instalado, execute o seguinte comando na pasta raiz do projeto:

~~~~ 
docker-compose up 
~~~~

Após teriminar de subir Kafka e a aplicação, acessar a seguinte url para conferir o painel visual de mensagens do kafka:
http://localhost:8085/#/cluster/default/topic/n/endereco/

Com a aplicação funcionando, um get com um cep válido na seguinte url irá publicar uma mensagem com os dados do endereço e irá aparecer sua leitura pelo log.

~~~~ 
http://localhost:8080/message/{CEP com somente números}
~~~~
