# L'application Nuxt JS
L'application est développée avec la technologie Nuxt.js.
Le projet intègre des composants de NuxtUI.
D'avantage d'informations sont disponibles sur le site de NUXT. Consultez la documentation Nuxt [Nuxt documentation](https://nuxt.com/docs/getting-started/introduction), [deployment documentation](https://nuxt.com/docs/getting-started/deployment) pour en savoir plus. 

## Les prérequis
Vous devez avoir un NodeJS d'installé, avec la version la plus récente.
Pour vérifier la version, utilisez la commande : `node -v`
Dans le cas où NodeJS n'est pas installé sur votre PC, veuillez l'installer via `brew` (MacOS), `apt-install` (Linux).

## L'API
Pour fonctionner l'application Web a besoin de données.
Le front réalise des appels via une REST API.

## Le fichier de configuration
Un fichier de configuration `.env` doit être créé à la racine du projet front-end.
Dans ce fichier de configuration, vous devez y intégrer les informations suivantes :
- API_URL=http://localhost:8080

## La sécurité
Le projet intègre un contrôle d'accès.
Trois pages ne nécessitent pas ce contrôle : *login*, *unauthorized*, *index*.

Autrement les pages ne fonctionnent qu'en présence d'un Token utilisateur valide.
Le Token est utilisé pour faire des demandes de données auprès du back-end.
Si le Token est invalide, une erreur sera retournée.

## Le lancement du projet
1. La première étape est de cloner le projet sur votre PC depuis le dépot Github :
  `git clone <adresse-du-repo>`.
2. Répondre aux exigences
3. Créer le fichier `.env` comme mentionné dans la partie : **Fichier de configuration** 
4. Ouvrir le projet entier sur votre IDE, puis un terminal et vous déplacer dans le dossier **frontend** :
   `cd frontend`
5. Lancer la commande `npm` pour télécharger toutes les dépendances
6. S'il n'y a pas d'erreur, lancer `npm run dev`
7. Si tout a bien fonctionné, il vous suffit de vous rendre à l'adresse suivante : http://localhost:3000

## L'utilisation de l'application
Des services avec de nombreuses fonctions et des composants sont disponibles, utilisez-les.
Nous recommandons d'utiliser les éléments déjà définis pour continuer le projet.
