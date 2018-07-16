# js-middleware

Conectar aplicação com projeto GIT no heroku:

* heroku git:remote -a js-middleware
* git push heroku master
* heroku open

Conectar remotamente á base de dados do Heroku

* Adicionar no final da URL de conexão: ?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory
