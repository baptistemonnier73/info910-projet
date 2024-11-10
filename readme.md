# TP DevOps

Ce TP à été réalisé par Baptiste MONNIER

## Fonctionnement de l'application

Il s'agit d'un back-end accompagné d'un SwaggerUI permettant de gérer des utilisateurs (identifiables par leurs noms)
ainsi que leurs rendez-vous (avec un timestamp de début et un timestamp de fin).

Ce backend expose deux endpoints :

- /users en GET pour obtenir tous les utilisateurs de l'application avec leurs rendez-vous (formatté en JSON) ;
- /users en POST : prends en paramètre une liste au format JSON pour ajouter des nouveaux utilisateurs avec
  éventuellement une liste de rendez-vous (username non existant en base) ou mettre à jour la liste des rendez-vous
  d'utilisateurs déjà existants (username déjà présent en base).

Exemple de JSON reçus ou à envoyer :

```json
[
  {
    "userName": "bmonnier1",
    "appointments": [
      {
        "beginMoment": "2024-11-10T07:00:00.000Z",
        "endMoment": "2024-11-10T09:00:00.000Z"
      }
    ]
  },
  {
    "userName": "bmonnier2",
    "appointments": [
      {
        "beginMoment": "2024-11-10T09:30:00.000Z",
        "endMoment": "2024-11-10T10:30:00.000Z"
      },
      {
        "beginMoment": "2024-12-10T09:30:00.000Z",
        "endMoment": "2024-12-10T10:30:00.000Z"
      }
    ]
  }
]
```

Ces deux endpoints sont accessibles via le swaggerUI.

Cette application est composée de deux conteneurs :

- Un hébergeant un serveur Spring-Boot ;
- Un autre hébergeant une base de données MySQL.

## Déploiement de l'application sur un cluster minikube

Pour déployer l'application sur un cluster minikube, assurez-vous pour commencer que minikube est bien démarré avec

```
minikube status
```

Ceci doit apparaître :

```
minikube
type: Control Plane
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Configured
```

Si minikube n'apparaît pas comme étant démarré, faire :

```
minikube start
```

En cas de problème, essayer ceci (attention, ceci supprime tout le cluster minikube et tout ce qu'il embarque) :

```
minikube delete --all 
minikube start
```

Commencer le déploiement avec :

```
kubectl apply -f .\kubernetes-deployment.yaml
```

Attendre que tout soit démarré, pour le voir, faire cette commande :

```
kubectl get pods
```

Une liste de pods apparaît, si les deux n'affichent pas ``Running`` dans la colonne ``STATUS``, cela signifie que
l'application est en cours de déploiement.
Dans ce cas, attendre quelques dizaines de secondes puis refaire la commande.

Une fois les deux pods à l'état ``Running`` il faut également s'assurer que le serveur Spring-Boot soit prêt, pour cela,
faire :

```
kubectl logs -f -l app=spring-boot-app --all-containers=true
```

Attendre que ceci soit affiché :

```
INFO 1 --- [           main] org.usmb.bmonnier.Main                   : Started Main in ??.??? seconds (process running for ??.???)
```

Le serveur Spring-Boot est prêt, pour pouvoir y accéder de l'exterieur, faire :

```
kubectl port-forward service/spring-boot-service 8080:80
```

Puis accéder au SwaggerUI via :

```
http://localhost:8080/swagger-ui/index.html
```