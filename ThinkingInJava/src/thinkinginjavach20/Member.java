// 12
package thinkinginjavach20;

@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) private String firstName;
    @SQLString(50) private String lastName;
    @SQLInteger private Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;
    static int memberCount;
    
    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return handle;
    }
}
