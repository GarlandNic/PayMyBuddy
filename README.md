# PayMyBuddy

Auteur : Nicolas Garland

## Projet 6 de la formation Openclassrooms Développeur Java : Application de transfert d'argent

![Diagramme des données](Readme_image/Diagramme_de_donnees.svg)

![Diagramme des classes](Readme_image/diagramme_de_classes.svg)



TODO list

	o scripts SQL (enregistrés sur github) (1 pour création des tables, 1 pour y mettre quelques données d'exemple, généré par workbench)
	o Soigner le fichier README, avec diagramme de classe et modèle physique des données
	o mettre dans le readme qu'il faut mettre à jour l'application.properties en fonction de votre environnement à vous (enlever les info du fichier)
		o securisation de l'acces à la base de donnée (mot de passe administrateur pas dans les properties)
		o https://openclassrooms.com/fr/courses/6982461-utilisez-spring-data-pour-interagir-avec-vos-bases-de-donnees/7201168-configurez-votre-projet-java
		o "Fichier de propriétés externes au JAR
			La documentation de Spring Boot indique que l’on peut placer le fichier application.properties dans un répertoire config situé dans le répertoire où l’application est exécutée.
			L’arborescence donnerait alors quelque chose comme :
				root_folder/
					config/
						application.properties
					dataLayer.jar
			"

DONE :

	o email UNIQUE (https://www.w3schools.com/mysql/mysql_unique.asp)
	o après avoir envoyé des sous à un buddy, redirection vers la page transfer en mode envoie
	o sorting des transactions
 	o messages après opération :
		o message de transfer mal/bien passé X
		o addFriend : message de pas ok X
		o contact : verifier le post X
			o message de bonne reception X
	o Modèle physique des données (structure des tables)
	o commentaires dans le code
	o "remember me" https://www.baeldung.com/spring-security-remember-me ; https://docs.spring.io/spring-security/reference/servlet/authentication/rememberme.html
	o Faire un diagramme de classe UML s'inspirer du truc de stéphane
	o Soigner la présentation des pages (CSS)

