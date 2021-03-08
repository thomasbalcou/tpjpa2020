# Projet back end

L'objet du projet est de réaliser une application de type tableau kanban.

## Architecture

![alt text](https://github.com/thomasbalcou/tpjpa2020/blob/master/bdd_kanban.png?raw=true)

Il y a un package jpa.domain qui contient la couche JPA avec les différentes classes d'objets qui sont annotées en jpa pour pouvoir créer des entités persistantes.

Le package jpa.dao contient la couche DAO. 
Ces classes permettent de regrouper les requêtes accédant aux données de la base de données. 
Elles étendent une classe abstraite qui définit des méthodes générales pour les requêtes en plus de celle particulière à chaque table.

Le package jaxrs.rest contient la couche service avec des méthodes permettant d'accéder à tous les éléments d'une table, ou un seul par sa clé primaire ou créer un nouvel element.

Le package jaxrs.dto définis comment rendre les données en JSON.

## Lancement du projet

git clone https://github.com/thomasbalcou/tpjpa2020.git

Dans eclipse: File -> import -> maven -> existing maven project

### Base de données

mysql configuré de base avec pour identifiant: root et sans mot de passe mais possibilité de changer pour hsqldb(login:sa) dans le fichier entitymanagerhelper.

### Executer le projet

Pour executer le jpa et créer les nouvelles tables -> run jpaTest.

Pour ececuter le serveur rest -> run RestServer
