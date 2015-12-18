# Monopoly
Projet Java Ephec 2015

Monopoly fait en Java par Florian Massart et François Marchal, classe: 2TL2 

Besoin de lancer un serveur qui héberge la partie et 2 clients (ni plus, ni moins) pour intéragir avec la partie à travers une interface graphique.
Sont implémentés et fonctionnels:
- le lancement des dés, suivi du déplacement du joueur sur le plateau de jeu, avec gestion des doubles et de la prison.
- l'achat de propriété, avant ou après avoir lancé les dés.
- Les cartes Chance et Caisse de Communauté (automatiquement résolues lorsqu'on s'arrête sur une case Chance ou Caisse de Communauté)
- la fin de tour qui permet de passer automatiquement la main au joueur suivant.

Reste à implémenter:
- gestion du monopole.
- l'achat de maisons/hotels.
- la revente de propriété et de carte "Sortez de prison" entre joueur à un prix convenu entre eux.
- la demande de loyer lorsqu'un joueur se trouve sur une propriété qui appartient à un autre.
- (code) regroupement des Propriétés, Gares et Services sous une même classe mère "Achetable".
- Gestion de l'hypothèque de propriétés.
- un plateau de jeu servant notamment à afficher la position de chaque joueur sur celui-ci, le nom du propriétaire de chaque case, des icônes pour les maisons/hotels, etc.
