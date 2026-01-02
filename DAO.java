import java.util.List;

public interface DAO {
    public void add(Pet pet);
    public void update(Pet pet);
    public List<Pet> fetchAll();
    public void deleteById(int petId);
}