| Principle | Summary Tip                | How to spot problem?                                                                          |
|:-------|:---------------------------|:----------------------------------------------------------------------------------------------|
| SRP | "Do one thing only"        | The class is over 100 lines long or has many unrelated imports.                               |
|OCP | "Add, and do not edit"     | If you find yourself adding `case` statements to a `switch` (or a multibranch `if` statement. |
|LSP| "Do not surprise the user" | If you see a `throws new UnsupportedOperationException` or similar construct.                 |
|ISP| "Keep is lean and simple"  | A class implements an interface but leaves several of the methods effectively empty.          |
|DIP| "Depend on interfaces"      | You see the `new` keyword used to create a dependency inside a constructor.                   |