package Lesson4;

import java.util.ArrayList;
import java.util.List;

import Lesson4.Relation.Type;

public class FamilyTreeUtils<T extends Person> {
    private FamilyTree<T> familyTree;

    public FamilyTreeUtils(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree<T> geFamilyTree() {
        return familyTree;
    }

    public void print() {
        for (T person : familyTree.getPersons()) {
            System.out.println(person);
        }
    }

    /**
     * Поиск по дереву родителей персоны id
     * 
     * @param id
     * @return
     */
    public List<T> FindParents(int id) {
        List<T> res = new ArrayList<>();
        for (Relation relation : familyTree.getRelations()) {
            if (relation.getID1() == id && relation.getTypeID1toID2() == Type.CHILD)
                if (familyTree.getPerson(relation.getID2()) != null)
                    res.add(familyTree.getPerson(relation.getID2()));
        }
        return res;
    }

}
