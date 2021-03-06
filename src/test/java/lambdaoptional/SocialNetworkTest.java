package lambdaoptional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;


class SocialNetworkTest {

    @Test
    void testCreateMember() {
        Member member = new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE);
        assertEquals("John Doe", member.getName());
        assertEquals(Arrays.asList("Java", "OOP"), member.getSkills());
        assertEquals(Gender.MALE, member.getGender());
    }

    @Test
    void testFindFirst() {
        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));

        assertFalse(socialNetwork.findFirst(m -> m.getName().equals("Joe")).isPresent());

        assertTrue(socialNetwork.findFirst(m -> m.getName().equals("John Doe")).isPresent());
        assertEquals("John Doe", socialNetwork.findFirst(m -> m.getName().equals("John Doe")).get().getName());
    }

    @Test
    void testAvg() {
        assertEquals(false, new SocialNetwork(Collections.emptyList()).averageNumberOfSkills().isPresent());

        SocialNetwork socialNetwork = new SocialNetwork(Arrays.asList(
                new Member("John Doe", Arrays.asList("Java", "OOP"), Gender.MALE),
                new Member("Jane Doe", Arrays.asList(".NET", "OOP"), Gender.FEMALE),
                new Member("James Doe", Arrays.asList("Python", "Java", "OOP"), Gender.MALE),
                new Member("Janet Doe", Arrays.asList("JavaScript", "scripting"), Gender.MALE)
        ));


        assertEquals(2.25, socialNetwork.averageNumberOfSkills().get());
    }
}