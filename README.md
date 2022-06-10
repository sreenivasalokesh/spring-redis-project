# Redis Cahce implementation in Spring Boot
* Include the lib spring data redis while creating the project or add below mvn dependency  

	<dependency>  
		<groupId>org.springframework.boot</groupId>  
		<artifactId>spring-boot-starter-data-redis</artifactId>  
	</dependency>    
* At the entry point or main add the annotation @EnableCaching.
* We can add Redis annotation like Cacheable, CachePut, CacheEvict on the controller methods, or it can be done on service methods. Usually, service methods are used as they the ones responsible for business logic, and referenced from multiple controllers
* As we know that the caching is usually done on Get methods or find calls, So Cahceable is placed on the Get controller methods.
* CachePut is used to update the record, and CacheEvict (will allEntries true flag) is used on Update and Delete operations.
* CacheEvict can also be placed on the Create operations as it ensures that the new addition of record clears the Redis, so that the next Get method use would populate Redis cache.
* In the local setup, application will use the Redis running on localhost 6792, but we can also configure it to point to external Redis cache by specifying below properties in application.propertis file    

> spring.redis.host=localhost    
> spring.redis.port=16379   
> spring.redis.password=mypass   
> spring.redis.timeout=60000	  
