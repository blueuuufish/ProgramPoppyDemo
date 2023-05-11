package demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelDemo {

    public static void main(String[] args) {
        
        
        while (true) {
            try (Entry entry = SphU.entry("HelloWorld")) {
                System.out.println("hello world");
            } catch (BlockException ex) {
                System.out.println("blocked");
            }
        }

    }
    
    public static void initFlowRules() {
        /*
        * 其中，List<FlowRule> rules = new ArrayList<>() 定义了一个 FlowRule 的列表，用于存储要加载的规则。
        * 接着创建了一个 FlowRule 对象，并调用它的 setResource 方法将资源名称设置为 "HelloWorld"。
        * 然后再通过 setGrade 方法将流控模式设置为 QPS，通过 setCount 方法将阈值设置为 20。
        * 最后将这个 FlowRule 对象添加到规则列表中，并调用 FlowRuleManager 的 loadRules 方法将这些规则加载到 Sentinel 中去。
        * */
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);

        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
