package com.troy.trade.web;

import com.troy.trade.model.domain.exchange.ExchangeFuturesSymbolModel;
import com.troy.trade.scheduled.FuturesTickerExecute;
import com.troy.trade.scheduled.InstrumentsExecute;
import com.troy.trade.scheduled.KLineExecute;
import com.troy.trade.service.IExchangeFuturesSymbolService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

/**
 * @author
 * @date 2019/12/17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
@AutoConfigureMockMvc
public class ExchangeFuturesSymbolTest {

    @Autowired
    private IExchangeFuturesSymbolService iExchangeFuturesSymbolService;

    @Autowired
    private FuturesTickerExecute futuresTickerExecute;

    @Autowired
    private InstrumentsExecute instrumentsExecute;

    @Autowired
    private KLineExecute kLineExecute;


    public void test(){
        List<ExchangeFuturesSymbolModel> list = iExchangeFuturesSymbolService.getFuturesSymbolsFromCache("okexfuturesdelivery");
        System.out.println(list.size());
    }

    @Test
    public void test2(){
        // kLineExecute.futuresKline();

        // instrumentsExecute.initInstruments();

        // instrumentsExecute.initDbInstruments();

        futuresTickerExecute.ticker();

        try {
            System.out.println("----------------");
            Thread.sleep(1000l*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
