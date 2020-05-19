# Spring Cloud Kubernetes: FeignClient and Ribbon discovery in Kubernetes
Providing client-side load balancing for a microservice application using Netflix Ribbon and Netflix Feign as well.
Fabric Kubernetes lib will find services(Not config list of servers)
Using Ribbon discovery in Kubernetes `spring-cloud-starter-kubernetes-netflix`

### Requirements
+ Run on Kubernetes


#### Minikube IP: 192.168.99.100

#### hello-service: it is a service app. It has api
$(minikube service hello-service --url)/hi_getall

Build hello-service
```
cd hello-service
mvn clean package
```

Docker build
```
cd hello-service
docker build -t hello-service:1.0.0 .
```

Run service in Kubernetes(Using Minikube)
```
cd hello-service
kubectl create -f manifests/hello-service-configmap.yml
kubectl create -f manifests/hello-service.yml
```

#### client-service: Using Feign, connect to hello-service
$(minikube service hello-service --url)/getall-hi

It will request to $(minikube service hello-service --url)/hi_getall of hello-service

Build client-service
```
cd client-service
mvn clean package
```

Docker build
```
cd client-service
docker build -t client-service:1.0.0 .
```

Run service in Kubernetes(Using Minikube)
```
cd client-service
kubectl create -f manifests/client-service-configmap.yml
kubectl create -f manifests/client-service.yml
```

### Reference
[Spring Cloud integration with Kubernetes](https://github.com/spring-cloud-incubator/spring-cloud-kubernetes)
