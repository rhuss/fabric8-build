package io.fabric8.kit.config.image;

import org.junit.Test;

/**
 * Tests the health check configuration
 */
public class HealthCheckConfigTest {

    @Test
    public void testGoodHealthCheck1() {
        new HealthCheckConfiguration.Builder()
                .cmd("exit 0")
                .build()
                .validate();
    }

    @Test
    public void testGoodHealthCheck2() {
        new HealthCheckConfiguration.Builder()
                .cmd("exit 0")
                .retries(1)
                .build()
                .validate();
    }

    @Test
    public void testGoodHealthCheck3() {
        new HealthCheckConfiguration.Builder()
                .cmd("exit 0")
                .retries(1)
                .interval("2s")
                .build()
                .validate();
    }

    @Test
    public void testGoodHealthCheck4() {
        new HealthCheckConfiguration.Builder()
                .cmd("exit 0")
                .retries(1)
                .interval("2s")
                .timeout("3s")
                .build()
                .validate();
    }

    @Test
    public void testGoodHealthCheck5() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.cmd)
                .cmd("exit 0")
                .retries(1)
                .interval("2s")
                .timeout("3s")
                .build()
                .validate();
    }

    @Test
    public void testGoodHealthCheck6() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.none)
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck1() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.none)
                .interval("2s")
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck2() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.none)
                .retries(1)
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck3() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.none)
                .timeout("3s")
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck4() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.none)
                .cmd("echo a")
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck5() {
        new HealthCheckConfiguration.Builder()
                .build()
                .validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadHealthCheck6() {
        new HealthCheckConfiguration.Builder()
                .mode(HealthCheckMode.cmd)
                .build()
                .validate();
    }

}
