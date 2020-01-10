package com.troy.trade.util;

import com.troy.commons.dto.in.Req;
import com.troy.commons.dto.in.ReqData;
import com.troy.commons.dto.in.ReqFactory;
import com.troy.commons.dto.in.ReqHead;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 构造测试Req
 *
 * @author zhangchengjie
 * @date 2019/08/23
 */
@Slf4j
public class ReqBuilder {

    static public <T extends ReqData> Req<T> build(T target) {
        ReqHead reqHead = new ReqHead();
        reqHead.setTimestamp(System.currentTimeMillis());
        reqHead.setClientId(UUID.randomUUID().toString());
        reqHead.setLogId(UUID.randomUUID().toString());

        Req<T> req = ReqFactory.getInstance().createReq(new ReqHead(), target);
        log.info("finish build req, req: [{}]", req);
        return req;
    }

}
