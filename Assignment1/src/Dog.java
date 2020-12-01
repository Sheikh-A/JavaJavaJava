
public class Dog {

	
	private String name;
	private String breed;
	private int age;
	private double weight;
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
		age = 0;
		weight = 125;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}
	
	public void eat() {
		System.out.println("Fatty");
		weight += 0.1;
	}
	
	public void rename(String newName) {
		name = newName;
	}
	
	public void bday() {
		System.out.println("Happy Bday");
		age++;
	}
	
	public static void main(String[] args) {
		
		Dog tess = new Dog("Tess", "Mixed");
		
		System.out.println(tess.getBreed());
		System.out.println(tess.getName());
		System.out.println(tess.getAge());
		System.out.println(tess.getWeight());
		
		tess.eat();
		tess.eat();
		tess.eat();
		
		System.out.println(tess.getWeight());
		
		tess.bday();
		System.out.println(tess.getAge());
		tess.bday();
		System.out.println(tess.getAge());
		
		
		
		
	}
	
	
	
}
