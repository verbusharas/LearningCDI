package lt.verbus.beans;

import lt.verbus.annotations.Protokoluojamas;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

//Bind interceptor to this class
@Protokoluojamas
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class ProtokoluojamasInterceptor {

    @Inject
    private Logger protokoluotojas;

    //Could populate this from DB or security manager
    // with name of currently executing user
    private String vartotojas = "Sarunas";

    //This method will be called and passed invocation context by container
    @AroundInvoke
    public Object protokoluotiMetodoKvietima(InvocationContext kontekstas) throws Exception{
        //Log for example user who called method and time
        protokoluotojas.log(Level.INFO, "Vartotojas {0} iškvietė {1} metodą laiku: {2}", new Object[]{vartotojas, kontekstas.getMethod().getName(), LocalDate.now()});
        return kontekstas.proceed();
    }

}
