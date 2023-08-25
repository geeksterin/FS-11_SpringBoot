public class Dog extends Animal{

    private String breed;

    Dog(String breed)
    {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void produceSound() {
        System.out.println("Bhau Bhau Bhau!!!");
    }
}
