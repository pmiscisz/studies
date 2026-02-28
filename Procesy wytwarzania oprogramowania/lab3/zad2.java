
final class PeopleInfo {

    public double humanId(Human hmn) {
        if (hmn instanceof Student) {
            return hmn.getIndex();
        }
        if (hmn instanceof Teacher) {
            return hmn.getEmploeeNumber();
        }
    }
}

public class Student {

}

public class Teacher {

}
