package programpoppy.testDemo;

import programpoppy.service.QueryService;

import java.util.concurrent.ExecutionException;

public class demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QueryService queryService = new QueryService();
        System.out.println(queryService.queryAsync());
    }
}
