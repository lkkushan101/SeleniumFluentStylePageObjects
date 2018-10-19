package InheritancePkg;

class Animal{  
 private int age; 
public void setage(int agevalue)
{
	age = agevalue;
}
public int getAge ()
{
	return age;
}
void eat(){System.out.println("eating...");}  
}  
class Dog extends Animal{  

	void bark(){System.out.println("barking...");}  
}  
class SingleInhetitance{  

 public static void main(String args[]){  
    Dog rover=new Dog();  
    rover.bark();  
    rover.eat();  
    
    rover.setage(12);
    System.out.println(rover.getAge());
}}  