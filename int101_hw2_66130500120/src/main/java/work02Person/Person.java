package work02Person;
import work01Utilitor.Utilitor;
public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = Utilitor.testString(firstname);
        this.lastname = Utilitor.testString(lastname);
        this.id = nextId++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person(").append(id).append(",").append(firstname).append(",").append(lastname).append(")");
        return sb.toString();
    }

    public int getId() {return id;}
    public String getFirstname() {return firstname;}
    public String getLastname() {return lastname;}

    public void setFirstname(String firstname) {
        this.firstname = Utilitor.testString(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname = Utilitor.testString(lastname);
    }

    @Override
    public boolean equals(Object obj) {return this == obj;}

}
