package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        float total = 0;
        for (String utorid : members) {
            total += gradeDB.getGrade(utorid, course).getGrade();
        }
        return total / members.length;
    }
}
