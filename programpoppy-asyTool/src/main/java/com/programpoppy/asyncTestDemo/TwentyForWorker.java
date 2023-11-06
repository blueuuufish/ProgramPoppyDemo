package com.programpoppy.asyncTestDemo;

import cn.hutool.http.HttpUtil;
import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwentyForWorker implements IWorker<String, String>, ICallback<String, String> {

    public static final String APPKey = "4008208820";
    public static final String URL = "https://api.fzu.wuhu.com";

    public static final Logger LOGGER = LogManager.getLogger(TwentyForWorker.class);


    @Override
    public void begin() {
        // System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
        ICallback.super.begin();
    }

    @Override
    public String defaultValue() {
        return IWorker.super.defaultValue();
    }

    @Override
    public void result(boolean success, String param, WorkResult<String> workResult) {
        if (success) {
            System.out.println("callback twentyFourWorker success--" + SystemClock.now() + "---" + workResult.getResult()
                    + "-threadName:" + Thread.currentThread().getName());
        } else {
            System.err.println("callback twentyFourWorker failure--" + SystemClock.now() + "----"  + workResult.getResult()
                    + "-threadName:" +Thread.currentThread().getName());
        }
    }

    @Override
    public String action(String object, Map<String, WorkerWrapper> allWrappers) {
        String url = URL + "?appkey=" + APPKey;
        String result = HttpUtil.get(url);

        // 模拟时长
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            // 两种日志系统
            LOGGER.error("[二十四节气]>>>> 异常: {}", e.getMessage(), e);
            log.error("[二十四节气]>>>> 异常: {}", e.getMessage(), e);
        }

        return result;
    }
}
