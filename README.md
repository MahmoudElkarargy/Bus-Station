# Bus-Station
Simulation for a real-life booking App like; Uber. where there is 3 types of users Customers, Managers, and Drivers. Customers can view and book trips, Drivers can view their trips and Managers can edit, add new trips, Assign trips to drivers and modifiy current trips. Both of drivers and customers can view their history of trips.

**Description

  This project is almost a complete simulation for a real-life bus station. First, we have the bus
  station itself with a complete set of vehicles like a bus, minibus, limousine, ...etc. Second, there
  are the employees who are divided into drivers and managers. Third, the passengers
  (customers) who are trying to buy a ticket for a specific trip.A customer can reserve one-way
  trip or round trip. Fourth, we have two main types of trips; internal (between cities) and
  external (between countries), they differ in price, distance, ...etc. Also, a trip can be nonstop,
  one-stop or many stops. 
  
  You are required to develop a simulator for such a system in Java using the OO concepts you
  have covered in the course till now. However, you also required to be creative and do some
  brainstorming with your partner about how a real system works, remember, this is mainly a
  design course, soa good use of object-oriented concepts like inheritance, polymorphism,
  abstract class, and interfaces will be graded significantly.

  You are also required to develop a GUI that should support two modes of operations for two
  main actors: passengers and employees.You should work with files too to store the trips
  information, passengers’ list for each bus, ...etc.
  
  You will be required to deliver a Class Diagram.
  

**Scenario
Your program should follow the following scenario atleast (you are free to add features as you
see fit ) :

  1. When starting the program you get a prompt to select which kind of user is using the
  program a passenger or an employee.
  2. If a passenger is selected,he then is asked to enter a username and a password for
  authentication and then he opens his profile.
  3. From the passenger profile he is able to select the trip he wants to make
  (source,destination,one-way,round-trip,number of stops ... etc) from a list of available
  trips.
  4. When the passenger books a ticket (if there are available seats) he is shown a price for
  the selected ticket(s) and then proceeds to buy them.
  5. The passenger is able to review and cancel his tickets from his profile.
  6. If an employee is selected,that employee can be a manager or a driver
  7. If you log in with a driver credentials you are directed to the drivers profile with some
  basic information about the driver and the trips that are assigned to him by the manager.
  8. If you log in as a manager you are able to review all trips in the system,you are able to
  add / remove trips and assign drivers to the trips in the system.
  

**Tasks
  You should concentrate on the inheritance and polymorphismpart, take your time in
  the design phase so you can reach a good object-oriented model. You are required to
  support at least:
  
    o Three types of vehicles. 
    o Two types of employees.
    o One type of customers. (or more)
    o Two types of trips, with 3 different flavors (nonstop, one-stop, many stops).
    o Two types of tickets, and note that a round trip ticket should be cheaper than a single ticket.

  You are encouraged to add more classes and extend more types in your project.
   You should at least provide one abstract class and one interface, you are free to add
    more depending on your design.
   Your code should read and write to files to save and load data
   You should load some data from some files at the program startup, so you will have
    some trips and customers to play with.
   You can save the updates automatically to the files, or provide a save button to save
    changes to the files.  You should provide a good GUI which will ease the use of the system, you are free to
    use any GUI framework, and you are free to make any design you like.
   Your GUI should support two modes of operations, one for the customers to buy a ticket
    and the other for the manager or a driver to update a trip or a ticket price, ...
   You should draw a class diagram of your project.
   You should handle errors and show error massages to the user, use try and catch to help
    you make your program stable.
   You should apply all the object-oriented concepts like encapsulation, ...etc. And don’t
    use static unless you really need it.  Be creative! The required features are only the beginning of what you can do, 
    add more features or spice up the required ones, 
    bonus marks will be given to those with eye- catching extra features and user- friendly interfaces.
   This project will consume some time in developing, but it has minor difficult parts, so
    enjoy what you are doing and try to learn as much as you can. It is meant to be easy and
    to help you learn.
  
