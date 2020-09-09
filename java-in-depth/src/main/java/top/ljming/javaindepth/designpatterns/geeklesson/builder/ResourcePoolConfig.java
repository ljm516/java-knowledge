package top.ljming.javaindepth.designpatterns.geeklesson.builder;

import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Builder模式.
 *
 * @author ljming
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int minTotal;
    private int maxIdle;
    private int minIdle;
    private long keepAlive;
    private TimeUnit timeUnit;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.minTotal = builder.minTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
        this.keepAlive = builder.keepAlive;
        this.timeUnit = builder.timeUnit;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private static final int DEFAULT_MIN_TOTAL = 1;
        private static final int DEFAULT_KEEPALIVE = 60;
        private static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int minTotal = DEFAULT_MIN_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;
        private long keepAlive = DEFAULT_KEEPALIVE;
        private TimeUnit timeUnit = DEFAULT_TIMEUNIT;


        public ResourcePoolConfig builder() {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("....");
            }
            if (minTotal > maxTotal) {
                throw new IllegalArgumentException("....");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("....");
            }
            /*...*/
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("....");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("....");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMinTotal(int minTotal) {
            if (minTotal < 0) {
                throw new IllegalArgumentException("....");
            }
            this.minTotal = minTotal;
            return this;
        }
        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("....");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("....");
            }
            this.minIdle = minIdle;
            return this;
        }

        public Builder setKeepAlive(long keepAlive) {
            if (keepAlive < 0) {
                throw new IllegalArgumentException("....");
            }
            this.keepAlive = keepAlive;
            return this;
        }

        public Builder setTimeUnit(TimeUnit timeUnit) {
            if (null == timeUnit) {
                throw new IllegalArgumentException("....");
            }
            this.timeUnit = timeUnit;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new Builder()
                .setName("resourcePoolConfig")
                .setMaxTotal(10)
                .setMinTotal(5)
                .setMaxIdle(5)
                .setMinIdle(0)
                .setKeepAlive(60)
                .setTimeUnit(TimeUnit.SECONDS)
                .builder();
    }
}
