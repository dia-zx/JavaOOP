package Lesson1;

import java.util.ArrayList;
import java.util.List;

import Lesson1.Relation.Type;

public class FamilyTreeUtils {
    private FamilyTree familyTree;

    public FamilyTreeUtils(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
    
    public void testFillTree() {
        Person person1 = familyTree.addPerson("Дмитрий", "Ермоленко", "Юрьевич", Person.Gender.MALE);
        Person person21 = familyTree.addPerson("Валентина", "Округина", "Владимировна", Person.Gender.FEMALE);
        Person person22 = familyTree.addPerson("Иван", "Ермоленко", "Николаевич", Person.Gender.MALE);
        Person person31 = familyTree.addPerson("Любовь", "Безрукова", "Ивановна", Person.Gender.FEMALE);
        Person person32 = familyTree.addPerson("Владимир", "Округин", "Иванович", Person.Gender.MALE);
        Person person33 = familyTree.addPerson("Вера", "Евдокимовна", "Михайловна", Person.Gender.FEMALE);
        Person person34 = familyTree.addPerson("Николай", "Ермоленко", "Федорович", Person.Gender.MALE);

        familyTree.addRelation(new Relation(person21.id, person1.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person22.id, person1.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person31.id, person21.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person32.id, person21.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person33.id, person22.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person34.id, person22.id, Relation.Type.CHILD));
    }

    public void print() {
        for (Person person : familyTree.getPersons()) {
            System.out.println(person);
        }
    }

    public List<Person> FindParents(int id) {
        List<Person> res = new ArrayList<>();
        for (Relation relation : familyTree.getRelations()) {
            if (relation.getID1() == id && relation.getTypeID1toID2() == Type.CHILD)
            if(familyTree.getPerson(relation.getID2()) != null)
                res.add(familyTree.getPerson(relation.getID2()));
        }
        return res;
    }
    
}
