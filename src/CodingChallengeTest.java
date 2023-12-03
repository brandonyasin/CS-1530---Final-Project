

import org.junit.Test;
import org.junit.Assert;

public class CodingChallengeTest {

    @Test
    public void codingChallengeTest(){
        String problem = "hello";
        String solution = "world";
        CodingChallenge chall = new CodingChallenge(problem,solution);
        Assert.assertEquals(solution, chall.solution);
        Assert.assertEquals(problem, chall.codingChallenge);
    }
    
}
