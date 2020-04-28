# Exercises about Swing GUI
4 exercises 
- Calculator: A simple calculator with GUI
- Market: producer-consumer GUI application
- Police: GUI application implementing a Police Station
- RockPaperScissorsLizardSpockGUI: Rock Paper Scissors Lizard Spock game with GUI



# Calculator
An application implementing a simple calculator.
The GUI allows to perform standard operations (+, -, *, /, +/-, %, etc.).

Structure
MathEngine class: performs math operations.
GUI: a grid containing several buttons and a non-editable text area.
Try to decouple the application logic and GUI.



# Market
An application that allows a market producer to add products to his/her stand.
The producer has a GUI with the products to add to the stand.
While the producer inserts products, the clients can consume them.
The producer can sell: Tomatoes, Basil, and Potatoes.
The application:
	– Shows 3 buttons to insert the different products
	– Shows 3 text field with the number of available products
The application is an modified example of producer-consumer problem, typical of concurrent systems.
The application should guarantees that the consumer (client) cannot buy if nothing is available.
Vice versa, the producer cannot produce if the stand is full.
We will not consider these aspects, but you can try to implement them.

Structure:
Stand class: contains the available products.
Client class: buy products from the stand.
GUI contains 3 buttons:
	– Each button generates an event corresponding to the production of a product
	– This event is captured by a ProducerListener
ProducerListener is in charge of capturing and handling GUI events.



# Police Station
A simple application containing only 6 buttons representing 6 areas of a city. 
When a crime happens in a certain area, the police station operator presses the corresponding button inside the application. 
The button notifies all the police cars within the area.
Try to separate as much as possible application logic and GUI.

Structure:
PoliceCar class: modes a police car.
PoliceCarManager class: collects police cars and offers functionalities to signal crimes.
MainPoliceFrame class: shows the GUI.
AlarmHandler class: separates GUI and application logic. In particular:
	– It contains an instance of PoliceCarManager
	– It contains an instance of TextArea which will show the signal result



# RockPaperScissorsLizardSpockGUI
Design the GUI starting from the previous version we implemented.
We will focus on the local version of the code.
You can try to implement the GUI for the distributed version.