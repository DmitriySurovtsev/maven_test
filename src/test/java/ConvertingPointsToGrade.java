import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class ConvertingPointsToGrade {


    // 1. тест проверки получения оценки 2, если получил 0 баллов
    @Test
    public void getMinPoints (){
        var actualResult =  getMarkResult(0);
        Assertions.assertEquals("2",actualResult);
    }

    // 2. тест проверки получения оценки 2, если получил 35 баллов
    @Test
    public void getThirtyFivePoints (){
        var actualResult =  getMarkResult(35);
        Assertions.assertEquals("2",actualResult);
    }

    // 3. тест проверки получения оценки 2, при получении от 0 до 36 (не включительно) баллов
    @Test
    public void getGradeTwo (){

        var rnd = new Random();
        var actualResult =  getMarkResult(rnd.nextInt(0,36));
        Assertions.assertEquals("2",actualResult);
    }

    // 4. тест проверки получения оценки 3, если получил 36 баллов
    @Test
    public void getThirtySixPoints (){
        var actualResult =  getMarkResult(36);
        Assertions.assertEquals("3",actualResult);
    }

    // 5. тест проверки получения оценки 3, если получил 56 баллов
    @Test
    public void getFiftySixPoints (){
        var actualResult =  getMarkResult(56);
        Assertions.assertEquals("3",actualResult);
    }

    // 6. тест проверки получения оценки 4, если получил 57 баллов
    @Test
    public void getFiftySevenPoints (){
        var actualResult =  getMarkResult(57);
        Assertions.assertEquals("4",actualResult);
    }

    // 7. тест проверки получения оценки 4, если получил 71 баллов
    // upd: упадет, так как 71 балл не включен в оценку 4.
    @Test
    public void getSeventyOnePoints (){
        var actualResult =  getMarkResult(71);
        Assertions.assertEquals("4",actualResult);
    }

    // 8. тест проверки получения оценки 5, если получил 72 баллов
    // upd: упадет, так как 72 балла не включены в оценку 5.
    @Test
    public void getSeventyTwoPoints (){
        var actualResult =  getMarkResult(72);
        Assertions.assertEquals("5",actualResult);
    }

    // 9. тест проверки получения оценки 5, если получил 73 баллов
    @Test
    public void getSeventyThreePoints (){
        var actualResult =  getMarkResult(73);
        Assertions.assertEquals("5",actualResult);
    }

    // 10. тест проверки получения оценки 5, если получил 100 баллов
    // upd: упадет, так как 100 баллов не включены в оценку 5.
    @Test
    public void getMaxPoints (){
        var actualResult =  getMarkResult(100);
        Assertions.assertEquals("5",actualResult);
    }
    private String getMarkResult(Integer mark)

    {

        if(mark>=0 && mark <=35) return "2";

        if(mark>35 && mark <=56) return "3";

        if(mark>56 && mark<71) return "4";

        if(mark>72 && mark<100) return "5";

        return "no mark result";

    }

}
