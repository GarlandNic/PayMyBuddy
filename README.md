# PayMyBuddy

Auteur : Nicolas Garland

## Projet 6 de la formation Openclassrooms Développeur Java : Application de transfert d'argent

![Diagramme des données](Readme_image/diagramme_donnees.png)


TODo list

o index				html: ok
- o login			html: ok ; 	get: ok
- o newUser			html: ok ; 	get: ok ; 	post: ok
o home				html: ok ;	get: ok
- o credit			html: ok ;	get: ok ; 	post: ok
o transfer			html: ok ;	get: ok ; 	post (send money): ok
	o message de transfer mal/bien passé 0%
	o affichage des transactions : avec nickname au lieu de adresse : 0%
	o pagination des resultats : 0% 
	o commit et rollback ?? 0%
- o addFriend		html: ok ; 	get: ok ; 	post: ok
	o message de pas ok 0%
o profile			html: ok ; get: ok
- o modifUser		html: ok ; get: ok ; 	post: ok
- o debit			html: ok ; get: ok ; 	post: ok
- - o supprUser		ok
- o listOfFriend	html: ok ; get: ok ; 	post (remove): ok
- o contact			html: 50% ; get: 60% ; 	post (send message): 0%

o securisation de l'acces à la base de donnée (mot de passe administrateur pas dans les properties)
o mise en page, CSS
o tests


bankService et repo
Transactions recu/envoyees : ne t'embête pas à les fusionner
redirect:/la-ou-on-veut-aller  -> get /la-ou-on-veut-aller
découpage des controller
pagination : bootstrap table
