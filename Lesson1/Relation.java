package Lesson1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * класс для описания связей между людьми
 */
public class Relation {
    enum Type {
        SPOUSES, // супруги
        CHILD, // ребенок
    };

    private int id1, id2;
    private Type type;

    public Relation(int id1, int id2, Type type) {
        setID1toID2(id1, id2, type);
    }

    void setID1toID2(int id1, int id2, Type type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }

    int getID1() {
        return id1;
    }

    int getID2() {
        return id2;
    }

    Type getTypeID1toID2() {
        return type;
    }

    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(id1);
        stream_out.writeInt(id2);
        stream_out.writeInt(type.ordinal());
    }
    
    public static Relation load(DataInputStream stream_in) throws IOException {
        int id1 = stream_in.readInt();
        int id2 = stream_in.readInt();
        int itype = stream_in.readInt();

        Type type;
        if (itype == Type.CHILD.ordinal())
            type = Type.CHILD;
        else
            type = Type.SPOUSES;

        return new Relation(id1, id2, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != Relation.class)
            return false;
        return ((Relation) obj).id1 == id1 && ((Relation) obj).id2 == id2 && ((Relation) obj).type == type;
    }

    @Override
    public int hashCode() {
        return id1 + (id2 << 16) + type.ordinal() << 24;
    }
}