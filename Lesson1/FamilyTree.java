package Lesson1;

/**
 * FamilyTree
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
    private HashMap<Integer, Person> persons;
    private int id_counter;

    public FamilyTree() {
        persons = new HashMap<>();
        id_counter = 0;
    }

    public void save(String file_path) {
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(file_path))) {
            ds.writeInt(persons.size());
            for (Person it : persons.values()) {
                it.save(ds);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void load(String file_path) {
        try (DataInputStream ds = new DataInputStream(new FileInputStream(file_path))) {
            persons = new HashMap<>();
            int count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Person person = Person.load(ds);
                persons.put(person.get_id(), person);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Person addPerson(String name, String family, String middle_name, Person.Gender gender) {
        // #region Получим уникальный ID
        while (persons.containsKey(id_counter))
            id_counter++;
        // #endregion
        Person person = new Person(id_counter, name, family, middle_name, gender);
        persons.put(id_counter, person);
        return person;
    }

    public boolean deletePerson(int id) {
        if (persons.containsKey(id) == false)
            return false;
        persons.remove(id);
        return true;
    }
    
    
    public List<Person> findPersonID(String name, String family, String middle_name) {
        List<Person> res = new ArrayList<>();
        for (Person person : persons.values()) {
            if(person.name.equals(name) && person.family.equals(family) && person.middle_name.equals(middle_name)){
                res.add(person);
            }
        }
        return res;
    }
}