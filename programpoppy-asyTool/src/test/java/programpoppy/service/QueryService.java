package programpoppy.service;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
public class QueryService {

    /**
     * 异步返回结果
     *     ---- 方式：AsyncTool并行处理
     *
     * @return 结果
     */
    public Map<String, Object> queryAsync() throws ExecutionException, InterruptedException {
        // 声明worker
        TwentyForWorker twentyFourWorker = new TwentyForWorker();

        // 构建二十四节气worker
        WorkerWrapper<String, String> twentyFourWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(twentyFourWorker)
                .callback(twentyFourWorker)
                .param("0")
                .build();

        // 构建星座worker
        //WorkerWrapper<String, String> constellationWrapper =  new WorkerWrapper.Builder<String, String>()
        //        .worker(constellationWorker)
        //        .callback(constellationWorker)
        //        .param("1")
        //        .build();

        // 开始工作，这里设定超时时间10s，测试时可以设短一点看效果。
        Async.beginWork(10000, twentyFourWrapper);

        // 打印当前线程数
        log.debug("----------------- 当前线程数 ----------------");
        log.debug(Async.getThreadCount());

        // 打印结果
        log.debug("----------------- 二十四节气 ----------------");
        log.debug("结果: {}", twentyFourWrapper.getWorkResult());

        // 返回
        Map<String, Object> map = new HashMap<>();
        map.put("twentyFour", twentyFourWrapper.getWorkResult());

        // 关闭(spring web类应用不用关闭，否则第二次执行会报线程池异常。)
        // Async.shutDown();

        return map;
    }
}
