package Lesson4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * SpecialPerson
 */
public class SpecialPerson extends Person {
    public String birthday_place;

    public SpecialPerson(int id) {
        super(id);
        birthday_place = "";
    }

    public SpecialPerson(int id, String name, String second_name, String middle_name, Gender gender, String birthday_place) {
        super(id, name, second_name, middle_name, gender);
        this.birthday_place = birthday_place;
    }

    @Override
    public Object createObject(int id) {
        SpecialPerson newPerson = new SpecialPerson(id);
        newPerson.name = name;
        newPerson.birthday = birthday;
        newPerson.birthday_place = birthday_place;
        newPerson.second_name = second_name;
        newPerson.gender = gender;
        newPerson.info = info;
        newPerson.middle_name = middle_name;
        return newPerson;
    }

    @Override
    public void save(DataOutputStream stream_out) throws IOException {
        super.save(stream_out);
        stream_out.writeUTF(birthday_place);
    }

    @Override
    public void load(DataInputStream stream_in) throws IOException {
        super.load(stream_in);
        String birthday_place = stream_in.readUTF();
    }

    @Override
    public String toString() {
        return second_name + " " + name + " " + middle_name + " " + birthday + " (" + birthday_place + ") " + " id: " + id;
    }
}