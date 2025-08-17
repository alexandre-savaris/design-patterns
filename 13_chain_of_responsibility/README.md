Of course\! The Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

This pattern decouples the sender of a request from its receivers, giving more than one object a chance to handle the request. Think of it like a customer service escalation line: the first-level agent tries to solve your problem, and if they can't, they pass you to their manager, who might then pass you to a specialist. 📞

-----

## Core Components

* **Handler Interface**: This defines a common interface for all concrete handlers. It usually includes a method to handle a request and another method to set the next handler in the chain.
* **Concrete Handlers**: These are the actual implementations of the Handler interface. Each handler knows how to process a specific type of request. If it can't handle a request, it forwards it to the next handler in the chain.
* **Client**: The client creates the chain of handlers and sends the initial request to the first handler in the chain.

-----

## Java Example: A Document Approval System

Let's model a simple document approval workflow where a document needs to be approved by different roles based on its type. We'll have a `Manager`, a `Director`, and a `CEO`.

### 1\. The Handler Interface

First, we define our `Approver` interface. It has a method to set the next approver and a method to process the approval request.

```java
// Handler Interface
public abstract class Approver {
    protected Approver nextApprover;

    public void setNext(Approver approver) {
        this.nextApprover = approver;
    }

    public abstract void processRequest(Document document);
}
```

### 2\. The Request Object

This is the object that will be passed along the chain.

```java
// The request object
public class Document {
    private final String type;
    private final String content;

    public Document(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
```

### 3\. Concrete Handlers

Now, we create our concrete approvers. Each one handles a specific document type. If it can't handle it, it passes the request to the `nextApprover`.

```java
// Concrete Handler 1
public class Manager extends Approver {
    @Override
    public void processRequest(Document document) {
        if (document.getType().equals("Leave")) {
            System.out.println("Manager approved the leave request: " + document.getContent());
        } else if (nextApprover != null) {
            System.out.println("Manager can't handle this. Passing to Director.");
            nextApprover.processRequest(document);
        }
    }
}

// Concrete Handler 2
public class Director extends Approver {
    @Override
    public void processRequest(Document document) {
        if (document.getType().equals("Budget")) {
            System.out.println("Director approved the budget request: " + document.getContent());
        } else if (nextApprover != null) {
            System.out.println("Director can't handle this. Passing to CEO.");
            nextApprover.processRequest(document);
        }
    }
}

// Concrete Handler 3
public class CEO extends Approver {
    @Override
    public void processRequest(Document document) {
        // The CEO can approve anything or reject it.
        if (document.getType().equals("Resignation")) {
             System.out.println("CEO approved the resignation: " + document.getContent());
        } else {
            System.out.println("CEO is handling: " + document.getContent());
        }
    }
}
```

### 4\. Client Code: Building and Using the Chain

Finally, the client creates the handlers, links them together to form the chain, and sends requests to the beginning of the chain.

```java
public class ApprovalSystem {
    public static void main(String[] args) {
        // 1. Create the handlers
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        // 2. Build the chain: Manager -> Director -> CEO
        manager.setNext(director);
        director.setNext(ceo);

        // 3. Send requests to the first handler in the chain
        System.out.println("--- Processing Leave Request ---");
        manager.processRequest(new Document("Leave", "Request for 2 days off."));
        
        System.out.println("\n--- Processing Budget Request ---");
        manager.processRequest(new Document("Budget", "Request for new project funding."));

        System.out.println("\n--- Processing Resignation Request ---");
        manager.processRequest(new Document("Resignation", "Letter of resignation."));
    }
}
```

### Output

```
--- Processing Leave Request ---
Manager approved the leave request: Request for 2 days off.

--- Processing Budget Request ---
Manager can't handle this. Passing to Director.
Director approved the budget request: Request for new project funding.

--- Processing Resignation Request ---
Manager can't handle this. Passing to Director.
Director can't handle this. Passing to CEO.
CEO approved the resignation: Letter of resignation.
```

As you can see, each request travels along the chain until it finds an object that can handle it. This makes your system flexible because you can add or remove handlers from the chain without changing the client code. ✨