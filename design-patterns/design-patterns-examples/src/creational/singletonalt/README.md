Singleton
=========

* Allow only one instance of a given class
    - The class holds a reference to its only instance
    - Lazy (on request) or static initialization (on load)
    - Private constructor to restrict external instantiation
* Provide global point of access to the instance public static ClassName getInstance()
* Support multiple instances in the future if the requirements change
    - Update getInstance to return multiple (possibly cached) instances if needed