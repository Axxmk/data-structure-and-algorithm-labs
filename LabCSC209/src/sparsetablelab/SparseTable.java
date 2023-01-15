package sparsetablelab;

public class SparseTable {
    RegisterNode[] students;  // [0,1,2,3,4,5, ... ,7999]
    RegisterNode[] classes;   // [0,1,2,3,4,5, ... ,299]

    public SparseTable(int studentsAmount, int classesAmount) {
        this.students = new RegisterNode[studentsAmount];
        this.classes = new RegisterNode[classesAmount];
    }

    public void addRegister(int studentId, int classId) {
        RegisterNode newRegis = new RegisterNode(studentId, classId, -1, null, null);

        if(this.students[studentId] == null || classId < this.students[studentId].classId) {   // student[300] is null
            newRegis.nextClass = this.students[studentId];
            this.students[studentId] = newRegis;
        }
        else {  // this is not his/her first class
            RegisterNode c;  // which class
            for(c = this.students[studentId]; c.nextClass != null && c.nextClass.classId < classId; c = c.nextClass);
            newRegis.nextClass = c.nextClass;
            c.nextClass = newRegis;
        }

        if(this.classes[classId] == null || studentId < this.classes[classId].studentId) {
            newRegis.nextPerson = this.classes[classId];
            this.classes[classId] = newRegis;
        }
        else {
            RegisterNode p;   // which person
            for (p = this.classes[classId]; p.nextPerson != null && p.nextPerson.studentId < studentId; p = p.nextPerson);
            newRegis.nextPerson = p.nextPerson;
            p.nextPerson = newRegis;
        }
    }
}
