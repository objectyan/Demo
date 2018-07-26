package com.baidu.tts.auth;

import com.baidu.tts.auth.C4978b.C4976a;
import com.baidu.tts.auth.C4981c.C4980a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p218b.p219a.p223b.C5008e.C5006b;
import com.baidu.tts.p218b.p219a.p223b.C5013f.C5010b;
import com.baidu.tts.p221k.C4977b;
import com.baidu.tts.p221k.C5111c;
import com.baidu.tts.p225m.C5141b;
import com.baidu.tts.p225m.C5148j;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5095m;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p236h.p238b.C5106a;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.tools.StringTool;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: AuthClient */
/* renamed from: com.baidu.tts.auth.a */
public class C4974a {
    /* renamed from: a */
    private static volatile C4974a f20674a = null;
    /* renamed from: b */
    private C5111c<C4981c, C4980a> f20675b = new C5111c();
    /* renamed from: c */
    private C5111c<C4978b, C4976a> f20676c = new C5111c();

    /* compiled from: AuthClient */
    /* renamed from: com.baidu.tts.auth.a$a */
    private class C4972a implements Callable<C4976a> {
        /* renamed from: a */
        final /* synthetic */ C4974a f20670a;
        /* renamed from: b */
        private C5006b f20671b;

        public /* synthetic */ Object call() throws Exception {
            return m16564a();
        }

        public C4972a(C4974a c4974a, C5006b c5006b) {
            this.f20670a = c4974a;
            this.f20671b = c5006b;
        }

        /* renamed from: a */
        public C4976a m16564a() throws Exception {
            C4976a c4976a = new C4976a();
            C5106a g = C5107b.m17306a().m17315g();
            if (g == null) {
                c4976a.m16579a(C5105c.m17295a().m17302b(C5097n.APP_RESOURCE_IS_NULL));
                return c4976a;
            }
            String g2 = this.f20671b.m16800g();
            String f = this.f20671b.m16798f();
            if (StringTool.isEmpty(f)) {
                f = g.m17305b();
            }
            LoggerProxy.m17001d("AuthClient", "appCode=" + g2);
            LoggerProxy.m17001d("AuthClient", "licenseFilePath=" + f);
            C4977b c4978b = new C4978b();
            c4978b.m16590a(g2);
            c4978b.m16592b(f);
            return (C4976a) this.f20670a.f20676c.m17338a(c4978b);
        }
    }

    /* compiled from: AuthClient */
    /* renamed from: com.baidu.tts.auth.a$b */
    private class C4973b implements Callable<C4980a> {
        /* renamed from: a */
        final /* synthetic */ C4974a f20672a;
        /* renamed from: b */
        private C5010b f20673b;

        public /* synthetic */ Object call() throws Exception {
            return m16565a();
        }

        public C4973b(C4974a c4974a, C5010b c5010b) {
            this.f20672a = c4974a;
            this.f20673b = c5010b;
        }

        /* renamed from: a */
        public C4980a m16565a() throws Exception {
            String e = this.f20673b.m16829e();
            String a = this.f20673b.m16817a();
            String b = this.f20673b.m16821b();
            LoggerProxy.m17001d("AuthClient", "pid=" + e);
            LoggerProxy.m17001d("AuthClient", "ak=" + a);
            LoggerProxy.m17001d("AuthClient", "sk=" + b);
            C4977b c4981c = new C4981c();
            c4981c.m16605a(e);
            c4981c.m16607b(a);
            c4981c.m16609c(b);
            return (C4980a) this.f20672a.f20675b.m17338a(c4981c);
        }
    }

    private C4974a() {
    }

    /* renamed from: a */
    public static C4974a m16566a() {
        if (f20674a == null) {
            synchronized (C4974a.class) {
                if (f20674a == null) {
                    f20674a = new C4974a();
                }
            }
        }
        return f20674a;
    }

    /* renamed from: a */
    public AuthInfo m16571a(C5095m c5095m, C5148j c5148j) {
        C5141b a = c5148j.m17449a();
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(c5095m);
        switch (c5095m) {
            case ONLINE:
                authInfo.setOnlineResult(m16574a(a.m17396a()));
                return authInfo;
            case OFFLINE:
                authInfo.setOfflineResult(m16573a(a.m17399b()));
                return authInfo;
            case MIX:
                return m16572a(a);
            default:
                return authInfo;
        }
    }

    /* renamed from: a */
    public C4980a m16574a(C5010b c5010b) {
        C4980a c4980a = new C4980a();
        try {
            return (C4980a) m16568a(new C4973b(this, c5010b), C5094l.DEFAULT.m17279a());
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e));
            return c4980a;
        } catch (ExecutionException e2) {
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_EXECUTION_EXCEPTION, e2.getCause()));
            return c4980a;
        } catch (Throwable e3) {
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_TIMEOUT_EXCEPTION, e3));
            return c4980a;
        } catch (Throwable e32) {
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_CANCELLATION_EXCEPTION, e32));
            return c4980a;
        }
    }

    /* renamed from: a */
    public C4976a m16573a(C5006b c5006b) {
        C4976a c4976a = new C4976a();
        try {
            return (C4976a) m16568a(new C4972a(this, c5006b), C5094l.DEFAULT.m17279a());
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            c4976a.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e));
            return c4976a;
        } catch (ExecutionException e2) {
            c4976a.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_EXECUTION_EXCEPTION, e2.getCause()));
            return c4976a;
        } catch (Throwable e3) {
            c4976a.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_TIMEOUT_EXCEPTION, e3));
            return c4976a;
        } catch (Throwable e32) {
            c4976a.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e32));
            return c4976a;
        }
    }

    /* renamed from: a */
    public AuthInfo m16572a(final C5141b c5141b) {
        C4976a c4976a;
        LoggerProxy.m17001d("AuthClient", "enter authMix");
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        FutureTask futureTask = new FutureTask(new Callable<C4980a>(this) {
            /* renamed from: c */
            final /* synthetic */ C4974a f20665c;

            public /* synthetic */ Object call() throws Exception {
                return m16562a();
            }

            /* renamed from: a */
            public C4980a m16562a() throws Exception {
                try {
                    C4980a a = this.f20665c.m16574a(c5141b.m17396a());
                    return a;
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        FutureTask futureTask2 = new FutureTask(new Callable<C4976a>(this) {
            /* renamed from: c */
            final /* synthetic */ C4974a f20668c;

            public /* synthetic */ Object call() throws Exception {
                return m16563a();
            }

            /* renamed from: a */
            public C4976a m16563a() throws Exception {
                try {
                    C4976a a = this.f20668c.m16573a(c5141b.m17399b());
                    return a;
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        try {
            LoggerProxy.m17001d("AuthClient", "+ await");
            countDownLatch.await();
            LoggerProxy.m17001d("AuthClient", "- await");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            futureTask2.cancel(true);
        }
        C4980a c4980a = new C4980a();
        LoggerProxy.m17001d("AuthClient", "+ mix online get onlineResult=" + c4980a);
        try {
            c4980a = (C4980a) futureTask.get();
        } catch (Throwable e2) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e2));
        } catch (ExecutionException e3) {
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_EXECUTION_EXCEPTION, e3.getCause()));
        } catch (Throwable e22) {
            c4980a.m16596a(C5105c.m17295a().m17300a(C5097n.ONLINE_AUTH_CANCELLATION_EXCEPTION, e22));
        }
        LoggerProxy.m17001d("AuthClient", "- online get");
        C4976a c4976a2 = new C4976a();
        LoggerProxy.m17001d("AuthClient", "+ mix offline get offlineResult=" + c4976a2);
        try {
            c4976a = (C4976a) futureTask2.get();
        } catch (Throwable e222) {
            Thread.currentThread().interrupt();
            futureTask2.cancel(true);
            c4976a2.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e222));
            c4976a = c4976a2;
        } catch (ExecutionException e32) {
            c4976a2.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_EXECUTION_EXCEPTION, e32.getCause()));
            c4976a = c4976a2;
        } catch (Throwable e2222) {
            c4976a2.m16579a(C5105c.m17295a().m17300a(C5097n.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e2222));
            c4976a = c4976a2;
        }
        LoggerProxy.m17001d("AuthClient", "- offline get");
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(C5095m.MIX);
        authInfo.setOnlineResult(c4980a);
        authInfo.setOfflineResult(c4976a);
        LoggerProxy.m17001d("AuthClient", "end authMix");
        return authInfo;
    }

    /* renamed from: a */
    private <T> T m16568a(Callable<T> callable, long j) throws InterruptedException, ExecutionException, TimeoutException {
        return m16569a((Callable) callable).get(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private <T> FutureTask<T> m16569a(Callable<T> callable) {
        Object futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        return futureTask;
    }

    /* renamed from: b */
    public void m16575b() {
        if (this.f20675b != null) {
            this.f20675b.m17339a();
        }
        if (this.f20676c != null) {
            this.f20676c.m17339a();
        }
    }
}
