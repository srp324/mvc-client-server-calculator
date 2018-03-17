# mvc-client-server-calculator
Simple Calculator using MVC (Model-View-Controller) combined with Socket-based Client-Server architecture and several behavioral patterns.

#### Model: 
##### Composite Pattern, Visitor Pattern
Equation tree built using Composite Pattern and traversed under a Visitor Pattern. There are two visitors, one to calculate the value of and the other to build a string of the equation structured, in an in-order manner.

#### View:
##### Observer Pattern (Observer/Subject)
The GUI view is the subject (Observer) that is notified on changes in the model.

#### Controller:
##### Observer Pattern (Observable), State Pattern (Context)
The Controller keeps track of the current State and is the Context to be accessed within the States. The State transitions handles modifications to the model based on the current Controller command set by the ActionListeners activated from the View. After every state transition, the subject (View) is notified to update based on the new Model's data.

#### Client-Server:
Rich client based. Every time an equation is solved, the client sends the full equation to the Server to be printed. The Server also keeps a count of the total number of equations solved by that client.