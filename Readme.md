
<u><b>What are we using...</b></u>
- MySQL
- Spring
- Thyme


<u><b>Why are we using...</u></b>
- MySQL - To allow storing of blogs and other data in a coherent and efficient way
- Spring - To handle Java Servlets/ logic & site navigation control
- Thyme - To handle presentation of html files and extend capabilities vs. JSPs


<u><b>Notes</u></b>

- Spring 

  - Annotations

    - @SpringBootApplication - Init project 
    - @Controller - Before class declaration, hooks Thyme to java
    - @GetMapping - Allows hooking to web address
      - @PathVariable - Allows java to use arguments passed via web address
    - @RequestMappIng(path = {String}, method = RequestMethod.{GET or POST})

  - Models (Thyme)
  
    - Model - automatically generated and sent from .html ineraction declare as passed argument in method
    - model.addAttribute({String}, {Variable}) - Allows sending attributes back into another .html file
    - return {stringName} - Spring will attempt to pull up the .html file in your project with a matching name


- Thyme

    //Import Thyme, in header in html

    < html xmlns:th="http://www.thymeleaf.org" >