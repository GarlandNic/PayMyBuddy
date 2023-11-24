# PayMyBuddy

Auteur : Nicolas Garland

## Projet 6 de la formation Openclassrooms Développeur Java : Application de transfert d'argent

![Diagramme des données](Readme_image/diagramme_donnees.png)


TODo list

o transfer
	o message de transfer mal/bien passé 0%
	o affichage des transactions : avec nickname au lieu de adresse : 0%
	o pagination des resultats : 0% (bootstrap table)
	o commit et rollback ?? 0%
		o https://openclassrooms.com/fr/courses/6982461-utilisez-spring-data-pour-interagir-avec-vos-bases-de-donnees/7201194-utilisez-les-relations-unidirectionnelles
		o @Transactional
- o addFriend
	o message de pas ok 0%
- o contact : verifier le post
	o message de bonne reception

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
o mise en page, CSS
o tests
o dto pour passer les donnees


Ce qu'il me reste à présent c'est des messages d'information à afficher quand des opérations se passent bien ou mal.
Je pourrais également améliorer l'affichage des transactions avec les surnoms plutôt que les adresses mails mais il faut que je revois comment faire des requêtes avec jointure avec spring.
Il y a aussi l'histoire de la pagination des transaction que j'ai laissé tomber.
Bien sûr j'ai aussi toute la partie mise en page et CSS à faire.
Pour l'instant le mot de passe pour accéder à la base de donnée est encore en clair dans le application.priperties, il faut que je change ça aussi.


o sequence pour generer champ identifiant
o commentaires dans le code
o script sql pour insérer des données -> générer à partir de workbench
o présentation du code 
o diagramme UML


Du coup j'ai modifié la structure de mes tables pour avoir des identifiants qui s'auto-incrémentent. ça m'a fait faire plein de modifs dans le code.
J'ai encore des erreurs à corriger par rapport à ça. En plus j'ai modifié le nom de certains attributs pour que ce soit plus explicite. Il faut que je remette à jour tous mes html.
J'ai pas encore pu tout tester donc j'aurais sans doute encore d'autres corrections à faire.

