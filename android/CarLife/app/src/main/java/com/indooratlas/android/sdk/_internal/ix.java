package com.indooratlas.android.sdk._internal;

import com.indooratlas.android.sdk._internal.il.C59811;
import com.indooratlas.android.sdk._internal.il.C59822;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ix {
    /* renamed from: a */
    private static final Logger f24422a = Logger.getLogger(ix.class.getName());

    private ix() {
    }

    /* renamed from: a */
    public static ip m21259a(jd jdVar) {
        if (jdVar != null) {
            return new iz(jdVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: a */
    public static io m21258a(jc jcVar) {
        if (jcVar != null) {
            return new iy(jcVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    /* renamed from: a */
    public static jc m21260a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        final je c = m21263c(socket);
        final OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new C59811(c, new jc() {
                public final void a_(in inVar, long j) throws IOException {
                    jf.m21314a(inVar.f24392b, 0, j);
                    while (j > 0) {
                        c.mo4773f();
                        ja jaVar = inVar.f24391a;
                        int min = (int) Math.min(j, (long) (jaVar.f24431c - jaVar.f24430b));
                        outputStream.write(jaVar.f24429a, jaVar.f24430b, min);
                        jaVar.f24430b += min;
                        j -= (long) min;
                        inVar.f24392b -= (long) min;
                        if (jaVar.f24430b == jaVar.f24431c) {
                            inVar.f24391a = jaVar.m21304a();
                            jb.m21308a(jaVar);
                        }
                    }
                }

                public final void flush() throws IOException {
                    outputStream.flush();
                }

                public final void close() throws IOException {
                    outputStream.close();
                }

                /* renamed from: a */
                public final je mo4733a() {
                    return c;
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            });
        }
        throw new IllegalArgumentException("out == null");
    }

    /* renamed from: b */
    public static jd m21262b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        final je c = m21263c(socket);
        final InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new C59822(c, new jd() {
                /* renamed from: a */
                public final long mo4730a(in inVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        c.mo4773f();
                        ja f = inVar.m21205f(1);
                        int read = inputStream.read(f.f24429a, f.f24431c, (int) Math.min(j, (long) (2048 - f.f24431c)));
                        if (read == -1) {
                            return -1;
                        }
                        f.f24431c += read;
                        inVar.f24392b += (long) read;
                        return (long) read;
                    }
                }

                public final void close() throws IOException {
                    inputStream.close();
                }

                /* renamed from: a */
                public final je mo4731a() {
                    return c;
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            });
        }
        throw new IllegalArgumentException("in == null");
    }

    /* renamed from: c */
    private static il m21263c(final Socket socket) {
        return new il() {
            /* renamed from: a */
            protected final IOException mo4774a(IOException iOException) {
                IOException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* renamed from: a */
            protected final void mo4775a() {
                try {
                    socket.close();
                } catch (Throwable e) {
                    ix.f24422a.log(Level.WARNING, "Failed to close timed out socket " + socket, e);
                } catch (Throwable e2) {
                    if (e2.getCause() == null || e2.getMessage() == null || !e2.getMessage().contains("getsockname failed")) {
                        throw e2;
                    }
                    ix.f24422a.log(Level.WARNING, "Failed to close timed out socket " + socket, e2);
                }
            }
        };
    }
}
