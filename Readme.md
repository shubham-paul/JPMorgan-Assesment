# JPMorgan 
Small Message Processing Application

## The problem

Implement a small message processing application that satisfies the below requirements for

processing sales notification messages. You should assume that an external company will be sending

you the input messages, but for the purposes of this exercise you are free to define the interfaces.

**Processing requirements**

* All sales must be recorded

* All messages must be processed

* After every 10th message received your application should log a report detailing the number of sales of each product 
  and their total value.

* After 50 messages your application should log that it is pausing, stop accepting new messages and log a report of the
  adjustments that have been made to each sale type while the application was running.

**Sales and Messages**

* A sale has a product type field and a value – you should choose sensible types for these.

* Any number of different product types can be expected. There is no fixed set.

* A message notifying you of a sale could be one of the following types

* Message Type 1 – contains the details of 1 sale E.g apple at 10p

* Message Type 2 – contains the details of a sale and the number of occurrences of that sale. E.g 20 sales of apples at 10p each.

* Message Type 3 – contains the details of a sale and an adjustment operation to be applied to all stored sales of this product type. 
  Operations can be add, subtract, or multiply e.g Add 20p apples would instruct your application to add 20p to each sale 
  of apples you have recorded.
  
  
## The Solution
 
 The solution implements an Abstract Message Processing class for 3 different types and message and displays the message accordingly.
 
## Assumptions 
 
* The input messages are passed from a input text file.    
* The sales processing is done only for Fruits.
* The number of message used in each message remain constant.(MessageType 1: 3 words, MessageType 2: 6 words, MessageType 3: 3 words)
* Used System.out for logging
 
## Algorithm
1. Classification of each message on the basis of a utility method. 
2. Process the message and form a Sales message. An abstract class is used for the same. 
3. In case of Message Type 3, start with the Price Adjustment of all the previous sales records.
4. After every 10 records, display the sales list for every product and after 50 records, a price adjustment report is printed on the console. 
   

## Requirements
- Java 1.8
- Junit 4.1

## Junit
* UtiliyTest.java: Made for testing methods of Utility class for determining the type of message.
* MessageProcessorServiceTest.java: Made for testing methods of MessageProcessorService to get the productType and productPrice.
