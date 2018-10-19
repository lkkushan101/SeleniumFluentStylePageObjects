package InheritancePkg;

class Animal1{  
    void eat(){System.out.println("eating...");}  
}  
class Dog1 extends Animal{  
    void bark(){System.out.println("barking...");}  
}  
class BabyDog extends Dog1{  
    void weep(){System.out.println("weeping...");}  
}  
class MultilevelInheritance{  
	public static void main(String args[]){  
	BabyDog rover=new BabyDog();  
	rover.weep();  
	rover.bark();  
	rover.eat();  
}}  