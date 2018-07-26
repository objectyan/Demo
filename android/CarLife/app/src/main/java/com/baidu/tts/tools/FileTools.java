package com.baidu.tts.tools;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileTools {
    public static boolean isFileExist(String path) {
        if (new File(path).exists()) {
            return true;
        }
        return false;
    }

    public static boolean isFileExist(Object... args) {
        File file;
        if (args.length == 1) {
            Object obj = args[0];
            if (obj instanceof File) {
                file = (File) obj;
            } else if (obj instanceof String) {
                file = createFile((String) obj);
            } else {
                file = null;
            }
        } else if (args.length == 2) {
            file = createFile((String) args[0], (String) args[1]);
        } else {
            throw new UnknownError();
        }
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    public static String jointPathAndName(String path, String name) {
        if (path.endsWith(File.separator)) {
            return path + name;
        }
        return path + File.separator + name;
    }

    public static boolean deleteFile(String path) {
        return deleteFile(createFile(path));
    }

    public static boolean deleteFile(File file) {
        return !file.exists() || file.delete();
    }

    public static boolean fileCopy(String source, String target) throws FileNotFoundException {
        return fileCopy(createFile(source), createFile(target));
    }

    public static boolean fileCopy(String sPath, String sName, String tPath, String tName) throws FileNotFoundException {
        return fileCopy(createFile(sPath, sName), createFile(tPath, tName));
    }

    public static boolean fileCopy(FileDescriptor source, FileDescriptor target) {
        return fileCopy(new FileInputStream(source), new FileOutputStream(target));
    }

    public static boolean fileCopy(File source, File target) throws FileNotFoundException {
        return fileCopy(new FileInputStream(source), new FileOutputStream(target));
    }

    public static boolean fileCopy(FileInputStream source, FileOutputStream target) {
        boolean z = false;
        try {
            z = fileCopy(source.getChannel(), target.getChannel());
            try {
                source.close();
                target.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            try {
                source.close();
                target.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                source.close();
                target.close();
            } catch (IOException e32) {
                e32.printStackTrace();
            }
            throw th;
        }
        return z;
    }

    public static boolean fileCopy(FileChannel source, FileChannel target) {
        try {
            source.transferTo(0, source.size(), target);
            try {
                source.close();
                target.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                source.close();
                target.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            try {
                source.close();
                target.close();
                return true;
            } catch (IOException e32) {
                e32.printStackTrace();
                return false;
            }
        }
    }

    public static boolean writeFile(String data, File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createDir(String path) {
        new File(path).mkdirs();
    }

    public static String extractFileName(String fullName) {
        return fullName.substring(fullName.lastIndexOf(File.separator) + 1);
    }

    public static File getFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (path.endsWith(File.separator)) {
                file.mkdirs();
            } else {
                File file2 = new File(path.substring(0, path.lastIndexOf(File.separator)));
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static File getFile(String path, String fileName) {
        return getFile(jointPathAndName(path, fileName));
    }

    public static File createFile(String absPath) {
        return getFile(absPath);
    }

    public static File createFile(String path, String name) {
        return getFile(jointPathAndName(path, name));
    }
}
