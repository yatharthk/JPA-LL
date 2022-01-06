# JPA-LL - Inheritance Strategies.
1. Single Inheritance Mapping Strategy - (The default strategy used on Inherited class if not specified by user.)
    a. One parent table contains all the sub class entitiy fields and 
    b. Automatically adds a DescriptionType(DTYPE) column to seperate the entity from each other. 
    c. @Inheritance(strategy = Inheritance.SINGLE_TABLE)
    d. No tables for subclasses.
    
2. MappedSuper Class - 
    a. The parent class is annotated with @MappedSuperclass and table will not be created for this parent class.
    b. the sub classes will have @Entity annotation .
    c. Subclasses will have their tables  which will contain the fields of parent class.
   
    
3. TablePerClass - 
    
    a. This strategy creates concrete/ full classes . the subclasses includes columns of parent classes too.
    b. Subclasses hold properties/fields of parent class.
    c. @Inheritance(strategy=Inheritance.TABLE_PER_CLASS)
    
4. JoinedTable - 
    
    a. Each class in the heirarchy is mapped to own table with its own fields only. 
    b. One extra field is added in the subclass that is used as a foreign key just to mapp out the subclasses (eg. parent class id field pk to parent )-->(fk to sub classes)
    c. Subclasses donot hold properties/columns of parent class.
    d. @Inheritance(strategy = Inheritance,JOINED_TABLE)
