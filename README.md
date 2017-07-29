# The Awesome Framework

## About Awesome
A multi-DSAL development is a mode of application developemnt where in addition to one or more general purpose languages (e.g., Java, AspectJ), multiple domain-specific aspect languages (DSALs) are used. For example, one DSAL (e.g., COOL) may be used for implementing the thread synchronization concern, other for the security concern, etc. Awesome is an **aspect composition framework**. Awesome makes multi-DSAL development feasible by allowing to compose a variety of aspect mechanisms, each corresponding to a specific DSAL, into a single multi-mechanism weaver.

## Awesome Related Projects
We are working on the creation of a fully functioning environment for Awesome within the Eclipse IDE. The environment will support the whole DSAL composition process, from the creation of an individual aspect mechanism, to the construction of a multi-mechanism weaver. Overall, our goal is to simplify the creation of the mechanisms as much as possible, hence making multi-DSAL development practical. The following related projects are proposed:
1. **Eclipse SpecTackle SpecTackle** is a tool that helps in analyzing the various interactions that exist among multiple aspect mechanisms and to capture their resolution in a machine-readable format (for more info see the [SpecTackle paper](http://aop.cslab.openu.ac.il/research/awesome/papers/dsal12.pdf)). The goal of this project is to implement SpecTackle within the Eclipse IDE, emphasizing an enhanced graphical user interface. The project will involve Eclipse GUI-based plug-in development.
2. **Awesome Tracer** In this project, a module called awesome.tracer will be implemented. The module will consist of AspectJ aspects that trace the Awesome weaving process. The traced data will be logged to the file system and in addition a convenient API will be provided to access the data. The awesome.tracer module is essential for facilitating testing support for an aspect mechanism and for a multi-mechanism weaver.

## Awesome Links
* Awesome is in active development under a separate GitHub repository [[link](https://github.com/OpenUniversity/AOP-Awesome)]
* The main Awesome paper, appeared in OOPSLA'07 [[pdf](https://github.com/OpenUniversity/AOP-Awesome-Legacy/blob/master/resources/oopsla07.pdf)]
* A paper about adding debugging facilities to Awesome, appeared in AOSD'12 [[pdf](https://github.com/OpenUniversity/AOP-Awesome-Legacy/blob/master/resources/aosd12.pdf)]
* Another (shorter) paper about Awesome debugging, appeared in DSAL'11 [[pdf](https://github.com/OpenUniversity/AOP-Awesome-Legacy/blob/master/resources/dsal11.pdf)]
* A paper about the SpecTackle tool - a component of Awesome, appeared in DSAL'12 [[pdf](https://github.com/OpenUniversity/AOP-Awesome-Legacy/blob/master/resources/dsal12.pdf)]
