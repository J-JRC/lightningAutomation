package com.reporting;

import static com.enums.ContextConstant.LOG_LEVEL;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ReporterLog4J implements IReporter{
	private static final Logger LOG = LogManager.getLogger(ReporterLog4J.class);
	
	public ReporterLog4J (Map<String,String> params, String path) throws IOException{
		switch(params.get(LOG_LEVEL).toUpperCase()) 
        { 
            case "TRACE": 
            	Configurator.setRootLevel(Level.TRACE);
                break; 
            case "DEBUG": 
            	Configurator.setRootLevel(Level.DEBUG);
                break; 
            case "INFO": 
            	Configurator.setRootLevel((Level)Level.INFO);
                break; 
            case "WARN": 
            	Configurator.setRootLevel((Level)Level.WARN);
                break; 
            case "ERROR": 
            	Configurator.setRootLevel((Level)Level.ERROR);
                break; 
            case "FATAL": 
            	Configurator.setRootLevel((Level)Level.FATAL);
                break; 
            case "OFF": 
            	Configurator.setRootLevel((Level)Level.OFF);
                break; 
            default: 
            	Configurator.setRootLevel((Level)Level.INFO);
        } 
//		Logger.addAppender(new RollingFileAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"),  path));
	}

	@Override
	public void info(String msg) {
		LOG.info(msg);
	}
	
	@Override
	public void pass(String msg) {
		this.info(msg);
	}
	
	@Override
	public void warn(String msg) {
		LOG.warn(msg);
	}

	@Override
	public void fail(String msg) {
		LOG.error(msg);
	}

	@Override
	public void info(String msg, String details, File file) {
		LOG.info(msg + "\n" + details);
	}

	@Override
	public void warn(String msg, String details, File file) {
		LOG.warn(msg + "\n" + details);
	}
	
	@Override
	public void pass(String msg, String details, File file) {
		LOG.info(msg + "\n" + details);
	}

	@Override
	public void fail(String msg, String details, File file) {
		LOG.error(msg + "\n" + details);
	}

	@Override
	public void warn(String msg, Throwable t) {
		LOG.warn(msg,t);
	}

	@Override
	public void fail(String msg, Throwable t) {
		LOG.error(msg,t);
	}

	@Override
	public void warn(String msg, Throwable t, File file) {
		LOG.warn(msg,t);
	}

	@Override
	public void fail(String msg, Throwable t, File file) {
		LOG.error(msg,t);
	}

	@Override
	public void startTest(String testName, String desc, String[] groups, String packageLocation,
			String[] dependsOnMethods) {
		/**
		 * Won't Implement
		 */
	}

	@Override
	public void endReport(){
		/**
		 * Won't Implement
		 */
	}

	@Override
	public void endTest(String failureReason, String stackTrace) {
		/**
		 * Won't Implement
		 */
	}

}
