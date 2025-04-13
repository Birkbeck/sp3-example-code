Chain of Responsibility
=======================

* Decouple senders of requests from receivers
* Allow more than one object to attempt to handle a request
* Pass the request along a behavioural.chain of receivers until it is handled
* Only one object handles the request
* Some requests might not be handled

If a client was given an instance of a handler (created at run time):

    MessageHandler handler = 
      new BlackListHandler(
        new SpamHandler(
          new ForwardingHandler(
            new DeliveryHandler(null))));

The client would simply do:

    handler.handle(emailMessage);
