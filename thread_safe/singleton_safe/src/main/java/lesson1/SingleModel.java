package lesson1;

public class SingleModel {
//    private static SettingsManager sInst = null;
//    public static SettingsManager getInstance() {
//        if (sInst == null) {                             // 1
//            synchronized (SettingsManager.class) {       // 2
//                SettingsManager inst = sInst;            // 3
//                if (inst == null) {                      // 4
//                    inst = new SettingsManager();        // 5
//                    sInst = inst;                        // 6
//                }}}return sInst;                         // 7
//    }

//=========上面的代码是有风险的，下面是详细解析==========================//
//    线程 1 运行到 1 处，第一次进入，这里肯定是为 true 的；
//    线程 1 运行到 2 处，获得锁 SettingsDbHelper.class；
//    线程 1 运行到 3 和 4 处，赋值 inst = sInst，这时 sInst 还是 null，所以继续往下运行，创建一个新的实例；
//    线程 1 运行到 6 处，修改 sInst 的值。这一步非常关键，这里的解析是，因为这些修改可能因为和其他赋值操作运行被重新排序（Re-order），这就可能导致先修改了 sInst 的值，而 new SettingsDbHelper(context) 这个构造函数并没有执行完。而在这个时候，程序切换到线程 2；
//    线程 2 运行到 1 处，因为第 4 步的时候，线程 1 已经给 sInst 赋值了，所以 sInst == null 的判断为 false，线程 2 就直接返回 sInst 了，但是这个时候 sInst 并没有被初始化完成，直接使用它可能会导致程序崩溃。


/*******为了解决上面的问题，修改代码如下***************/
private static volatile SettingsManager sInst = null;  // <<< 这里添加了 volatile
    public static SettingsManager getInstance() {
        SettingsManager inst = sInst;  // <<< 在这里创建临时变量
            if (sInst == null) {
                synchronized (SettingsManager.class) {
                inst = sInst;
                if (inst == null) {
                    inst = new SettingsManager();
                    sInst = inst;
                }
            }
        }
        return inst;  // <<< 注意这里返回的是临时变量
    }


}
