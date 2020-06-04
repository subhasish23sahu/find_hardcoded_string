package com.subhasish.java;

import org.apache.log4j.Logger;


public class ScanFilesLogger {

public static Logger getLogger(Class className) {
return Logger.getLogger(className);
}
public static Logger getLogger(String name) {

return Logger.getLogger(name);
}
}