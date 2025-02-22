# L'API Java BootSpring

## Les prérequis
Il est nécessaire d'installer :
- IntelliJ IDEA de la suite JetBrains
- Git
- La version 23 de Java (peut se faire plus tard dans l'IDE)
- Une base de données Postgres
- FFMPEG (MacOS : `brew install ffmpeg`, Linux : `sudo apt install ffmpeg`, Windows : `winget install ffmpeg` et redémarrer)

## La base de données
Pour ce projet, nous utilisons une base de données Postgres. 
Nous conseillons d'utiliser Postgres afin d'assurer une bonne compatibilité.
Dans le cas d'un changement, les fichiers `/api/src/main/ressources/application.properties` et `/api/pom.xml` devront être mis à jour.

## La sécurité
Tutoriel complet pour la mise en place de la sécurité (CSRF, JWT token, chiffrement des mots de passe) : https://youtu.be/oeni_9g7too?si=-8_05erRs3LaettA

## Le fichier de configuration
Le projet a besoin d'un fichier de configuration "`.env`" pour fonctionner et démarrer.
Ce fichier doit être placé dans le dossier `/egarden/api/`.
Ce fichier ne doit en aucun cas être envoyé sur le repos Github, sur aucune branche, dans aucun commit. 
Autrement, les informations présentent dans la base de données, les flux de la caméra pourraient être vus et modifiés par quiconque.
Si ce fichier ne contient pas toutes les variables avec données valides (sauf RTSP) alors le projet pourrait ne pas se lancer.

Il doit contenir plusieurs variables :
- **DATABASE_HOST=** Adresse IP de la base de données (locale ou distante, server)
- **POSTGRES_PASSWORD=** MotDePasse de la base de données
- **POSTGRES_USER=** Nom de l'utilisateur de la base de données
- **POSTGRES_DB=** Nom de la base de données à utiliser
- **RTSP_URL=** rtsp://NOM:PASSWORD@AdresseIP:PORT
- **JWT_SECRET=** SECRET
- **DEFAULT_PASSWORD=** mot de passe par défaut du site lors de la création des utilisateurs ou de la réinitialisation.

### Le secret
Le secret est utilisé pour chiffrer les mots de passe, et ne doit pas être publié sur github. 
Le secret doit être le même pour toutes les instances du backend pour une même base de données.
Pour générer un secret, vous pouvez exécuter la commande : `openssl rand -base64 64`, copier la sortie et le coller dans le fichier `.env`.

## Le lancement du projet 
Dans IntelliJ IDEA, outil de développement de la société de Jetbrains, l'API doit être lancé depuis la class `/src/java/com/e_garden/api/ApiApplication.java`.
Ensuite dans le menu de configuration du lanceur, il faut cliquer "Modifier options" et ajouter dans la partie "`Operating System`" l'option `Variables d'Environnement`.
Une fois ajouté, un champ supplémentaire apparait, nommé Variables d'environnement, il faudra ajouter le chemin absolu du fichier .env, exemple : `/User/Desktop/Projet/egarden/api/.env `.
En fonction de votre ordinateur et d'IDEA, il faudra ajouter dans `Projet Structure`, puis `Projet` le SDK de Java 23, l'outil vous proposera de le télécharger automatique. 
De plus, avant de lancer la configuration l'IDE vous demandera d'installer tous les packages (les dépendances), dans l'IDE dans la partie `Maven`, ensuite `api`, ensuite `Lifecycle` et vous pouvez cliquer sur `Install`, et les installera.
Un compte existe au lancement : **email** : `admind@egarden.fr` ; **mot de passe** : `admin`

## Les Tests
Notre projet comprend un test, à chaque déploiement le test est éxécuté et vérifie que le contexte est bien chargé. 
Cette vérification permet de déceler toutes les erreurs liées à de la syntax, à une information incorrecte ou manquante dans les fichiers de configuration.

## L'utilisation de l'API
Pour s'assurer que l'API fonctionne, nous conseillons d'utiliser Postman et d'envoyer une requête Login avec un email et un mot de passe corrects. 
L'API retourne un Bearer Token en cas de réussite. 
L'URL de login par défaut en "DEV" est `localhost:8080/api/user/login` avec la méthode `POST`, et attend un JSON structuré : `{ "email":"email.email@emaile.fr", "password":"motdepasse" }` l'API retournera un `String`.