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
- o addFriend
	o message de pas ok 0%
- o contact : verifier le post
	o message de bonne reception

o securisation de l'acces à la base de donnée (mot de passe administrateur pas dans les properties)
o mise en page, CSS
o tests



Ce qu'il me reste à présent c'est des messages d'information à afficher quand des opérations se passent bien ou mal.
Je pourrais également améliorer l'affichage des transactions avec les surnoms plutôt que les adresses mails mais il faut que je revois comment faire des requêtes avec jointure avec spring.
Il y a aussi l'histoire de la pagination des transaction que j'ai laissé tomber.
Bien sûr j'ai aussi toute la partie mise en page et CSS à faire.
Pour l'instant le mot de passe pour accéder à la base de donnée est encore en clair dans le application.priperties, il faut que je change ça aussi.
