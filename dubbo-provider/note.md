# dubbo learning 笔记

## 启动时检查

dubbo缺省会在启动时检查依赖的服务是否可用，不可用时抛出异常，组织spring初始化完成，以便上线时能及早发现问题，默认check="true"。
可以通过check="false"关闭检查。比如，测试时有些服务不用关系，或者出现循环依赖，必须有一方先启动；spring容器是懒加载的，
或通过API编程延迟引用服务，请关闭check，
