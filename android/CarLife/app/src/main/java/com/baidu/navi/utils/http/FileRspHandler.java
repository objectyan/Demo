package com.baidu.navi.utils.http;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

public class FileRspHandler extends BaseRspHandler {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "plugin";
    private static final String TEMP_SUFFIX = ".download";
    private boolean isStop = false;
    private long mDownloadSize;
    private File mFile;
    private long mNetworkSpeed;
    private long mPreviousFileSize;
    private long mPreviousTime;
    private File mTempFile;
    private long mTotalSize;
    private long mTotalTime;
    private String md5;

    class CloseTask extends Thread {
        InputStream inputStream = null;

        public CloseTask(InputStream input) {
            this.inputStream = input;
        }

        public void run() {
            if (this.inputStream != null) {
                try {
                    this.inputStream.close();
                } catch (Exception e) {
                }
            }
        }
    }

    private class ProgressReportingRandomAccessFile extends RandomAccessFile {
        private int progress = 0;

        public ProgressReportingRandomAccessFile(File file, String mode) throws FileNotFoundException {
            super(file, mode);
        }

        public void write(byte[] buffer, int offset, int count) throws IOException {
            super.write(buffer, offset, count);
            this.progress += count;
            FileRspHandler.this.mTotalTime = System.currentTimeMillis() - FileRspHandler.this.mPreviousTime;
            FileRspHandler.this.mDownloadSize = ((long) this.progress) + FileRspHandler.this.mPreviousFileSize;
            if (FileRspHandler.this.mTotalTime > 0) {
                FileRspHandler.this.mNetworkSpeed = (long) (((double) (((long) this.progress) / FileRspHandler.this.mTotalTime)) / 1.024d);
            }
        }
    }

    private void copyStream(org.apache.http.HttpEntity r12) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0004 in list [B:18:0x005c]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
*/
        /*
        r11 = this;
        r1 = r11.isStop;
        if (r1 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r8 = r12.getContent();
        r10 = new com.baidu.navi.utils.http.FileRspHandler$ProgressReportingRandomAccessFile;
        r1 = r11.mTempFile;
        r2 = "rw";
        r10.<init>(r1, r2);
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r1];
        r2 = r10.length();
        r10.seek(r2);
        r2 = java.lang.System.currentTimeMillis();
        r11.mPreviousTime = r2;
        r9 = 0;
    L_0x0025:
        r1 = r11.isStop;	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x003c;	 Catch:{ all -> 0x0074 }
    L_0x0029:
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.isInterrupted();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x003c;	 Catch:{ all -> 0x0074 }
    L_0x0033:
        r1 = 0;	 Catch:{ all -> 0x0074 }
        r2 = r0.length;	 Catch:{ all -> 0x0074 }
        r9 = r8.read(r0, r1, r2);	 Catch:{ all -> 0x0074 }
        r1 = -1;	 Catch:{ all -> 0x0074 }
        if (r9 != r1) goto L_0x0065;	 Catch:{ all -> 0x0074 }
    L_0x003c:
        r1 = r11.isStop;	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0055;	 Catch:{ all -> 0x0074 }
    L_0x0040:
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.isInterrupted();	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0055;	 Catch:{ all -> 0x0074 }
    L_0x004a:
        r1 = new java.lang.Throwable;	 Catch:{ all -> 0x0074 }
        r2 = "stop by interrupted";	 Catch:{ all -> 0x0074 }
        r1.<init>(r2);	 Catch:{ all -> 0x0074 }
        r11.handlePauseMessage(r1);	 Catch:{ all -> 0x0074 }
    L_0x0055:
        if (r10 == 0) goto L_0x005a;
    L_0x0057:
        r10.close();
    L_0x005a:
        if (r8 == 0) goto L_0x0004;
    L_0x005c:
        r1 = new com.baidu.navi.utils.http.FileRspHandler$CloseTask;
        r1.<init>(r8);
        r1.start();
        goto L_0x0004;
    L_0x0065:
        r1 = 0;
        r10.write(r0, r1, r9);	 Catch:{ all -> 0x0074 }
        r2 = r11.mTotalSize;	 Catch:{ all -> 0x0074 }
        r4 = r11.mDownloadSize;	 Catch:{ all -> 0x0074 }
        r6 = r11.mNetworkSpeed;	 Catch:{ all -> 0x0074 }
        r1 = r11;	 Catch:{ all -> 0x0074 }
        r1.handleProgressMessage(r2, r4, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0025;
    L_0x0074:
        r1 = move-exception;
        if (r10 == 0) goto L_0x007a;
    L_0x0077:
        r10.close();
    L_0x007a:
        if (r8 == 0) goto L_0x0084;
    L_0x007c:
        r2 = new com.baidu.navi.utils.http.FileRspHandler$CloseTask;
        r2.<init>(r8);
        r2.start();
    L_0x0084:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navi.utils.http.FileRspHandler.copyStream(org.apache.http.HttpEntity):void");
    }

    public FileRspHandler(String dstFilePath, String tempFilePath, long fileSize) {
        this.mFile = new File(dstFilePath);
        this.mTempFile = new File(tempFilePath);
        this.mTotalSize = fileSize;
        if (this.mTempFile.exists()) {
            this.mPreviousFileSize = this.mTempFile.length();
        }
    }

    public FileRspHandler(String dstFilePath, String tempFilePath) {
        this.mFile = new File(dstFilePath);
        this.mTempFile = new File(tempFilePath);
        if (this.mTempFile.exists()) {
            this.mPreviousFileSize = this.mTempFile.length();
        }
    }

    public FileRspHandler(String dstFilePath, String tempFilePath, long fileSize, String md5) {
        this.mFile = new File(dstFilePath);
        this.mTempFile = new File(tempFilePath);
        this.mTotalSize = fileSize;
        if (this.mTempFile.exists()) {
            this.mPreviousFileSize = this.mTempFile.length();
        }
        this.md5 = md5;
    }

    public void stop() {
        handlePauseMessage(new Throwable("stop by call the stop method"));
        this.isStop = true;
    }

    public long getDownloadSize() {
        return this.mDownloadSize;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public double getDownloadSpeed() {
        return (double) this.mNetworkSpeed;
    }

    public long getPreviousFileSize() {
        return this.mPreviousFileSize;
    }

    public long getTotalTime() {
        return this.mTotalTime;
    }

    public File getTempFile() {
        return this.mTempFile;
    }

    public void onPause(Throwable pauseReason) {
    }

    public void handlePauseMessage(Throwable error) {
        LogUtil.m15791e(TAG, getClass().getName() + ":onPause");
        onPause(error);
    }

    protected void handleResponse(HttpResponse response) {
        if (!this.isStop) {
            StatusLine status = response.getStatusLine();
            int statusCode = status.getStatusCode();
            if (statusCode == 200 || statusCode == 206) {
                HttpEntity entity = response.getEntity();
                Throwable error = null;
                if (entity != null) {
                    try {
                        getFileSize(entity);
                        LogUtil.m15791e(TAG, "get file size end");
                        copyStream(entity);
                        LogUtil.m15791e(TAG, "copy stream end");
                        ensureFinishDownload();
                        LogUtil.m15791e(TAG, "ensureFinishDownload end");
                    } catch (Exception e) {
                        Throwable e2 = e;
                        if (e2 == null || e2.getMessage() == null) {
                            e2 = new Exception("unknow error when handle get fiel");
                        }
                        error = e2;
                    }
                } else {
                    error = new NullPointerException("the http entity is null!");
                }
                if (error != null) {
                    handlePauseMessage(error);
                    return;
                }
                return;
            }
            handlePauseMessage(new HttpResponseException(status.getStatusCode(), status.getReasonPhrase()));
        }
    }

    private void getFileSize(HttpEntity entity) throws Exception {
        if (!this.isStop) {
            long contentLenght = entity.getContentLength();
            if (contentLenght <= 0) {
                throw new IOException("can not get the file size!");
            }
            this.mTotalSize = this.mPreviousFileSize + contentLenght;
        }
    }

    private void ensureFinishDownload() {
        if (this.isStop && this.mTotalSize != this.mDownloadSize) {
            return;
        }
        if (this.mTotalSize != this.mDownloadSize) {
            handleFailureMessage(new Throwable("the download size not equal the given total size"));
        } else if (copyFile(this.mFile, this.mTempFile)) {
            if (this.mTempFile.exists()) {
                this.mTempFile.delete();
            }
            if (TextUtils.isEmpty(this.md5)) {
                handleSuccessMessage(this.mFile.getAbsolutePath());
                return;
            }
            String downloadFileMd5 = FileUtils.getMd5ByFile(this.mFile.getAbsolutePath());
            if (TextUtils.isEmpty(downloadFileMd5)) {
                handleFailureMessage(new Throwable("can not calc the download file md5"));
            } else if (downloadFileMd5.equals(this.md5)) {
                handleSuccessMessage(this.mFile.getAbsolutePath());
                LogUtil.m15791e(TAG, "success");
            } else if (!downloadFileMd5.equals(this.md5)) {
                handleFailureMessage(new Throwable("the download file md5 is not equal the given md5 value"));
            }
        } else {
            handleFailureMessage(new Throwable("can not copy the temp file to dst file"));
        }
    }

    private boolean copyFile(File dstFile, File srcFile) {
        if (dstFile != null && dstFile.exists()) {
            dstFile.delete();
        }
        boolean hasCopy = srcFile.renameTo(dstFile);
        if (!hasCopy) {
            FileChannel srcChannel = null;
            FileChannel dstChannel = null;
            try {
                srcChannel = new FileInputStream(srcFile).getChannel();
                dstChannel = new FileOutputStream(dstFile).getChannel();
                dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
                hasCopy = true;
                if (srcChannel != null) {
                    try {
                        srcChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (dstChannel != null) {
                    try {
                        dstChannel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                hasCopy = false;
                if (srcChannel != null) {
                    try {
                        srcChannel.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                }
                if (dstChannel != null) {
                    try {
                        dstChannel.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (srcChannel != null) {
                    try {
                        srcChannel.close();
                    } catch (IOException e2222) {
                        e2222.printStackTrace();
                    }
                }
                if (dstChannel != null) {
                    try {
                        dstChannel.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                }
            }
        }
        return hasCopy;
    }
}
