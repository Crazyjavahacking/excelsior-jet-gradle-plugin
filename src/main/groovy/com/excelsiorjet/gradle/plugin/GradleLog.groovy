package com.excelsiorjet.gradle.plugin

import com.excelsiorjet.api.log.Log
import org.gradle.api.logging.Logger

/**
 * Implementation of {@code Log} that redirects logs into gradle logging system
 */
class GradleLog extends Log {

    private final Logger log;

    GradleLog(Logger log) {
        this.log = log
    }

    @Override
    void debug(String msg, Throwable t) {
        log.debug(msg, t)
    }

    @Override
    void info(String msg) {
        log.quiet(msg)
    }

    @Override
    void warn(String msg) {
        log.warn(msg)
    }

    @Override
    void warn(String msg, Throwable t) {
        log.warn(msg, t)
    }

    @Override
    void error(String msg) {
        log.error(msg)
    }

}
