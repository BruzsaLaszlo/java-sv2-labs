package algorithmstransformation.family;

import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<FamilyMember> familyMembers;

    public Family() {
        familyMembers = new ArrayList<>();
    }

    public List<Integer> getAgesOfFamilyMembersWithNameGiven(String name) {

        List<Integer> list = new ArrayList<>();
        for (FamilyMember fm : familyMembers)
            if (fm.getName().contains(name))
                list.add(fm.getAge());

        return list;

    }

    public void addFamilyMember(FamilyMember familyMember) {
        familyMembers.add(familyMember);
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }
}
