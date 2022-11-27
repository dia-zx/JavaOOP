package Lesson4;

/**
 * FamilyTree
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Lesson4.Relation.Type;

public class FamilyTree<T extends Person> {
    private HashMap<Integer, T> persons;
    private ArrayList<Relation> relations;
    private int id_counter;
    private T person_object;

    /**
     * Ввиду ограниченности возможностей Java (new T() - нельзя создать объект
     * обобщенного типа..)
     * передаем в конструктор уже созданный экзепляр, от которого будем создавать
     * другие..
     * 
     * @param person_object
     */
    public FamilyTree(T person_object) {
        this.person_object = person_object;
        persons = new HashMap<>();
        relations = new ArrayList<>();
        id_counter = 0;
    }

    /**
     * Сохранение дерева в файл
     * 
     * @param file_path путь к файлу
     */
    public void save(String file_path) {
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(file_path))) {
            ds.writeInt(persons.size());
            for (T it : persons.values()) {
                it.save(ds);
            }
            ds.writeInt(relations.size());
            for (Relation it : relations) {
                it.save(ds);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Загрузка дерева из файла
     * 
     * @param file_path путь к файлу
     */
    public void load(String file_path) {
        try (DataInputStream ds = new DataInputStream(new FileInputStream(file_path))) {
            persons.clear();
            relations.clear();
            int count = ds.readInt();
            for (int i = 0; i < count; i++) {
                T person = (T) person_object.createObject(0);
                person.load(ds);
                persons.put(person.get_id(), person);
            }

            count = ds.readInt();
            for (int i = 0; i < count; i++) {
                Relation relation = new Relation(0, 0, Type.CHILD);
                relation.load(ds);
                relations.add(relation);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Добавление персоны
     * 
     * @return
     */
    public T addPerson(T tperson) {
        // #region Получим уникальный ID
        while (persons.containsKey(id_counter))
            id_counter++;
        // #endregion
        T person = (T) tperson.createObject(id_counter);
        persons.put(id_counter, person);
        return person;
    }

    /**
     * Удаление персоны с ID
     * 
     * @param id
     * @return true - OK
     */
    public boolean deletePerson(int id) {
        if (persons.containsKey(id) == false)
            return false;
        persons.remove(id);
        return true;
    }

    public T getPerson(int id) {
        if (persons.containsKey(id) == false)
            return null;
        return persons.get(id);
    }

    /**
     * Поиск ID персоны по ФИО
     * 
     * @param name
     * @param family
     * @param middle_name
     * @return
     */
    public List<T> findPersonID(String name, String family, String middle_name) {
        List<T> res = new ArrayList<>();
        for (T person : persons.values()) {
            if (person.name.equals(name) && person.second_name.equals(family)
                    && person.middle_name.equals(middle_name)) {
                res.add(person);
            }
        }
        return res;
    }

    /**
     * Возвращаем список персон
     * 
     * @return
     */
    public Collection<T> getPersons() {
        return persons.values();
    }

    /**
     * Добавление связи между персонами
     * 
     * @param relation
     * @return true - OK
     */
    public boolean addRelation(Relation relation) {
        for (Relation it : relations) {
            if (it.equals(relation))
                return true;
            if (it.getID1() == relation.getID1() && it.getID2() == relation.getID2())
                return false; // уже есть связь
            if (it.getID1() == relation.getID2() && it.getID2() == relation.getID1())
                return false; // уже есть связь
        }
        relations.add(relation);
        return true;
    }

    /**
     * Удаление связи меду персонами id1 b id2
     * 
     * @param id1
     * @param id2
     * @return
     */
    public boolean deleteRelation(int id1, int id2) {
        for (int i = 0; i < relations.size(); i++) {
            if ((relations.get(i).getID1() == id1 && relations.get(i).getID2() == id2) ||
                    (relations.get(i).getID1() == id2 && relations.get(i).getID2() == id1)) {
                relations.remove(i);
                return true;
            }

        }
        return false;
    }

    /**
     * Возвращаем список связей персон
     * 
     * @return
     */
    public ArrayList<Relation> getRelations() {
        return (ArrayList<Relation>) relations.clone(); // возвращаем клон, чтобы обезопаситься от изменения Списка
                                                        // (правда, содержимое все равно передаем по ссылке..)
    }
}