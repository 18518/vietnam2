
public class Test {
	public static void main(String[] args) {
		Animals animal;
		animal = new Dog();
		System.out.println(animal.say());
		animal = new Cat();
		System.out.println(animal.say());
		animal = new Cow();
		System.out.println(animal.say());

	}


}
