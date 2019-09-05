package top.ljming.learning.indepth.concurrent;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ThreadPool {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    private static ConcurrentHashMap<Integer, User> userMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name_" + i);
            userList.add(user);
        }

        userList.forEach(user -> executorService.submit(new Task(user)));
        executorService.shutdown();
        System.out.println("executorService shutdown");

        for (int i = 0; i < 20; i++) {
            if (null != userMap.get(i)) {
                userMap.put(i, new User(i, "name_xxx" + i));
            }
        }

        System.out.println(JSONObject.toJSONString(userMap));
    }

    @Data
    static class User {
        int id;
        String name;

        public User(){}

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Task implements Runnable {

        private User user;

        private Task(User u) {
            this.user = u;
        }


        public void run() {
            System.out.println("current thread: " + Thread.currentThread().getName());
            System.out.println("user: " + user.toString());
            userMap.put(user.getId(), user);
        }

    }
}
