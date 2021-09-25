## **solid-principles-example**

****

###1. **S::** **Single Responsibility Principle**

The single responsibility principle states that every Java class must perform a single functionality. Implementation of multiple functionalities in a single class mashup the code.

###2. **O::** **Open Close Principle**

The open-close principle states that according to new requirements the module should be open for extension but closed for modification.

###3. **L:: Liskov Substitution Principle**

It applies to inheritance in such way that the derived classes must be completely substitutable for their base class. In other words, If class A is subtype of class B, then we should be able to replace B with A without interrupting the behaviour of the program.

###4. **I:: Interface Segregation Principle**

The principle states that the larger interface split into smaller once. Because the implementation of classes use only the methods that are requried. We should not force the client to use the methods that they do not want to use.

The goal of Interface segregation principle is similar to the single responsibility principle. Let's understand through an example.

###5. **D:: Dependency Inversion Principle**

The principle states that we must use abstraction (abtract classes and interface) instead of concrete implementations. High level modules should not depend on the low-level module but both should depend on the abstraction.
