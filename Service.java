import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service implements DAO {

    private File data;
    private List<Pet> pets;

    public Service() {
        this.data = new File("petinfo.doc");
        if (!data.exists())
        try {
            this.data.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(data);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pets);
            oos.close();
            fos.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    private void readFromFile() {
        try {
            FileInputStream fis = new FileInputStream(data);
            if (data.length() == 0)
                pets = new ArrayList<>();
            else {
                ObjectInputStream ois = new ObjectInputStream(fis);
                pets = (List<Pet>) ois.readObject();
                ois.close();
            }
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {ex.printStackTrace();}
    }

    @Override
    public void add(Pet pet) {
        readFromFile();
        pets.add(pet);
        writeToFile();
        System.out.println("Pet added successfully");
    }

    @Override
    public void update(Pet pet) {
        readFromFile();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPetId() == pet.getPetId()) {
                pets.set(i, pet);
                writeToFile();
                System.out.println("Pet updated successfully");
                return;
            }
        }
        System.out.println("Pet not found");
    }

    @Override
    public List<Pet> fetchAll() {
        readFromFile();
        return pets;
    }

    @Override
    public void deleteById(int petId) {
        readFromFile();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getPetId() == petId) {
                pets.remove(i);
                writeToFile();
                System.out.println("Pet deleted successfully");
                return;
            }
        }
        System.out.println("Pet not found");
    }
}
