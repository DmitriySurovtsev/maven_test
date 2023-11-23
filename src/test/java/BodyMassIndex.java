import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BodyMassIndex {

    // 1. тест проверки ситуации, когда указан рост 0
//    @Test
//    public  void testZeroHeight(){
//      var actualResult = getIMTResult(0f,65f);
//      Assert.assertEquals("указан некорректный рост",actualResult);
//    }

    // 2. Тест проверки ситуации, когда указан вес 0
//   @Test
//    public  void testZeroWeight(){
//        var actualResult = getIMTResult(180f,0f);
//        Assert.assertEquals("указан некорректный вес",actualResult);
//    }

    // 3. тест проверки соответствия нормальной массе тела
    @Test
    public void testNormalWeight (){

        var actualResult = getIMTResult(180f,75f);
        Assertions.assertEquals("нормальной массе тела",actualResult);

    }
    // 4. тест проверки соответствия выраженному дефициту массы тела
    @Test
    public void testCriticalWeight (){

        var actualResult = getIMTResult(185f,40f);
        Assertions.assertEquals("выраженному дефициту массы тела",actualResult);

    }
    // 5. тест проверки соответствия недостаточной массе тела
    @Test
    public void testDeficitWeight (){

        var actualResult = getIMTResult(185f,60f);
        Assertions.assertEquals("недостаточной массе тела",actualResult);

    }

    // 5. тест проверки соответствия недостаточной массе тела
    @Test
    public void testExcessWeight (){

        var actualResult = getIMTResult(170f,90f);
        Assertions.assertEquals("избыточной массе тела",actualResult);

    }

    private String getIMTResult(Float heightCm, Float weightKg) {

        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));

        String userResult = null;

        if (userIndex <= 16) {

            userResult = "выраженному дефициту массы тела";

        } else if (userIndex < 19) {

            userResult = "недостаточной массе тела";

        } else if (userIndex > 19 && userIndex < 25) {

            userResult = "нормальной массе тела";

        } else if (userIndex > 25) {

            userResult = "избыточной массе тела";

        }

        if (heightCm.equals(0.0f)) userResult += "указан некорректный рост";
        return userResult;

    }
}

