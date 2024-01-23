import java.io.*;

public class SerialDeserial {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("John Doe", 25);

        // Serialize the object and write it to a file
        serializeObject(person, "person.ser");

        // Deserialize the object from the file and print its details
        Person deserializedPerson = deserializeObject("person.ser");

        if (deserializedPerson != null) {
            System.out.println("Deserialized Person: " + deserializedPerson);
        }
    }

    private static void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Object serialized and written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializeObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();

            if (obj instanceof Person) {
                return (Person) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}