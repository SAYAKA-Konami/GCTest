package wn.gc.benchmark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/gc")
public class GCController {

    /**
     *  模拟应用服务中的常量、缓存等对象
     *  占用500M的堆内存
     */
    private static  final int[] CONSTANT  = new int[1024 * 1024 * 125];

    private final Random random = new Random();

    @GetMapping("/allocate")
    public void allocate(){
        try {
            // 假设一个请求需要耗费1M的堆内存空间
            int[] allocate = new int[1024 * 256];
            int i = random.nextInt(5) + 1;
            // 模拟请求耗时，随机耗时100-500毫秒
            Thread.sleep(i * 100);
        }catch (Exception e){
            // ignore
        }
    }
}
