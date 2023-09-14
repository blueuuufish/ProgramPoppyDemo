package Joint;

import java.util.concurrent.RecursiveTask;

public class TaskJoint extends RecursiveTask<Long> {
    private int start;
    private int end;
    private long sum;

    public TaskJoint(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println("任务" + start + "=========" + end + "累加开始");
        if (end - start <= 100){
            for (int i = start; i <= end; i++) sum += i;
        } else {
            TaskJoint taskJoint1 = new TaskJoint(start, start + 100);
            TaskJoint taskJoint2 = new TaskJoint(start + 101, end);
            taskJoint1.fork();
            taskJoint2.fork();
            sum = taskJoint1.join() + taskJoint2.join();
        }
        return sum;
    }
}
