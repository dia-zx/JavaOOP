package Lesson2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

import Lesson2.Interfaces.IioStream;

public class Person implements IioStream {
    enum Gender {
        MALE,
        FEMALE;
    }

    protected int id;
    public String name;
    public String family;
    public String middle_name;
    public Date birthday;
    public Gender gender;
    public String info;

    public Person(int id) {
        this.id = id;
        name = "";
        family = "";
        middle_name = "";
        birthday = new Date();
        info = "";
    }

    public Person(int id, String name, String family, String middle_name, Gender gender) {
        this(id);
        this.name = name;
        this.family = family;
        this.middle_name = middle_name;
    }

    public int get_id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != Person.class)
            return false;
        return this.id == ((Person) obj).id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return family + " " + name + " " + middle_name + " " + birthday + " id: " + id;
    }

    /**
     * Метод для передачи данных в поток
     * 
     * @param stream_out
     * @throws IOException
     */
    @Override
    public void save(DataOutputStream stream_out) throws IOException {
        stream_out.writeInt(id);
        stream_out.writeUTF(name);
        stream_out.writeUTF(family);
        stream_out.writeUTF(middle_name);
        stream_out.writeLong(birthday.getTime());
        int igender = 0;
        if (gender == Gender.FEMALE)
            igender = 1;
        stream_out.writeInt(igender);
        stream_out.writeUTF(info);
    }

    /**
     * Метод для чтения объекта Person из потока
     * 
     * @param stream_in
     * @throws IOException
     */
    @Override
    public void load(DataInputStream stream_in) throws IOException {
        int id = stream_in.readInt();
        String name = stream_in.readUTF();
        String family = stream_in.readUTF();
        String middle_name = stream_in.readUTF();
        Date birthday = new Date(stream_in.readLong());
        int igender = stream_in.readInt();
        String info = stream_in.readUTF();
        Gender gender = Gender.MALE;
        if (igender == 1)
            gender = Gender.FEMALE;

        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.birthday = birthday;
        this.family = family;
        this.info = info;
        this.gender = gender;
    }

}
