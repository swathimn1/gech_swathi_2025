package constructor_in_java; //example for default constructor.

class Car1 {
	public String car_name;
	public float no_w;

	// default value for a int data_type is 0 and for float 0.0
	public Car1(String car_name, float no_w) {
		super();
		this.car_name = car_name;
		this.no_w = no_w;
	}

}

public class Constructor4 {

	public static void main(String[] args) {
		Car1 c = new Car1("Tesla", 4);
		System.out.println(c.car_name);
		System.out.println(c.no_w);
		// default constructor is used to assign a default value for an object.it has no
		// parameters and java compiler will automatically create a default constructor
		// when constructor is not explicitly created.
	}
//we cannot use a static keyword inside the constructor , because  constructor belongs to object not a class
//we can use  a access_modifiers like public,private and protected .
//we cannot use a final keyword in a constructor .
	// constructor cannot be inherited from parent to child.
}
