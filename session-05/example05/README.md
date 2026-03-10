## Comparison of Creation Strategies in Google Guice

| Method                                                    | Use Case                                      |
|-----------------------------------------------------------|-----------------------------------------------|
| @Inject                                                   | Constructor Injection                         |
| @Singleton                                                | Singleton                                     |
| bind().to() | Standard interface-to-implementation mapping. |
| @Provides                                                 | Logic/Code Injection                          |
| @Named                                                    | Multiple Dependencies of the same Type        |
