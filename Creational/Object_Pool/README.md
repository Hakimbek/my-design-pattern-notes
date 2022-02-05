# Object Pool Pattern
Mostly, performance is the key issue during the software development and the object creation, which may be a costly step.

Object Pool Pattern says that " to reuse the object that are expensive to create".

Basically, an Object pool is a container which contains a specified amount of objects. When an object is taken from the pool, it is not available in the pool until it is put back. Objects in the pool have a lifecycle: creation, validation and destroy.

A pool helps to manage available resources in a better way. There are many using examples: especially in application servers there are data source pools, thread pools etc.

### NOTE:
Object pool design pattern is essentially used in Web Container of the server for creating thread pools and data source pools to process the requests.
