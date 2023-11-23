import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class RefundTicket {


/*    Аналитика
    В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:

    За 10 и более дней — получить обратно полную стоимость билета.
    От 6 до 10 дней включительно — получить 50% стоимости билета.
    От 3 до 5 дней включительно — получить 30% стоимости билета.
    За 72 часа и менее до начала концерта — стоимость билета не возвращается.*/

    @Test
    // 1. Возврат билета за 10+дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия
    public void RefundTicketWithinTenDaysMore (){

        var amountDaysInHours = getRefundTicketPricePercent(241,false,false);
        Assertions.assertEquals( 100,amountDaysInHours);
    }

    @Test
    // 2. Возврат билета ровно за 10 дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия
    public void RefundTicketWithinTenDays (){

        var amountDaysInHours = getRefundTicketPricePercent(240,false,false);
        Assertions.assertEquals( 50,amountDaysInHours);
    }

    @Test
    // 3. Возврат билета за 6 (не включительно)- 10 (не вклчительно) дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия
    public void RefundTicketBetweenSixAndTenDays (){

        Random rnd = new Random();
        var amountDaysInHours = getRefundTicketPricePercent(rnd.nextInt(145,240),false,false);
        Assertions.assertEquals( 50,amountDaysInHours);
    }

    @Test
    // 4. Возврат билета ровно за 6 дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия
    public void RefundTicketWithinSixDays (){

        var amountDaysInHours = getRefundTicketPricePercent(144,false,false);
        Assertions.assertEquals( 50,amountDaysInHours);
    }

    @Test
    // 5.Ошибка аналитики
    //  Возврат билета за 5 (не включительно) - 6 дней (не включительно) дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия

    public void RefundTicketBetweenFiveAndSixDays (){

        Random rnd = new Random();
        var amountDaysInHours = getRefundTicketPricePercent(rnd.nextInt(121,140),false,false);
        System.out.println("Ошибка. В постановке не учитывается данный диапазон");
        Assertions.assertEquals( null,amountDaysInHours);

    }

    @Test
    // 6.Возврат билета ровно за 5 дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия

    public void RefundTicketWithinFiveDays (){

        var amountDaysInHours = getRefundTicketPricePercent(120,false,false);
        Assertions.assertEquals( 30,amountDaysInHours);

    }

    @Test
    // 7. Возврат билета за 3 (не включительно)- 5 (не вклчительно) дней (в часах) до мероприятия и не связано с отменой/переносом мероприятия
    public void RefundTicketBetweenThreeAndFiveDays (){

        Random rnd = new Random();
        var amountDaysInHours = getRefundTicketPricePercent(rnd.nextInt(73,120),false,false);
        Assertions.assertEquals( 30,amountDaysInHours);
    }

    @Test
    // 8.Возврат билета ровно за 3 дня (в часах) до мероприятия и не связано с отменой/переносом мероприятия

    public void RefundTicketWithinThreeDays (){

        var amountDaysInHours = getRefundTicketPricePercent(72,false,false);
        Assertions.assertEquals( 0,amountDaysInHours);

    }

    @Test
    // 9.Возврат билета менее чем за 72 часа (3 дня) до мероприятия и не связано с отменой/переносом мероприятия

    public void RefundTicketBetweenZeroAndThreeDays (){

        Random rnd = new Random();
        var amountDaysInHours = getRefundTicketPricePercent(rnd.nextInt(1,72),false,false);
        Assertions.assertEquals( 0,amountDaysInHours);

    }

    @Test
    // 10.Возврат билета в самом начале или во время концерта концерта

    public void RefundTicketDuringConcert(){

        var amountDaysInHours = getRefundTicketPricePercent(0,false,false);
        Assertions.assertEquals( 0,amountDaysInHours);

    }

    @Test
    // 11.Возврат билета связанный с отменой/переносом мероприятия

    public void RefundTicketWhenConcertCanceled(){

        var amountDaysInHours = getRefundTicketPricePercent(48,true,false);
        Assertions.assertEquals( 100,amountDaysInHours);

    }

    @Test
    // 12.Возврат билета связанный с отменой/переносом мероприятия

    public void RefundTicketWhenConcertRescheduled(){

        var amountDaysInHours = getRefundTicketPricePercent(24,false,true);
        Assertions.assertEquals( 100,amountDaysInHours);

    }


    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)

    {

        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
