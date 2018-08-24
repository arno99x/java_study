# 场景
往往在我们的系统的多个核心流程中会有一部分与之关系不大的相同的横切流程，例如权限认证，事务处理。因此我们一般会抽象这些相同的比较次要交给spring aop的Handler来
同意处理这些横切流程。

# 案例流程
Hostess对象是Master接口的实现，主要实现WalkDog()和shopping(),而WalkDog()方法则是调用Dog接口的实现类bark()