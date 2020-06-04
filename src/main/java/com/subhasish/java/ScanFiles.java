package com.subhasish.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.Logger;


public class ScanFiles {

    private static final Logger logger = ScanFilesLogger.getLogger(ScanFiles.class);

    private static void searchFiles(String folderPath, String searchString) throws IOException {
        List<String> list = new ArrayList<>();
        File folder = new File(folderPath);
        List<File> files = (List<File>) FileUtils.listFiles(folder, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        if (folder.isDirectory()) {
            for (File file : files) {
                try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
                    list = stream
                            .filter(line -> line.contains("\""))
                            .collect(Collectors.toList());
                    logger.info(" :::::::::::::File Name:" + file.getAbsolutePath());
                    for (String element : list) {
                        logger.info(" ::::::::::::::Line :" + element);
                    }

                    logger.info("\n");
                } catch (IOException e) {
                    logger.error(" ::::::::::::::Error :" + e.getMessage());
                }
            }
        }
        OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
        streamWriter.write(":::::::::: Scan Completed ::::::::::");
        streamWriter.write("\n");
        streamWriter.flush();
    }

    public static void main(String args[]) throws IOException {

        if (args.length == 0) {
            OutputStreamWriter streamWriter = new OutputStreamWriter(System.out);
            streamWriter.write(":::::::::: PATH cannot be empty ::::::::::");
            streamWriter.flush();
            System.exit(0);
        }
        searchFiles(new File(args[0]).getAbsolutePath(), "\"");
    }
}