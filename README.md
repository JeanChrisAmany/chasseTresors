# CARBON IT : Exercice pratique - La carte aux trésors
Ce projet est une réponse àà un exercice technique demandé par Carbon IT.

## Lancer le projet
 - Pour lancer le projet, cloner ou télécharger l'archive de ce repo.
 - Se rendre dans le dossier du projet et lancer la commande `mvn clean install`
 - Aller dans le dossier target et lancer le jar (il est impératif de fournir un fichier d'entrée à lire):
    - Si je souhaite que le fichier de sortie soit créé dans le dossier target :
        - `java -jar treasure-hunt-jar-with-dependencies.jar -fileInput "G:\dev\treasure-hunt\src\main\resources\programInput1.txt"`
    - Si je souhaite spécifier une chemin où le fichier doit être écrit : 
        - `java -jar treasure-hunt-jar-with-dependencies.jar -fileInput "chemin\vers\programInput.txt" -fileOutput "chemin\vers\programOutput.txt"`
 - On peut aussi tout simplement passer par son IDE favoris. Par exemple Intellij ou Eclipse

## Architecture du projet
Le projet est constitué de 3 grandes parties :
 - **Main.java** : classe principale qui permet de lancer le programmme
 - **functional** : contient tout le code fonctionnel du projet (La carte, les aventuriers, les trésors et les montages ainsi que les exceptions fonctionnelles)
 - **technical** : contient tout le code technique du projet (Lecture/Ecriture de fichier, CLI, et gestion de la configuration du programme)

## Environnement technique
 - Java 12
 - Maven 3
 - Junit 5
 - Apache Common CLI
 - Intellij Idea