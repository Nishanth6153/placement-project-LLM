import java.io.Serializable;
public class Pet implements Serializable {

    private int petId;
    private String name;
    private String species;
    private int age;

    public Pet() {
    }
    public Pet(int petId, String name, String species, int age) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if(age <= 0 || age > 25)
            throw new Exception("Invalid age");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet [petId=" + petId + ", name=" + name +", species=" + species + ", age=" + age + "]";
    }
}