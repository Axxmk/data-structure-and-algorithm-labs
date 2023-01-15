package sparsetablelab;

public class RegisterNode {
    int studentId;
    int classId;
    double grade;
    RegisterNode nextPerson;
    RegisterNode nextClass;

    public RegisterNode(int studentId, int classId, double grade, RegisterNode nextPerson, RegisterNode nextClass) {
        this.studentId = studentId;
        this.classId = classId;
        this.grade = grade;
        this.nextPerson = nextPerson;
        this.nextClass = nextClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public RegisterNode getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(RegisterNode nextPerson) {
        this.nextPerson = nextPerson;
    }

    public RegisterNode getNextClass() {
        return nextClass;
    }

    public void setNextClass(RegisterNode nextClass) {
        this.nextClass = nextClass;
    }
}
