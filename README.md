# PrototypeDesignPattern

Overview:
The prototype design pattern is one of the creational design patterns. It allows us to specify objects which are prototypes of original objects. In other words, it allows us to copy existing objects instead of making new instances.

Here, we are going to learn about the Prototype design pattern and its usage in detail.

When Will We Need the Prototype Design Pattern?
Prototype Design Pattern is mainly used when creating new objects from scratch is expensive and we are already having similar classes for creating such objects.

With the help of Prototype Design Patterns, we copy new objects from already existing classes and modify these objects according to our new requirements.

Real-World Example:
Assume that we are having one program for Inserting data into a database from one specific source.

Now, we have received one new requirement before inserting data into the database, we need to perform some type of data preprocessing and data modifications. As we are already having a program for inserting data, we can use this object and do some changes to it so that it can modify/pre-process the data and then insert it into the database.

To perform this, we will clone the existing object into the new object and make necessary changes to this new object.

For Prototype Design Pattern, it is mandatory to have a copy feature in existing objects. If we want to create prototypes of our object, we need to implement/define a clone() method for that object/class. Although, it depends on our design and requirement whether to use a shallow or deep copy of the existing objects.

Shallow Copy - In shallow copy, we only clone the parent object and not its containing objects.

In shallow copy, we copy references of the Original object, and hence if we make any changes in one of the objects, those changes get reflected in other objects as well.

Deep Copy - In a deep copy, we clone the parent object as well as its containing objects.

In a deep copy, we copy the original object with its values so after copying, both the objects are independent of each other, and hence, if we make any changes in one object, that change does not get reflected in the other object.

List of other examples:
1. Mobile Phone making company releasing different mobiles for various segments. Now, each mobile will have some basic common functionality with some extent of variations. Here, the company will use one of its phone software and clone it according to other phones.

2. Laptop making company designs Laptop’s body for one laptop in the software. After that, for future releases of this Laptop model, the company will simply clone the last model’s body and do the required changes as per the latest trend and requirements.

Here, we understood how prototype design patterns work in a real-world scenario. Furthermore, we will see how it will work and its internal implementations.

How Does the Prototype Design Pattern Work?

Structure of Prototype Design Pattern



1. We can understand from the above diagram that the clone() method is declared in the Prototype interface. In the majority of the cases, there will be only one clone() method.
2. This clone() method gets implemented in the Concrete Prototype classes (represented in green). Here, the clone() method copies data from the original object into the cloned object. Moreover, boundary value conditions related to copying objects are also managed here.
3. Client (represented in blue) can create copies of the original object without implementing the underlying code.

Let us understand the detailed implementation of prototype design patterns.

First and foremost, a prototype allows us to hide the complexity of creating a new object instance from the client code. The base concept behind this is to replicate an existing object instead of creating a new object instance from scratch which may have some complex operations or business logic. In simpler words, by using this design pattern, end-users do not need to worry about the internal implementation of the original object and they are not required to check and allocate every property of the original object to the copied object.

Thus, the existing object is represented as a Prototype interface and contains a base object. The newly created subclasses may contain external elements and methods if required. We can add more features/classes to our prototyped object if we want to change its functionality.

This prototype pattern is necessary when object development is a time-consuming and costly operation so that we make objects with the existing object instance itself.

In Java and Python, the built-in Clone() method is the best available option to create an object from an existing object. It is the simplest way to implement a prototype pattern. However, the implementation of the prototype may change according to business requirements and the languages (for example, in C++, we do not have any built-in methods to clone the objects! So our implementation strategy will differ from language to language).

Let us learn this approach with step-by-step hierarchies implementation.

Prototype Design Pattern Implementation Steps:
1. Either we can create an abstract class or interface having an abstract clone() method or we can simply add the method in all existing class hierarchies, if available.
2. Our prototype or abstract class will have a constructor which will accept an object of this class as an argument. This constructor will copy all the instances from the passed object to the new one. In the case of changing of subclasses, it must call the parent constructor to let the cloning of private fields from the superclass.
3. The clone() method which we define in our subclasses will usually return a new object with the prototypical version of the constructor. Here, each class will explicitly override the cloning method otherwise, it will return an object of a parent class.
4. If we use some specific type of prototype often, then it would be a great idea to store them by creating a centralized prototype registry.
We have two ways to implement this registry, either we can create a new factory class or we can simply implement it in the base prototype class with a static method to fetch prototypes.

We can search for our desired prototype with the help of search criteria that client code passes to the method. The criteria can be a simple string tag or set of parameters. After the desired prototype is found, the registry will clone it and will return a copy of the object to the client.

Now, let us understand the Prototype Design Pattern with one simple pseudocode.

Pseudocode:
Here, we have created pseudocode for Vehicles. All types of vehicles such as two-wheelers, four-wheelers, tires, etc. have some basic features such as number of tyres, average, number of seats, etc.

After creating an object of appropriate vehicle type, our client's (showroom owner or manager) end goal is to store the sold vehicles record in the database. Now, here comes our prototypes.

We do not have to worry about the type of vehicles and their features. Our program is handling all this. We are storing all the data of our vehicle in the array name - 'Vehicles'. After selling any type of vehicle, our program is invoking an appropriate clone() method and stores this data into the array name - 'selling vehicle tires.

Code:

abstract class Vehicle
    integer seats
    integer tyres
    string color
    string fuel
    
    constructor Vehicle () //Default constructor
    
    constructor Vehicle (source Vehicle) // Parameterized constructor - It will create a new object and initialize this object from the existing object.
        this()
        this.seats = source.seats
        this.tyres = source.tyres
        this.color = source.color
        this.fuel = source.fuel
    
    abstract Vehicle clone () // This method will return the object of one of the subclasses and it will be overridden by the all the subclasses

class Bike extends Vehicle
    integer average
    
    constructor Bike (Bike source)
        super(source)
        this.average = Bike.average
    
    Vehicle clone ()
        return new Bike(this)

class Car extends Vehicle
    integer average
    
    constructor Car(Car source)
        super(source)
        this.average = source.average
    
    Vehicle clone()
        return new Car(this)

//Client code...
class Showroom
    Vehicle[] vehicles
    
    constructor Showroom ()
        Car c1 = new Car()
        c1.seats = 5
        c1.tyres = 4
        c1.color = white
        c1.fuel = petrol
        c1.average = 15
        vehicles.add(c1)

        Car c2 = c1.clone() //C2 object is having exact values as C1
        vehicles.add(c2)

        Bike b1 = new Bike()
        b1.seats = 1
        b1.tyres = 2
        b1.color = black
        b1.fuel = petrol
        b1.average = 50
        vehicles.add(b1)
    
    void cell vehicle () {
        // Here, we can create a copy of the object without knowing anything about it because of the Prototype.
        Vehicles[] vehicle selling of = new Vehicles[10]
        
        //In other words, we are not aware of the exact features related to the Vehicles array. The only information we have is that they all are Vehicles. However, because of Polymorphism, when we call the 'clone()' method on the Vehicle, the program checks for its original class and executes the required clone() method, and hence we get desired clones instead of a set of simple Vehicle objects.
        foreach (vehicle in vehicles) do {
            vehicleSelling.add(vehicle.clone()) // The 'vehicleSelling' array has exact replicas of the 'vehicles' array's children.

If we would have not implemented the clone() method in our subclasses, then we would have to maintain both the arrays separately and it significantly increases our manual work and sometimes, occasionally leads us to the error in data (both arrays having different data for the same vehicle).

Pros and Cons of Prototype Design Patterns:
Advantages of Prototype Design Patterns:
1. Addition and Removal of objects at the run-time - Prototypes let us create new concrete object classes in our existing system by just registering required prototypical instances (means, implementing, prototypes based on the original object but with limited functionalities, features, and properties by the requirement) with the customer. It is more flexible for end-users, compared to other creational patterns, because they can easily install and uninstall prototypes at run-time.
2. Creating new objects with different values - Through this pattern we can define new behavior through object composition by changing the structures to values of an object’s variables and not creating separate classes for this.
3. Creating new objects with different structures - In real life, many times, we use parts and subparts of our existing classes and objects in order to create new objects and classes, having different structures.
4. Less number of subclasses - By using conventional methods, we have to create a range of subclasses to achieve our end goal. However, Prototype patterns let us create clones from the existing object and hence eliminate the creation of new classes for new objects.
5. Alternative option for Inheritance - If our requirement is having a complex object structure, we can use the Prototype Design pattern as the option of inheritance. It can significantly decrease our total number of lines in the code and increase its readability and understandability of it.
6. Less number of manual initializations - Prototype Design pattern lets us initialize values for the cloned object by using existing values from the original object. As a result, we do not need to fill all the values for cloned objects and we just need to simply add/change values required parameters.

Disadvantages of Prototype Design Patterns:
1. For projects, which require less number of objects, implementing prototype patterns can be an overkill.
2. It hides the actual structure of the object/program from the client.
3. When we use the Prototype Design pattern, every subclass must implement, the clone() method, and in some cases, this implementation can be difficult.
4. It is not advisable to use a Prototype Design pattern when objects are having circular references to each other. (Because in this type of object, there are dependencies on other objects. Now, if we want to create a prototype for one object, we might need to create prototypes for other dependent objects also, which we do not require, but as they all are working together to achieve the end goal we might need to and this leads to increase in complexity.)

Difference between Prototype Design Pattern and Other Similar Patterns:

1. Most of the time, designs start with Factory Method design pattern (because of less complexity and high level of customization possible with the use of subclasses) and go towards the Abstract Factory, Prototype or Builder design pattern (high level of flexibility as well as complexity).
2. In many instances, Abstract Factory classes (implemented using Abstract Factory pattern) are made based on Factory Methods design pattern. However, it is also possible to use Prototype design pattern to create methods for these classes.
3. Prototype can be helpful when we need to save copies of Commands design pattern in our history.
4. Project designs, which are heavily based on Composite and/or Decorator, can be benefited by using Prototype Design patterns because we can directly clone complex structures instead of creating them from scratch.
5. Prototypes are not based on inheritance, so they do not have drawbacks of inheritance. However, they have complicated initialization steps for the cloned object. Factory Methods are based on inheritance and they do not require separate steps for initializations.
6. Occasionally, Prototype Design patterns are simpler compared to Memento if the object’s state, which we want to keep in the history, is not complex and does not have links with external resources or it is straightforward to re-establish these links.
7. It is possible to implement Abstract Factories, Builders and Prototypes as Singletons.

Frequently Asked Questions (FAQs) related to Prototype Design pattern:
1. Explain Prototype Design pattern in brief. Ans. Prototype Design pattern provides us a way to create new objects by using existing objects. In other words, we can copy data from the existing object and store it in our new object by using this pattern.

2. Explain Shallow Copy and Deep Copy in Prototype Design patterns. Ans. Shallow Copy and Deep Copy are types of cloning in Prototype Design patterns. In shallow copy, we only cloned the parent object and not its containing objects while in deep copy, we cloned the parent object as well as its containing objects.
