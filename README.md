# cloudstreetmarket.com

Spring MVC implements two common design patterns: the front controller design pattern and MVC design pattern.

Front controller
A system designed as a Front controller exposes a single entry point for all incoming requests.
In Java Web environments, this entry point is usually a servlet—a unique servlet that
dispatches and delegates to other components.
In the case of Spring MVC, this unique servlet is the DispatcherServlet.



@RequestMapping