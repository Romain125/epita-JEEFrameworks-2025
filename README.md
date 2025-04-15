# Sujet de projet MTI "JEE/Frameworks" 2025
# Projet : Click & Play

L'association Click & Play est une association de jeux de plateau qui cherche à se lancer. Tout le monde a maintenant accès à internet et il devient donc essentiel pour toute association qui veut tenir la distance d'être accessible au plus grand nombre. L'idée est donc d'avoir un système de gestion de réservation pour pouvoir s'inscrire à des sessions facilement avant de venir jouer.

Il existe donc plusieurs use-cases à cette application que voici.

## La Gestion des séances

Dans un premier temps, l'application sert à gérer les différentes séances. Une séance possède :
- Un nom (e.g. Le mercredi des loups-garous)
- Une date
- Une durée (en heures)
- Une salle, qui possède une capacité et un prix de location

Seul l'administrateur a le droit d'agir directement sur ces séances. Il peut les visualiser, en créer et en supprimer.

Il y a quelques contraintes :
- La date d'une séance doit être dans le futur
- La durée doit être positive
- Une suppression doit déclencher l'envoi d'un mail à tous les inscrits (bouchonné par un system.out.println)
- Il ne doit pas être possible de créer deux séances avec des dates qui se chevauchent

-------------------

## Gestion des tables/parties

Dans un second temps, l'application sert à gérer les différentes tables (ou parties) qui pourraient se dérouler durant cette séance.

Seuls les animateurs ont le droit de visualiser, créer et supprimer des tables de jeux. L'administrateur est également considéré comme un animateur.

Une table de jeu est forcément reliée à une séance et comprend :
- Le nom du jeu auxquel ils vont jouer
- Le maximum de personnes
- La date et l'heure de début
- La durée estimée

Voici les contraintes :
- La date et l'heure de début doivent se trouver dans le laps de temps où la salle est réservée
- Une partie doit se terminer au minimum 15min avant la fin de la séance (pour laisser le temps de ranger la salle)
- La somme du maximum de personnes de toutes les tables d'une séance ne doit pas dépasser la capacité de la salle
- Une table "Libre" est créée par défaut pour ceux qui voudraient juste trouver des joueurs sur place sans se prendre la tête. Cette table a un maximum égal à la capacité de la salle mais ne compte pas dans la règle précédente
- Une suppression doit déclencher l'envoi d'un mail à tous les inscrits (bouchonné par un system.out.println)
 
------

## Inscription des joueurs

Bien sûr, pour jouer il faut des joueurs. Les administrateurs et les animateurs sont également des joueurs.
Un joueur peut visualiser l'ensemble des séances à venir, ainsi que pour chaque séance, l'ensemble des tables ouvertes.
Pour chaque séance et table, il doit pouvoir voir le nombre de places restantes.

Voici les contraintes : 
- Un joueur ne peut pas s'inscrire à deux tables dont les parties pourraient se chevaucher
- Un joueur ne peut s'inscrire qu'une fois par table
- Un joueur a le droit à une première séance gratuite (quelque soit le nombre de talbles auquel il joue)
- Hormis la première séance, un joueur doit être cotisant pour pouvoir s'inscrire

------

Voici la liste des utilisateurs devant avoir accès à l'application.

| Username     | Password        | Role                |
|--------------|-----------------|---------------------|
| admin        | admin           | admin               |
| animateur    | admin           | animateu            |
| meeple       | meeple          | joueur (!cotisant)  |
| goldenmeeple | goldenmeeple    | joueur (cotisant)   |

Votre application doit également contenir un jeu de test au lancement (2 session tontenant chacune quelques tables) de manière à ce qu'une majorité de scénarios soient testables.

------

## Technologies

L'application doit être faite avec les notions vues en cours. Cela comprend :
- Une application Java 17 + Spring-boot avec une version > 3.0
  - Spring-web
  - Spring-data-jpa
  - Spring-security
- L'utilisation de maven pour importer les librairies nécessaires
- Toute persistance doit se faire avec une base de données mémoire H2
- Une architecture monolithique en 4 couches distinctes

## Rendu

Voici la liste des éléments à rendre afin d'être corrigé :
- L'adresse d'un repo git contenant le code source de votre projet
  - Les repos seront clonés à date et heure du rendu. Tout commit effectué après ne sera pas pris en compte.
  - Pensez à ajouter votre professeur en lecture sur le repo...ça serait dommage pour vous qu'il ne puisse pas clôner votre projet à heure dite...
- La liste des personnes ayant participé à ce projet doit se trouver à l'endroit approprié dans le pom.xml
- Un *.jar *auto-exéutable* (type fat-jar) dans un dossier "jar" à la racine de votre projet. Le jar doit pouvoir s'exécuter sans autre configuration externe.
- L'adresse de votre swagger-ui (ou à défaut, une documentation d'API explicite pour tester votre projet)
- Indiquez également dans le fichier readme.md à la racine de votre projet les choses à savoir qui pourraient intéresser le correcteur

## Point d'attention

Le sujet n'a rien de techniquement complexe. Il est volontairement fonctionnellement simple pour vous permettre de mettre l'accent sur les bonnes pratiques et la maintenabilité. Une grosse partie des points sera attribué à cet effet.
Cela comprend :
- L'utilisation d'un nommage de classe/variable/méthode propre
- Des méthodes claires, petites et auto-portantes
- L'application des principes SOLID
- Peu de duplication (DRY)
- Pas de code mort (YAGNI)
- Des bonnes pratiques dans la conception de vos APIs HTTP

Il n'est pas nécessaire d'effectuer de documentation (type javadoc), et les tests automatisés sont facultatifs (car non abordés pendant ce cours), mais cela vous sera demandé dans le monde de l'entreprise.
Il n'est pas demandé de dossier et il ne sera demandé de soutenance. Le code doit être suffisamment propre et explicite pour ne pas avoir besoin d'explications.

Tout projet suspicieusement similaire sera sanctionné.

## Bon courage !

-----
