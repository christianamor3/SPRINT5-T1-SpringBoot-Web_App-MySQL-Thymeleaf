# Exercici aplicació Web CRUD amb MySQL
Accedeix a la pàgina ->https://start.spring.io/, i genera un projecte Spring boot amb les següents característiques:

PROJECT (gestor de dependències) - Maven o Gradle

LANGUAGE - Java

SPRING BOOT - La darrera versió estable

PROJECT METADATA

Group - cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01

Artifact - S05T01N01GognomsNom

Name - S05T01N01GognomsNom

Description - S05T01N01GognomsNom

Package name - cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01

PACKAGIN - Jar

JAVA - Mínim versió 11

Dependències:

- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- MySQL Driver
- Thymeleaf

Tenim una entitat anomenada Sucursal, que disposa de les següents propietats:
- Integer pk_SucursalID
- String nomSucursal
- String paisSucursal

També tenim una DTO anomenada SucursalDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:
- String tipusSucursal.

Aquesta propietat, en funció del país de la sucursal, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat Sucursal a una base de dades MySql, seguint el patró MVC.

El consell és que SucursalDTO la facis servir al Controller y la Vista, i Sucursal al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services

- cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

La classe ubicada al paquet controllers (SucursalController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

- http://localhost:9000/sucursal/add
- http://localhost:9000/sucursal/update
- http://localhost:9000/sucursal/delete/{id}
- http://localhost:9000/sucursal/getOne/{id}
- http://localhost:9000/sucursal/getAll

Com pots veure, a l’arxiu application.properties, hauràs de configurar que el port a utilitzar sigui el 9000.

La vista haurà d’estar desenvolupada amb Thymeleaf.

Captures de la VISTA feta amb Theymeleaf:

![image](https://github.com/christianamor3/SPRINT5-T1-SpringBoot-Web_App-MySQL-Thymeleaf/assets/151139448/24fcddf2-b939-4891-9e6b-0398d0fa1477)
![image](https://github.com/christianamor3/SPRINT5-T1-SpringBoot-Web_App-MySQL-Thymeleaf/assets/151139448/73d98493-6d24-497f-b119-a7b08b12a7d5)
![image](https://github.com/christianamor3/SPRINT5-T1-SpringBoot-Web_App-MySQL-Thymeleaf/assets/151139448/f0c6aeb9-9ffa-4160-a278-9b76a18b6ad4)

Si pones un id que no existe o lo dejas en null:
![image](https://github.com/christianamor3/SPRINT5-T1-SpringBoot-Web_App-MySQL-Thymeleaf/assets/151139448/e179b253-74cd-45bd-9b4c-9ee6791eb915)
